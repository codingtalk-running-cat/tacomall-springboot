/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:40:27
 * @LastEditTime: 2020-12-17 09:39:30
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/impl/GoodsServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service.impl;

import java.util.List;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.entity.goods.Goods;
import store.tacomall.common.mapper.goods.GoodsMapper;
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
        JSONObject query = json.getJSONObject("query");
        LambdaQueryWrapper<Goods> lqw = new QueryWrapper<Goods>().lambda();
        if (ObjectUtil.isNotEmpty(query) && ObjectUtil.isNotEmpty(query.get("goodsCategoryId"))) {
            lqw.apply(String.format("goods_category_id REGEXP '^%S|>%S>|>%S$'", query.getInteger("goodsCategoryId"),
                    query.getInteger("goodsCategoryId"), query.getInteger("goodsCategoryId")));
        }
        if (ObjectUtil.isNotEmpty(query) && ObjectUtil.isNotEmpty(query.get("keyword"))) {
            lqw.like(Goods::getName, query.get("keyword"));
        }
        lqw.eq(Goods::getIsDelete, 0);
        IPage<Goods> result = this.baseMapper.getGoodsPage(page, lqw);
        responseVo.setData(result.getRecords());
        return responseVo;
    };
}
