/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2021-01-18 16:34:31
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/service/impl/AdminUserServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiadmin.service.impl;

import java.util.List;

import cn.hutool.core.util.ObjectUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import store.tacomall.common.entity.admin.AdminAuthRule;
import store.tacomall.common.entity.admin.AdminUser;
import store.tacomall.apiadmin.service.AdminUserService;
import store.tacomall.common.mapper.admin.AdminUserMapper;
import store.tacomall.common.mapper.admin.AdminAuthRuleMapper;
import store.tacomall.common.util.PasswordUtil;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.vo.ResponsePageVo;

@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {

    @Autowired
    private AdminAuthRuleMapper adminAuthRuleMapper;

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
    public ResponseVo<AdminUser> info() {
        ResponseVo<AdminUser> responseVo = new ResponseVo<>();
        AdminUser user = (AdminUser) SecurityUtils.getSubject().getPrincipal();

        responseVo
                .setData(baseMapper.getUser(new QueryWrapper<AdminUser>().lambda().eq(AdminUser::getId, user.getId())));
        return responseVo;
    }

    /***
     * @description: 用户权限
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<List<AdminAuthRule>> rules() {
        ResponseVo<List<AdminAuthRule>> responseVo = new ResponseVo<>();
        AdminUser adminUser = (AdminUser) SecurityUtils.getSubject().getPrincipal();
        responseVo.setData(
                adminAuthRuleMapper.selectList(new QueryWrapper<AdminAuthRule>().lambda().inSql(AdminAuthRule::getId,
                        String.format("select rule_id from admin_auth_role_mapping_rule where role_id = '%s'",
                                adminUser.getAuthRoleId()))));
        return responseVo;
    }

    /***
     * @description: 用户分页
     * @param {type}
     * @return:
     */
    @Override
    public ResponsePageVo<List<AdminUser>> getAdminUserPage(int pageIndex, int pageSize, JSONObject json) {
        ResponsePageVo<List<AdminUser>> responsePageVo = new ResponsePageVo<>();
        Page<AdminUser> page = new Page<>(pageIndex, pageSize);
        LambdaQueryWrapper<AdminUser> q = new QueryWrapper<AdminUser>().lambda();
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").get("keyword"))) {
            q.like(AdminUser::getUsername, json.getJSONObject("query").get("keyword"));
        }
        IPage<AdminUser> result = this.baseMapper.getAdminUserPage(page, q);
        responsePageVo.setData(result.getRecords());
        responsePageVo.buildPage(result.getCurrent(), result.getSize(), result.getTotal());
        return responsePageVo;
    }

}
