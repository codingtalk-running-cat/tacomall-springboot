/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: ,: 2020-10-21 15:07:11
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-api/tacomall-api-admin/src/main/java/store/tacomall/apiadmin/shiro/MyShiroRealm.java
 * @Just do what I think it is right
 */
package store.tacomall.apiadmin.shiro;

import java.util.List;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.hutool.core.util.ObjectUtil;

import store.tacomall.entity.admin.AdminUser;
import store.tacomall.entity.admin.AdminAuthRule;
import store.tacomall.mapper.admin.AdminUserMapper;

public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        AdminUser adminUser = (AdminUser) principal.getPrimaryPrincipal();
        try {
            authorizationInfo.addRole(adminUserMapper.getAdminUser(adminUser.getId()).getRole().getName());

            List<AdminAuthRule> adminAuthRules = adminUserMapper.getAdminUser(adminUser.getId()).getRule();
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
