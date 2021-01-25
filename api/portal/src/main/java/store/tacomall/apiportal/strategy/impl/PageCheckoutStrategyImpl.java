/***
 * @Author: 码上talk|RC
 * @Date: 2020-10-30 11:32:27
 * @LastEditTime: 2020-12-25 19:10:55
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/portal/src/main/java/store/tacomall/apiportal/strategy/impl/PageCheckoutStrategyImpl.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiportal.strategy.impl;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.util.ExceptionUtil;
import store.tacomall.common.entity.cart.Cart;
import store.tacomall.common.entity.goods.GoodsItem;
import store.tacomall.apiportal.strategy.PageStrategy;
import store.tacomall.apiportal.service.CartService;
import store.tacomall.apiportal.service.GoodsItemService;
import store.tacomall.common.entity.seckill.SeckillGoodsItemApply;
import store.tacomall.common.mapper.seckill.SeckillGoodsItemApplyMapper;

@Component("pageCheckout")
public class PageCheckoutStrategyImpl implements PageStrategy {

    @Autowired
    private CartService cartService;

    @Autowired
    private GoodsItemService goodsItemService;

    @Autowired
    private SeckillGoodsItemApplyMapper seckillGoodsItemApplyMapper;

    @Override
    public ResponseVo<Map<String, Object>> buildPage(JSONObject json) {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> buys = new ArrayList<>();
        Map<String, Object> amount = new HashMap<>();
        BigDecimal totalAmount = BigDecimal.ZERO;
        Map<String, Object> buy = new HashMap<>();
        GoodsItem goodsItem = new GoodsItem();
        switch (json.getString("fromType")) {
            case "CART":
                List<Cart> cart = cartService.getCarts(json).getData();
                for (int i = 0; i < cart.size(); i++) {
                    Cart currentCart = cart.get(i);
                    buy.put("quantity", currentCart.getQuantity());
                    buy.put("goodsItem", currentCart.getGoodsItem());
                    buys.add(buy);
                    totalAmount = totalAmount.add(
                            currentCart.getGoodsItem().getAmount().multiply(new BigDecimal(currentCart.getQuantity())));
                }
                break;
            case "GOODS_ITEM":
                goodsItem = goodsItemService.getGoodsItem(json).getData();
                int quantity = json.getInteger("quantity");
                buy.put("quantity", quantity);
                buy.put("goodsItem", goodsItem);
                buys.add(buy);
                totalAmount = goodsItem.getAmount().multiply(new BigDecimal(quantity));
                break;
            case "SECKILL":
                SeckillGoodsItemApply seckillGoodsItemApply = seckillGoodsItemApplyMapper
                        .getSeckillGoodsItemApply(new QueryWrapper<SeckillGoodsItemApply>().lambda()
                                .eq(SeckillGoodsItemApply::getId, json.getInteger("id")));
                goodsItem = seckillGoodsItemApply.getGoodsItem();
                buy.put("quantity", 1);
                buy.put("goodsItem", goodsItem);
                buys.add(buy);
                totalAmount = goodsItem.getAmount().multiply(new BigDecimal(1));
                break;
            default:
                ExceptionUtil.throwClientException("非法参数：fromType");
        }
        amount.put("total", totalAmount);
        map.put("buys", buys);
        map.put("amount", amount);
        responseVo.setData(map);
        return responseVo;
    }
}
