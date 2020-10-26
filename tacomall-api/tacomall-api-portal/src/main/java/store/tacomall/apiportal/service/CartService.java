/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-26 19:19:21
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/CartService.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.entity.cart.Cart;

public interface CartService extends IService<Cart> {

    /***
     * @description: 添加购物车
     * @param {type}
     * @return:
     */
    ResponseVo<String> addCarts(int goodsItemId, int quantity);

    /***
     * @description: 获取用户购物车
     * @param {type}
     * @return:
     */
    ResponseVo<List<Map<String, Object>>> getCart();

}
