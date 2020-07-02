/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-02 14:49:00
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/cn/codingtalk/tacomallapimerchant/service/merchant/MerchantService.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapimerchant.service.merchant;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.codingtalk.tacomallentity.merchant.Merchant;
import cn.codingtalk.tacomallcommon.vo.ResponseVo;

public interface MerchantService extends IService<Merchant> {

    ResponseVo<String> login(String username, String password);

    ResponseVo<String> logout();

    ResponseVo<Merchant> info();
}
