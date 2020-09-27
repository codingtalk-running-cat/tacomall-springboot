/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-09-27 15:22:56
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/cn/codingtalk/tacomallapimerchant/service/merchant/impl/MerchantUserServiceImpl.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapimerchant.service.merchant.impl;

import org.apache.shiro.authc.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.codingtalk.tacomallapimerchant.service.merchant.MerchantUserService;
import cn.codingtalk.tacomallcommon.utils.PasswordUtil;
import cn.codingtalk.tacomallentity.merchant.MerchantUser;
import cn.codingtalk.tacomallmapper.merchant.MerchantUserMapper;
import cn.codingtalk.tacomallcommon.vo.ResponseVo;

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
        MerchantUser user = (MerchantUser) SecurityUtils.getSubject().getPrincipal();

        responseVo.setData(baseMapper.getUserInfo(user.getId()));
        return responseVo;
    }

}
