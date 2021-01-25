/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-12-25 19:09:16
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/portal/src/main/java/store/tacomall/apiportal/service/CartService.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.entity.cart.Cart;

public interface CartService extends IService<Cart> {

    /***
     * @description: 添加购物车
     * @param {type}
     * @return:
     */
    ResponseVo<String> addCart(int goodsItemId, int quantity);

    /***
     * @description: 删除购物车
     * @param {type}
     * @return:
     */
    ResponseVo<Boolean> deleteCart(String cartIds);

    /***
     * @description: 获取用户购物车
     * @param {type}
     * @return:
     */
    ResponseVo<List<Cart>> getCarts(JSONObject json);

}
