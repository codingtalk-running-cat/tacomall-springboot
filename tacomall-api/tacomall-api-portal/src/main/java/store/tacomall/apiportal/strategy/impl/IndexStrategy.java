/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-10 17:00:09
 * @LastEditTime: 2020-10-26 18:42:26
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/strategy/impl/IndexStrategy.java
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
import store.tacomall.entity.goods.GoodsCategory;
import store.tacomall.apiportal.strategy.Strategy;
import store.tacomall.apiportal.service.GoodsCategoryService;
import store.tacomall.apiportal.service.ActivityService;
import store.tacomall.apiportal.service.GoodsService;

@Component("index")
public class IndexStrategy implements Strategy {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private GoodsService goodsService;

    @Override
    public ResponseVo<Map<String, Object>> buildPage(JSONObject json) {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> floor = new ArrayList<>();
        goodsCategoryService.getIndexCategoryGoodsCategories().getData().stream().forEach((GoodsCategory gc) -> {
            Map<String, Object> t = new HashMap<>();
            JSONObject b = new JSONObject();
            JSONObject bQuery = new JSONObject();
            t.put("id", gc.getId());
            t.put("name", gc.getName());
            bQuery.put("goodsCategoryId", gc.getId());
            b.put("query", bQuery);
            t.put("goods", goodsService.getGoodsPage(1, 6, b).getData());
            floor.add(t);
        });
        map.put("floor", floor);
        map.put("activity", activityService.getActivityPage().getData());
        map.put("category", goodsCategoryService.getIndexCategoryGoodsCategories().getData());
        responseVo.setData(map);
        return responseVo;
    }
}
