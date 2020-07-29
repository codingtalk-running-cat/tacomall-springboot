/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 11:06:56
 * @LastEditTime: 2020-07-24 10:13:42
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/strategy/impl/GoodsStrategy.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.strategy.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallapiportal.strategy.Strategy;
import cn.codingtalk.tacomallapiportal.service.GoodsService;

@Component("goods")
public class GoodsStrategy implements Strategy {

    @Autowired
    private GoodsService goodsService;

    @Override
    public ResponseVo<Map<String, Object>> buildPage() {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        map.put("goods", this.goodsService.getGoods());
        responseVo.setData(map);
        return responseVo;
    }
}
