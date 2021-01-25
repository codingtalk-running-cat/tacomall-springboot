/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-11-06 08:21:32
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/store/tacomall/apimerchant/controller/UserController.java
 * @Just do what I think it is right
 */
package store.tacomall.apimerchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.entity.merchant.MerchantUser;
import store.tacomall.apimerchant.annotation.LoginLogger;
import store.tacomall.apimerchant.service.MerchantUserService;

@Api(tags = "用户模块")
@RestController
@RequestMapping(value = "/merchant/user/")
public class UserController {

    @Autowired
    private MerchantUserService merchantUserService;

    /***
     * @description: 用户登录
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "商家用户登录", notes = "商家用户登录接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "username", value = "商户账号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "passwd", value = "商户密码", required = true, paramType = "query") })
    @LoginLogger()
    @PostMapping("login")
    public ResponseVo<String> login(@RequestParam(value = "username") String username,
            @RequestParam(value = "passwd") String passwd) {
        return merchantUserService.login(username, passwd);
    }

    /***
     * @description: 用户注销
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "商家用户注销", notes = "商家用户注销接口", httpMethod = "POST")
    @ApiImplicitParams({})
    @PostMapping("logout")
    public ResponseVo<String> logout() {
        return merchantUserService.logout();
    }

    /***
     * @description: 用户信息
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "商家用户信息", notes = "商家用户信息接口", httpMethod = "POST")
    @ApiImplicitParams({})
    @PostMapping("info")
    public ResponseVo<MerchantUser> info() {
        return merchantUserService.info();
    }
}
