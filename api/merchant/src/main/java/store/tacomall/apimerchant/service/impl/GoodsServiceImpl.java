/***
 * @Author: 码上talk|RC
 * @Date: 2020-10-19 16:12:57
 * @LastEditTime: 2020-12-24 15:16:31
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/merchant/src/main/java/store/tacomall/apimerchant/service/impl/GoodsServiceImpl.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apimerchant.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.apache.shiro.SecurityUtils;

import store.tacomall.common.util.ExceptionUtil;
import store.tacomall.apimerchant.service.GoodsService;
import store.tacomall.common.entity.goods.Goods;
import store.tacomall.common.entity.goods.GoodsItem;
import store.tacomall.common.entity.merchant.MerchantUser;
import store.tacomall.common.mapper.goods.GoodsMapper;
import store.tacomall.common.mapper.goods.GoodsItemMapper;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.vo.ResponsePageVo;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    GoodsItemMapper goodsItemMapper;

    @Autowired
    TransactionDefinition transactionDefinition;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    /***
     * @description: 商户商品分页
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
     * @description: 商户商品详情
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Goods> info(int id) {
        ResponseVo<Goods> responseVo = new ResponseVo<>();
        responseVo.setData(this.baseMapper.getGoods(new QueryWrapper<Goods>().lambda().eq(Goods::getId, id)));
        return responseVo;
    }

    /***
     * @description: 商户商品添加
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Goods> add(JSONObject json) {
        ResponseVo<Goods> responseVo = new ResponseVo<>();
        responseVo.setStatus(false);
        MerchantUser merchantUser = (MerchantUser) SecurityUtils.getSubject().getPrincipal();
        Goods goods = JSON.toJavaObject(json, Goods.class);
        goods.setMerchantId(merchantUser.getMerchantId());
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            this.baseMapper.insert(goods);
            goods.getGoodsItem().stream().forEach((GoodsItem goodsItem) -> {
                goodsItem.setGoodsId(goods.getId());
                goodsItemMapper.insert(goodsItem);
            });
            dataSourceTransactionManager.commit(transactionStatus);
            responseVo.setStatus(true);
            responseVo.setData(goods);
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transactionStatus);
            ExceptionUtil.throwSqlException(e.toString());
        }
        return responseVo;
    }

    /***
     * @description: 商户商品更新
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Goods> update(int id, JSONObject json) {
        ResponseVo<Goods> responseVo = new ResponseVo<>();
        responseVo.setStatus(false);
        MerchantUser merchantUser = (MerchantUser) SecurityUtils.getSubject().getPrincipal();
        Goods goods = JSON.toJavaObject(json, Goods.class);
        goods.setMerchantId(merchantUser.getMerchantId());
        List<GoodsItem> exsitGoodsItems = goodsItemMapper
                .selectList(new QueryWrapper<GoodsItem>().lambda().eq(GoodsItem::getGoodsId, id));
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            List<GoodsItem> updateGoodsItems = new ArrayList<>();
            this.baseMapper.update(goods, new UpdateWrapper<Goods>().lambda().eq(Goods::getId, id));
            goods.getGoodsItem().stream().forEach((GoodsItem goodsItem) -> {
                if (ObjectUtil.equal(goodsItem.getId(), 0)) {
                    goodsItemMapper.insert(goodsItem);
                    return;
                }
                goodsItemMapper.update(goodsItem,
                        new UpdateWrapper<GoodsItem>().lambda().eq(GoodsItem::getId, goodsItem.getId()));
                updateGoodsItems.add(goodsItem);
            });
            exsitGoodsItems.stream().forEach((GoodsItem goodsItem) -> {
                if (!updateGoodsItems.stream().map(GoodsItem::getId).collect(Collectors.toList())
                        .contains(goodsItem.getId())) {
                    goodsItemMapper
                            .delete(new QueryWrapper<GoodsItem>().lambda().eq(GoodsItem::getId, goodsItem.getId()));
                }
            });
            dataSourceTransactionManager.commit(transactionStatus);
            responseVo.setStatus(true);
            responseVo.setData(goods);
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transactionStatus);
            ExceptionUtil.throwSqlException(e.toString());
        }
        return responseVo;
    }

}
