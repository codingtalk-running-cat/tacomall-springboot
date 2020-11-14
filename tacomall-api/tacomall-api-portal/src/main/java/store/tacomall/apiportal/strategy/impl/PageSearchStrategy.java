/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-10 17:00:09
 * @LastEditTime: 2020-10-26 18:43:46
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/strategy/impl/SearchStrategy.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.strategy.impl;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.apiportal.strategy.PageStrategy;
import store.tacomall.apiportal.service.GoodsService;

@Component("search")
public class PageSearchStrategy implements PageStrategy {

    @Autowired
    private GoodsService goodsService;

    @Override
    public ResponseVo<Map<String, Object>> buildPage(JSONObject json) {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        List<String> hot = new ArrayList<>();
        hot.add("小米 10");
        hot.add("格力");
        map.put("hot", hot);
        map.put("recommend", goodsService.getGoodsPage(1, 10, new JSONObject()).getData());
        map.put("most", goodsService.getGoodsPage(1, 10, new JSONObject()).getData());
        responseVo.setData(map);
        return responseVo;
    }
}
