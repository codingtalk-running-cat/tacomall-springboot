
/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-23 10:46:52
 * @LastEditTime: 2020-12-23 15:30:43
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/portal/src/main/java/store/tacomall/apiportal/strategy/impl/PageGoodsCategoryStrategyImpl.java
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
import store.tacomall.apiportal.service.GoodsCategoryService;

@Component("pageGoodsCategory")
public class PageGoodsCategoryStrategyImpl implements PageStrategy {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Override
    public ResponseVo<Map<String, Object>> buildPage(JSONObject json) {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        map.put("goodsCategory", goodsCategoryService.getGoodsCategories().getData());
        responseVo.setData(map);
        return responseVo;
    }
}
