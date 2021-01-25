/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 11:06:56
 * @LastEditTime: 2020-12-23 14:10:15
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/strategy/impl/PageGoodsStrategyImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.strategy.impl;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.apiportal.strategy.PageStrategy;
import store.tacomall.apiportal.service.GoodsService;

@Component("pageGoods")
public class PageGoodsStrategyImpl implements PageStrategy {

    @Autowired
    private GoodsService goodsService;

    @Override
    public ResponseVo<Map<String, Object>> buildPage(JSONObject json) {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        map.put("goods", goodsService.getGoods(json.getInteger("goodsId")).getData());
        responseVo.setData(map);
        return responseVo;
    }
}
