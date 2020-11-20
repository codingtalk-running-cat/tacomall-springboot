/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-20 14:56:48
 * @LastEditTime: 2020-11-20 15:35:39
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-open/src/main/java/store/tacomall/apiopen/strategy/impl/EnumGoodsAttrStrategy.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiopen.strategy.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.apiopen.strategy.EnumStrategy;
import store.tacomall.entity.goods.GoodsAttrKey;
import store.tacomall.entity.goods.GoodsAttrValue;
import store.tacomall.mapper.goods.GoodsAttrKeyMapper;

@Component("goodsAttr")
public class EnumGoodsAttrStrategy implements EnumStrategy {

    @Autowired
    private GoodsAttrKeyMapper goodsAttrKeyMapper;

    @Override
    public ResponseVo<List<Map<String, Object>>> query(JSONObject json) {
        ResponseVo<List<Map<String, Object>>> responseVo = new ResponseVo<>();
        LambdaQueryWrapper<GoodsAttrKey> q = new QueryWrapper<GoodsAttrKey>().lambda();
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").get("categoryId"))) {
            q.eq(GoodsAttrKey::getCategoryId, json.getJSONObject("query").getInteger("categoryId"));
        }
        q.eq(GoodsAttrKey::getIsDelete, 0);
        responseVo.setData(goodsAttrKeyMapper.getGoodsAttrKeys(q).stream().map((GoodsAttrKey goodsAttrKey) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", goodsAttrKey.getId());
            map.put("name", goodsAttrKey.getName());
            map.put("children", goodsAttrKey.getGoodsAttrValue().stream().map((GoodsAttrValue goodsAttrValue) -> {
                Map<String, Object> map1 = new HashMap<>();
                map1.put("id", goodsAttrValue.getId());
                map1.put("name", goodsAttrValue.getName());
                return map1;
            }).collect(Collectors.toList()));
            return map;
        }).collect(Collectors.toList()));
        return responseVo;
    }
}
