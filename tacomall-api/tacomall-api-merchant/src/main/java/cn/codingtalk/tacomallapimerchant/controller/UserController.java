/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-09-27 15:36:42
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/cn/codingtalk/tacomallapimerchant/controller/UserController.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapimerchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallentity.merchant.MerchantUser;
import cn.codingtalk.tacomallapimerchant.annotation.LoginLogger;
import cn.codingtalk.tacomallapimerchant.service.merchant.MerchantUserService;

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
    @PostMapping("logout")
    public ResponseVo<String> logout() {
        return merchantUserService.logout();
    }

    /***
     * @description: 用户信息
     * @param {type}
     * @return:
     */
    @PostMapping("info")
    public ResponseVo<MerchantUser> info() {
        return merchantUserService.info();
    }
}
