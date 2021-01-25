/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-15 15:03:54
 * @LastEditTime: 2021-01-18 14:19:25
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/service/impl/GoodsServiceImpl.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiadmin.service.impl;

import java.util.List;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import store.tacomall.apiadmin.service.GoodsService;
import store.tacomall.common.entity.goods.Goods;
import store.tacomall.common.mapper.goods.GoodsMapper;
import store.tacomall.common.mapper.goods.GoodsItemMapper;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.vo.ResponsePageVo;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    GoodsItemMapper goodsItemMapper;

    /***
     * @description: 平台商品分页
     * @param {type}
     * @return:
     */
    @Override
    public ResponsePageVo<List<Goods>> getGoodsPage(int pageIndex, int pageSize, JSONObject json) {
        ResponsePageVo<List<Goods>> responsePageVo = new ResponsePageVo<>();
        Page<Goods> page = new Page<>(pageIndex, pageSize);
        LambdaQueryWrapper<Goods> q = new QueryWrapper<Goods>().lambda();
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").get("keyword"))) {
            q.like(Goods::getName, json.getJSONObject("query").get("keyword"));
        }
        IPage<Goods> result = this.baseMapper.getGoodsPage(page, q);
        responsePageVo.setData(result.getRecords());
        responsePageVo.buildPage(result.getCurrent(), result.getSize(), result.getTotal());
        return responsePageVo;
    }

    /***
     * @description: 平台商品详情
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Goods> info(int id) {
        ResponseVo<Goods> responseVo = new ResponseVo<>();
        responseVo.setData(this.baseMapper.getGoods(new QueryWrapper<Goods>().lambda().eq(Goods::getId, id)));
        return responseVo;
    }

}
