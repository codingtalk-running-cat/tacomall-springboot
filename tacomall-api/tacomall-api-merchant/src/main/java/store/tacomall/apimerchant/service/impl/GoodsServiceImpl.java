/***
 * @Author: 码上talk|RC
 * @Date: 2020-10-19 16:12:57
 * @LastEditTime: 2020-11-10 15:29:13
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/store/tacomall/apimerchant/service/impl/GoodsServiceImpl.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apimerchant.service.impl;

import java.util.List;

import cn.hutool.core.util.ObjectUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import store.tacomall.common.util.ExceptionUtil;
import store.tacomall.apimerchant.service.GoodsService;
import store.tacomall.entity.goods.Goods;
import store.tacomall.entity.goods.GoodsItem;
import store.tacomall.mapper.goods.GoodsMapper;
import store.tacomall.mapper.goods.GoodsItemMapper;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.entity.merchant.MerchantUser;

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
    public ResponseVo<List<Goods>> getGoodsPage(int pageIndex, int pageSize, JSONObject json) {
        ResponseVo<List<Goods>> responseVo = new ResponseVo<>();
        Page<Goods> page = new Page<>(pageIndex, pageSize);
        LambdaQueryWrapper<Goods> q = new QueryWrapper<Goods>().lambda();
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").get("keyword"))) {
            q.like(Goods::getName, json.getJSONObject("query").get("keyword"));
        }
        IPage<Goods> result = this.baseMapper.getGoodsPage(page, q);
        responseVo.setData(result.getRecords());
        return responseVo.json();
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
        return responseVo.json();
    }

    /***
     * @description: 商户商品添加
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Boolean> add(JSONObject json) {
        ResponseVo<Boolean> responseVo = new ResponseVo<>();
        responseVo.setStatus(false);
        Goods goods = JSON.toJavaObject(json, Goods.class);
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        MerchantUser merchantUser = (MerchantUser) SecurityUtils.getSubject().getPrincipal();
        try {
            goods.setMerchantId(merchantUser.getId());
            this.baseMapper.insert(goods);
            goods.getGoodsItem().stream().forEach((GoodsItem goodsItem) -> {
                goodsItem.setGoodsId(goods.getId());
                goodsItemMapper.insert(goodsItem);
            });
            dataSourceTransactionManager.commit(transactionStatus);
            responseVo.setStatus(true);
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transactionStatus);
            ExceptionUtil.throwSqlException(e.toString());
        }
        return responseVo.json();
    }

}
