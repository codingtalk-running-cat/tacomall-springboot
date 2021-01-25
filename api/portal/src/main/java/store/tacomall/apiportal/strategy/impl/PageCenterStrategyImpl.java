/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-23 11:22:00
 * @LastEditTime: 2020-12-23 15:31:08
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/portal/src/main/java/store/tacomall/apiportal/strategy/impl/PageCenterStrategyImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.strategy.impl;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.apiportal.strategy.PageStrategy;

@Component("pageCenter")
public class PageCenterStrategyImpl implements PageStrategy {

    @Override
    public ResponseVo<Map<String, Object>> buildPage(JSONObject json) {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        map.put("favorite", "");
        responseVo.setData(map);
        return responseVo;
    }
}