/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-02 14:27:53
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-admin/src/main/java/cn/codingtalk/tacomallapiadmin/service/admin/impl/AdminUserServiceImpl.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiadmin.service.admin.impl;

import org.apache.shiro.authc.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.codingtalk.tacomallcommon.utils.PasswordUtil;
import cn.codingtalk.tacomallentity.admin.AdminUser;
import cn.codingtalk.tacomallapiadmin.service.admin.AdminUserService;
import cn.codingtalk.tacomallmapper.admin.AdminUserMapper;
import cn.codingtalk.tacomallcommon.vo.ResponseVo;

@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {

    @Override
    public ResponseVo<String> login(String username, String password) {
        ResponseVo<String> responseVo = new ResponseVo<>();
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken adminUser = new UsernamePasswordToken(username, PasswordUtil.encode(password));
            subject.login(adminUser);
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

    @Override
    public ResponseVo<String> logout() {
        ResponseVo<String> responseVo = new ResponseVo<>();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return responseVo;
    }

    @Override
    public ResponseVo<AdminUser> info() {
        ResponseVo<AdminUser> responseVo = new ResponseVo<>();
        AdminUser user = (AdminUser) SecurityUtils.getSubject().getPrincipal();
        
        responseVo.setData(baseMapper.getUserInfo(user.getId()));
        return responseVo;
    }

}
