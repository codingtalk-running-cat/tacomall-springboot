/***
 * @Author: 码上talk|RC
 * @Date: 2020-10-31 10:23:59
 * @LastEditTime: 2020-12-23 17:46:33
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/portal/src/main/java/store/tacomall/apiportal/strategy/impl/PageTransactionStrategyImpl.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiportal.strategy.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.entity.order.Order;
import store.tacomall.common.mapper.order.OrderMapper;
import store.tacomall.apiportal.strategy.PageStrategy;

@Component("pageTransaction")
public class PageTransactionStrategyImpl implements PageStrategy {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ResponseVo<Map<String, Object>> buildPage(JSONObject json) {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        map.put("orders", orderMapper.getOrders(
                new QueryWrapper<Order>().lambda().in(Order::getId, Arrays.asList(json.getString("ids").split(",")))));
        responseVo.setData(map);
        return responseVo;
    }
}
