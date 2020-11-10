/***
 * @Author: 码上talk|RC
 * @Date: 2020-10-30 11:32:27
 * @LastEditTime: 2020-10-30 17:55:28
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/strategy/impl/CheckoutStrategy.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiportal.strategy.impl;

import java.util.List;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.entity.cart.Cart;
import store.tacomall.apiportal.strategy.Strategy;
import store.tacomall.apiportal.service.CartService;

@Component("checkout")
public class CheckoutStrategy implements Strategy {

    @Autowired
    private CartService cartService;

    @Override
    public ResponseVo<Map<String, Object>> buildPage(JSONObject json) {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> amount = new HashMap<>();
        BigDecimal totalAmount = BigDecimal.ZERO;
        List<Cart> cart = cartService.getCart(json).getData();
        for (int i = 0; i < cart.size(); i++) {
            Cart currentCart = cart.get(i);
            totalAmount = totalAmount
                    .add(currentCart.getGoodsItem().getAmount().multiply(new BigDecimal(currentCart.getQuantity())));
        }
        amount.put("totalAmount", totalAmount);
        map.put("cart", cart);
        map.put("amount", amount);
        responseVo.setData(map);
        return responseVo.json();
    }
}
