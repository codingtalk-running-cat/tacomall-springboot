/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:40:27
 * @LastEditTime: 2020-10-24 14:29:50
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/impl/GoodsServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service.impl;

import java.util.List;
import java.util.Arrays;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.entity.goods.Goods;
import store.tacomall.mapper.goods.GoodsMapper;
import store.tacomall.apiportal.service.GoodsService;

@Component
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    /***
     * @description: 获取产品详情
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Goods> getGoods(int id) {
        ResponseVo<Goods> responseVo = new ResponseVo<>();
        Goods goods = this.baseMapper.getGoods(new QueryWrapper<Goods>().lambda().eq(Goods::getId, id));
        responseVo.setData(goods);
        return responseVo;
    };

    @Override
    public ResponseVo<List<Goods>> getGoodsPage(int pageIndex, int pageSize, JSONObject json) {
        ResponseVo<List<Goods>> responseVo = new ResponseVo<>();
        Page<Goods> page = new Page<>(pageIndex, pageSize);
        LambdaQueryWrapper<Goods> q = new QueryWrapper<Goods>().lambda();
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").get("goodsCategoryId"))) {
            q.in(Goods::getGoodsCategoryId, Arrays.asList(6));
        }
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").get("keyword"))) {
            q.like(Goods::getName, json.getJSONObject("query").get("keyword"));
        }
        IPage<Goods> result = this.baseMapper.getGoodsPage(page, q);
        responseVo.setData(result.getRecords());
        return responseVo;
    };
}
