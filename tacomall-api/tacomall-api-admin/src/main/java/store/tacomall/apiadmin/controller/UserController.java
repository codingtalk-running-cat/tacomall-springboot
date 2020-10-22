/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-19 16:37:30
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-admin/src/main/java/store/tacomall/apiadmin/controller/UserController.java
 * @Just do what I think it is right
 */
package store.tacomall.apiadmin.controller;

import store.tacomall.apiadmin.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.entity.admin.AdminUser;
import store.tacomall.apiadmin.annotation.LoginLogger;

@Api(tags = "用户模块")
@RestController
@RequestMapping(value = "/admin/user/")
public class UserController {

    @Autowired
    private AdminUserService adminUserService;

    /***
     * @description: 用户登录
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "平台用户登录", notes = "商家用户登录接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "username", value = "username", required = true, paramType = "path"),
            @ApiImplicitParam(name = "passwd", value = "passwd", required = true, paramType = "path") })
    @LoginLogger()
    @PostMapping("login")
    public ResponseVo<String> login(@RequestParam(value = "username") String username,
            @RequestParam(value = "passwd") String passwd) {
        return adminUserService.login(username, passwd);
    }

    /***
     * @description: 用户注销
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "商家用户注销", notes = "商家用户注销接口", httpMethod = "POST")
    @PostMapping("logout")
    public ResponseVo<String> logout() {
        return adminUserService.logout();
    }

    /***
     * @description: 用户信息
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "商家用户信息", notes = "商家用户信息接口", httpMethod = "POST")
    @ApiImplicitParams({})
    @PostMapping("info")
    public ResponseVo<AdminUser> info() {
        return adminUserService.info();
    }
}
