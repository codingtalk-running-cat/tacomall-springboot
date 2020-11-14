/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-14 11:31:16
 * @LastEditTime: 2020-11-14 11:34:45
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-open/src/main/java/store/tacomall/apiopen/strategy/impl/EnumGoodsCategoryStrategy.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiopen.strategy.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.hutool.core.util.ObjectUtil;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.apiopen.strategy.EnumStrategy;
import store.tacomall.entity.goods.GoodsCategory;
import store.tacomall.mapper.goods.GoodsCategoryMapper;

@Component("goodsCategory")
public class EnumGoodsCategoryStrategy implements EnumStrategy {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public ResponseVo<List<Map<String, Object>>> query(JSONObject json) {
        ResponseVo<List<Map<String, Object>>> responseVo = new ResponseVo<>();
        LambdaQueryWrapper<GoodsCategory> q = new QueryWrapper<GoodsCategory>().lambda();
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").get("pId"))) {
            q.eq(GoodsCategory::getPId, json.getJSONObject("query").getInteger("pId"));
        }
        q.eq(GoodsCategory::getIsDelete, 0);
        responseVo.setData(goodsCategoryMapper.selectList(q).stream().map((GoodsCategory goodsBrand) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", goodsBrand.getId());
            map.put("name", goodsBrand.getName());
            return map;
        }).collect(Collectors.toList()));
        return responseVo;
    }
}
