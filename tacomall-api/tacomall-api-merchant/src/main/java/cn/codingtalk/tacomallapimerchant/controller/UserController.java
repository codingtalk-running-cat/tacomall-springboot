/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-02 14:49:14
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

import cn.codingtalk.tacomallapimerchant.service.merchant.MerchantService;
import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallentity.merchant.Merchant;

@RestController
@RequestMapping(value = "/merchant/user/")
public class UserController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping("login")
    public ResponseVo<String> login(@RequestParam(value = "username") String username,
            @RequestParam(value = "passwd") String passwd) {
        return merchantService.login(username, passwd);
    }

    @PostMapping("logout")
    public ResponseVo<String> logout() {
        return merchantService.logout();
    }

    @PostMapping("info")
    public ResponseVo<Merchant> info() {
        return merchantService.info();
    }
}
