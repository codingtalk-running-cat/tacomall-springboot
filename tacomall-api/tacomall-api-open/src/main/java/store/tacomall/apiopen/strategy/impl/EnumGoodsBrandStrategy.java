/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-23 11:21:48
 * @LastEditTime: 2020-11-14 11:31:28
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-open/src/main/java/store/tacomall/apiopen/strategy/impl/EnumGoodsBrandStrategy.java
 * @Just do what I think it is right
 */
package store.tacomall.apiopen.strategy.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.apiopen.strategy.EnumStrategy;
import store.tacomall.entity.goods.GoodsBrand;
import store.tacomall.mapper.goods.GoodsBrandMapper;

@Component("goodsBrand")
public class EnumGoodsBrandStrategy implements EnumStrategy {

    @Autowired
    private GoodsBrandMapper goodsBrandMapper;

    @Override
    public ResponseVo<List<Map<String, Object>>> query(JSONObject json) {
        ResponseVo<List<Map<String, Object>>> responseVo = new ResponseVo<>();
        LambdaQueryWrapper<GoodsBrand> q = new QueryWrapper<GoodsBrand>().lambda();
        q.eq(GoodsBrand::getIsDelete, 0);
        responseVo.setData(goodsBrandMapper.selectList(q).stream().map((GoodsBrand goodsBrand) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", goodsBrand.getId());
            map.put("name", goodsBrand.getName());
            return map;
        }).collect(Collectors.toList()));
        return responseVo;
    }
}
