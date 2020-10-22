/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-19 17:46:04
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/store/tacomall/apimerchant/shiro/MyShiroRealm.java
 * @Just do what I think it is right
 */
package store.tacomall.apimerchant.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.hutool.core.util.ObjectUtil;
import store.tacomall.entity.merchant.MerchantUser;
import store.tacomall.mapper.merchant.MerchantUserMapper;

public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private MerchantUserMapper merchantUserMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        MerchantUser merchantUser = merchantUserMapper
                .selectOne(new QueryWrapper<MerchantUser>().lambda().eq(MerchantUser::getUsername, username));
        if (ObjectUtil.isNull(merchantUser)) {
            throw new UnknownAccountException();
        }
        if (merchantUser.getStatus() == 0) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(merchantUser,
                merchantUser.getPasswd(), getName());
        return authenticationInfo;
    }
}
