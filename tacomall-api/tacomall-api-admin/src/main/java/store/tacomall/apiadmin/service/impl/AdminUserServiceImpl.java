/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-11-06 08:30:43
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-admin/src/main/java/store/tacomall/apiadmin/service/impl/AdminUserServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiadmin.service.impl;

import org.apache.shiro.authc.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import store.tacomall.entity.admin.AdminUser;
import store.tacomall.apiadmin.service.AdminUserService;
import store.tacomall.mapper.admin.AdminUserMapper;
import store.tacomall.common.util.PasswordUtil;
import store.tacomall.common.vo.ResponseVo;

@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {

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
        return responseVo.json();
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
        return responseVo.json();
    }

    /***
     * @description: 用户信息
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<AdminUser> info() {
        ResponseVo<AdminUser> responseVo = new ResponseVo<>();
        AdminUser user = (AdminUser) SecurityUtils.getSubject().getPrincipal();

        responseVo.setData(baseMapper.getAdminUser(user.getId()));
        return responseVo.json();
    }

}
