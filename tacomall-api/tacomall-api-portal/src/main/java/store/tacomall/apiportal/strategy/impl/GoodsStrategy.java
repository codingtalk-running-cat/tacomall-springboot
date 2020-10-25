/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 11:06:56
 * @LastEditTime: 2020-10-25 12:07:39
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/strategy/impl/GoodsStrategy.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.strategy.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.apiportal.strategy.Strategy;
import store.tacomall.apiportal.service.GoodsService;

@Component("goods")
public class GoodsStrategy implements Strategy {

    @Autowired
    private GoodsService goodsService;

    @Override
    public ResponseVo<Map<String, Object>> buildPage() {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        map.put("goods", goodsService.getGoods(1).getData());
        responseVo.setData(map);
        return responseVo;
    }
}
