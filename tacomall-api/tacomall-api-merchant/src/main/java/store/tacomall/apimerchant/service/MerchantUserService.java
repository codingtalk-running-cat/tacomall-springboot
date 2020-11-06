/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-11-06 08:21:43
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/store/tacomall/apimerchant/service/MerchantUserService.java
 * @Just do what I think it is right
 */
package store.tacomall.apimerchant.service;

import com.baomidou.mybatisplus.extension.service.IService;

import store.tacomall.entity.merchant.MerchantUser;
import store.tacomall.common.vo.ResponseVo;

public interface MerchantUserService extends IService<MerchantUser> {

    /***
     * @description: 用户登录
     * @param {type}
     * @return:
     */
    ResponseVo<String> login(String username, String password);

    /***
     * @description: 用户注销
     * @param {type}
     * @return:
     */
    ResponseVo<String> logout();

    /***
     * @description: 用户信息
     * @param {type}
     * @return:
     */
    ResponseVo<MerchantUser> info();
}
