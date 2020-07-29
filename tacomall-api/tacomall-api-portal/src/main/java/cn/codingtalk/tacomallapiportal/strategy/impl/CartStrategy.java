/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-23 11:21:48
 * @LastEditTime: 2020-07-24 10:32:09
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/strategy/impl/CartStrategy.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.strategy.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallapiportal.strategy.Strategy;

@Component("cart")
public class CartStrategy implements Strategy {

    @Override
    public ResponseVo<Map<String, Object>> buildPage() {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        map.put("favorite", "");
        responseVo.setData(map);
        return responseVo;
    }
}
