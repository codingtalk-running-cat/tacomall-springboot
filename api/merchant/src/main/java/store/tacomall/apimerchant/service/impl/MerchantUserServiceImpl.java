/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-11-06 08:27:40
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/store/tacomall/apimerchant/service/impl/MerchantUserServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apimerchant.service.impl;

import org.apache.shiro.authc.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import store.tacomall.apimerchant.service.MerchantUserService;
import store.tacomall.common.entity.merchant.MerchantUser;
import store.tacomall.common.mapper.merchant.MerchantUserMapper;
import store.tacomall.common.util.PasswordUtil;
import store.tacomall.common.vo.ResponseVo;

@Service
public class MerchantUserServiceImpl extends ServiceImpl<MerchantUserMapper, MerchantUser>
        implements MerchantUserService {

    /***
     * @description: 用户登录
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<String> login(String username, String password) {
        ResponseVo<String> responseVo = new ResponseVo<>();
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken merchantUser = new UsernamePasswordToken(username, PasswordUtil.encode(password));
            subject.login(merchantUser);
            String authorization = (String) subject.getSession().getId();
            responseVo.setData(authorization);
        } catch (UnknownAccountException ue) {
            responseVo.setStatus(false);
            responseVo.setMessage("用户不存在");
        } catch (LockedAccountException le) {
            responseVo.setStatus(false);
            responseVo.setMessage("用户已冻结");
        } catch (IncorrectCredentialsException ie) {
            responseVo.setStatus(false);
            responseVo.setMessage("密码错误");
        }
        return responseVo;
    }

    /***
     * @description: 用户注销
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<String> logout() {
        ResponseVo<String> responseVo = new ResponseVo<>();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return responseVo;
    }

    /***
     * @description: 用户信息
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<MerchantUser> info() {
        ResponseVo<MerchantUser> responseVo = new ResponseVo<>();
        MerchantUser merchantUser = (MerchantUser) SecurityUtils.getSubject().getPrincipal();

        responseVo.setData(baseMapper.getMerchantUser(
                new QueryWrapper<MerchantUser>().lambda().eq(MerchantUser::getId, merchantUser.getId())));
        return responseVo;
    }

}
