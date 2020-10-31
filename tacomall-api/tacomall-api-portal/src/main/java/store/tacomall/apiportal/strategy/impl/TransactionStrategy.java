/***
 * @Author: 码上talk|RC
 * @Date: 2020-10-31 10:23:59
 * @LastEditTime: 2020-10-31 10:35:40
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/strategy/impl/TransactionStrategy.java
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
import store.tacomall.apiportal.strategy.Strategy;
import store.tacomall.apiportal.service.OrderService;

@Component("transaction")
public class TransactionStrategy implements Strategy {

    @Autowired
    private OrderService orderService;

    @Override
    public ResponseVo<Map<String, Object>> buildPage(JSONObject json) {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        map.put("order", orderService.getOrder(json).getData());
        responseVo.setData(map);
        return responseVo;
    }
}
