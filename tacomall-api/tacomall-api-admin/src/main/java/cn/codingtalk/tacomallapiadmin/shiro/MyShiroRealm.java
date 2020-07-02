/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-02 11:51:04
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-admin/src/main/java/cn/codingtalk/tacomallapiadmin/shiro/MyShiroRealm.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiadmin.shiro;

import java.util.List;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.codingtalk.tacomallcommon.utils.ObjectUtil;
import cn.codingtalk.tacomallentity.admin.AdminUser;
import cn.codingtalk.tacomallentity.admin.AdminAuthRule;
import cn.codingtalk.tacomallmapper.admin.AdminUserMapper;

public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        AdminUser adminUser = (AdminUser) principal.getPrimaryPrincipal();
        try {
            authorizationInfo.addRole(adminUserMapper.getUserInfo(adminUser.getId()).getRole().getName());

            List<AdminAuthRule> adminAuthRules = adminUserMapper.getUserInfo(adminUser.getId()).getRule();
            for (AdminAuthRule adminAuthRule : adminAuthRules) {
                authorizationInfo.addStringPermission(adminAuthRule.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        AdminUser adminUser = adminUserMapper
                .selectOne(new QueryWrapper<AdminUser>().lambda().eq(AdminUser::getUsername, username));
        if (ObjectUtil.isNull(adminUser)) {
            throw new UnknownAccountException();
        }
        if (adminUser.getStatus() == 0) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(adminUser, adminUser.getPasswd(),
                getName());
        return authenticationInfo;
    }
}
