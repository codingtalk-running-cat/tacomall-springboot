/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-23 11:22:00
 * @LastEditTime: 2020-10-26 18:44:10
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/strategy/impl/CenterStrategy.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.strategy.impl;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.apiportal.strategy.Strategy;

@Component("center")
public class CenterStrategy implements Strategy {

    @Override
    public ResponseVo<Map<String, Object>> buildPage(JSONObject json) {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        map.put("favorite", "");
        responseVo.setData(map);
        return responseVo;
    }
}