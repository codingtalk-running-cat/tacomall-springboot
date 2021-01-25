/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-15 15:06:46
 * @LastEditTime: 2021-01-19 14:21:01
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/controller/AuthController.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;
import com.alibaba.fastjson.JSONObject;

import store.tacomall.common.vo.ResponsePageVo;
import store.tacomall.common.entity.admin.AdminUser;
import store.tacomall.common.entity.admin.AdminAuthRole;
import store.tacomall.common.entity.admin.AdminAuthRule;
import store.tacomall.apiadmin.service.AdminUserService;
import store.tacomall.apiadmin.service.AdminAuthRoleService;
import store.tacomall.apiadmin.service.AdminAuthRuleService;

@Api(tags = "权限模块")
@RestController
@RequestMapping(value = "/admin/auth/")
public class AuthController {

        @Autowired
        private AdminUserService adminUserService;

        @Autowired
        private AdminAuthRoleService adminAuthRoleService;

        @Autowired
        private AdminAuthRuleService adminAuthRuleService;

        /***
         * @description: 用户分页
         * @param {type}
         * @return:
         */
        @ApiOperation(value = "用户分页", notes = "用户分页接口", httpMethod = "POST")
        @ApiImplicitParams({
                        @ApiImplicitParam(name = "pageIndex", value = "分页码数", required = true, paramType = "query"),
                        @ApiImplicitParam(name = "pageSize", value = "分页数量", required = true, paramType = "query"),
                        @ApiImplicitParam(name = "json", value = "查询条件", required = true, paramType = "body") })
        @PostMapping("adminUserPage")
        public ResponsePageVo<List<AdminUser>> adminUserPage(@RequestParam(value = "pageIndex") int pageIndex,
                        @RequestParam(value = "pageSize") int pageSize, @RequestBody JSONObject json) {
                return adminUserService.getAdminUserPage(pageIndex, pageSize, json);
        }

        /***
         * @description: 角色分页
         * @param {type}
         * @return:
         */
        @ApiOperation(value = "角色分页分页", notes = "角色分页接口", httpMethod = "POST")
        @ApiImplicitParams({
                        @ApiImplicitParam(name = "pageIndex", value = "分页码数", required = true, paramType = "query"),
                        @ApiImplicitParam(name = "pageSize", value = "分页数量", required = true, paramType = "query"),
                        @ApiImplicitParam(name = "json", value = "查询条件", required = true, paramType = "body") })
        @PostMapping("adminAuthRolePage")
        public ResponsePageVo<List<AdminAuthRole>> adminAuthRolePage(@RequestParam(value = "pageIndex") int pageIndex,
                        @RequestParam(value = "pageSize") int pageSize, @RequestBody JSONObject json) {
                return adminAuthRoleService.getAdminAuthRolePage(pageIndex, pageSize, json);
        }

        /***
         * @description: 权限分页
         * @param {type}
         * @return:
         */
        @ApiOperation(value = "权限分页分页", notes = "权限分页接口", httpMethod = "POST")
        @ApiImplicitParams({
                        @ApiImplicitParam(name = "pageIndex", value = "分页码数", required = true, paramType = "query"),
                        @ApiImplicitParam(name = "pageSize", value = "分页数量", required = true, paramType = "query"),
                        @ApiImplicitParam(name = "json", value = "查询条件", required = true, paramType = "body") })
        @PostMapping("adminAuthRulePage")
        public ResponsePageVo<List<AdminAuthRule>> adminAuthRulePage(@RequestParam(value = "pageIndex") int pageIndex,
                        @RequestParam(value = "pageSize") int pageSize, @RequestBody JSONObject json) {
                return adminAuthRuleService.getAdminAuthRulePage(pageIndex, pageSize, json);
        }
}
