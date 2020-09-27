/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-29 09:15:01
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/service/CartService.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallentity.cart.Cart;

public interface CartService extends IService<Cart> {

    /***
     * @description: 添加购物车
     * @param {type}
     * @return:
     */
    ResponseVo<String> addCarts(List<Map<String, Object>> goodItems);

    /***
     * @description: 获取用户购物车
     * @param {type}
     * @return:
     */
    ResponseVo<List<Cart>> getCarts();

}
