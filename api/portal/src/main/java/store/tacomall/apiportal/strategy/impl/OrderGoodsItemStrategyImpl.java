/***
 * @Author: 码上talk|RC
 * @Date: 2020-12-22 16:02:38
 * @LastEditTime: 2020-12-23 18:44:43
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/portal/src/main/java/store/tacomall/apiportal/strategy/impl/OrderGoodsItemStrategyImpl.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiportal.strategy.impl;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Arrays;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import store.tacomall.common.util.ExceptionUtil;
import store.tacomall.common.util.RequestUtil;
import store.tacomall.common.entity.cart.Cart;
import store.tacomall.common.entity.goods.GoodsItem;
import store.tacomall.common.entity.merchant.Merchant;
import store.tacomall.common.entity.order.Order;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.apiportal.strategy.OrderStrategy;
import store.tacomall.common.entity.order.OrderMappingGoodsItem;
import store.tacomall.common.mapper.goods.GoodsItemMapper;
import store.tacomall.common.mapper.order.OrderMapper;
import store.tacomall.common.mapper.order.OrderMappingGoodsItemMapper;
import store.tacomall.common.mapper.cart.CartMapper;
import store.tacomall.common.enumeration.BizEnum;

import store.tacomall.apiportal.bo.FromType2OrderBo;
import store.tacomall.apiportal.bo.FromType2OrderValueBo;

@Component("orderGoodsItem")
public class OrderGoodsItemStrategyImpl implements OrderStrategy {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsItemMapper goodsItemMapper;

    @Autowired
    private OrderMappingGoodsItemMapper orderMappingGoodsItemMapper;

    @Autowired
    TransactionDefinition transactionDefinition;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    @Override
    public ResponseVo<List<Order>> genOrder(JSONObject json) {
        ResponseVo<List<Order>> responseVo = new ResponseVo<>();
        List<Order> orders = new ArrayList<>();
        List<FromType2OrderBo> fromType2OrderBos = new ArrayList<>();
        GoodsItem g = goodsItemMapper
                .getGoodsItem(new QueryWrapper<GoodsItem>().lambda().eq(GoodsItem::getId, json.getInteger("id")));
        FromType2OrderBo fromType2OrderBo = new FromType2OrderBo();
        FromType2OrderValueBo fromType2OrderValueBo = new FromType2OrderValueBo();
        fromType2OrderValueBo.setQuantity(json.getInteger("quantity"));
        fromType2OrderValueBo.setGoodsItem(g);
        ;
        fromType2OrderBo.setMerchant(g.getMerchant());
        fromType2OrderBo.setValue(new ArrayList<FromType2OrderValueBo>(Arrays.asList(fromType2OrderValueBo)));
        fromType2OrderBos.add(fromType2OrderBo);
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            int memberId = RequestUtil.getLoginUser().getIntValue("id");
            for (int i = 0; i < fromType2OrderBos.size(); i++) {
                Order order = new Order();
                Merchant merchant = fromType2OrderBos.get(i).getMerchant();
                List<FromType2OrderValueBo> fromType2OrderValueBos = fromType2OrderBos.get(i).getValue();
                List<OrderMappingGoodsItem> orderMappingGoodsItems = new ArrayList<>();
                BigDecimal total = BigDecimal.ZERO;
                for (int j = 0; j < fromType2OrderValueBos.size(); j++) {
                    int quantity = fromType2OrderValueBos.get(j).getQuantity();
                    GoodsItem goodsItem = fromType2OrderValueBos.get(j).getGoodsItem();
                    if (goodsItemMapper.minus(goodsItem.getId(), quantity) < 1) {
                        ExceptionUtil.throwBizException(BizEnum.GOODS_ITEM_STOCK_NONE.getMessage());
                    }
                    OrderMappingGoodsItem orderMappingGoodsItem = new OrderMappingGoodsItem();
                    total = total.add(goodsItem.getAmount().multiply(new BigDecimal(quantity)));
                    orderMappingGoodsItem.setGoodsItemId(goodsItem.getId());
                    orderMappingGoodsItem.setAmount(goodsItem.getAmount());
                    orderMappingGoodsItem.setQuantity(quantity);
                    orderMappingGoodsItems.add(orderMappingGoodsItem);
                }
                order.setMemberId(memberId);
                order.setMerchantId(merchant.getId());
                order.setTotalAmount(total.setScale(2, BigDecimal.ROUND_HALF_UP));
                orderMapper.insert(order);
                orders.add(order);

                for (int k = 0; k < orderMappingGoodsItems.size(); k++) {
                    OrderMappingGoodsItem orderMappingGoodsItem = orderMappingGoodsItems.get(k);
                    orderMappingGoodsItem.setOrderId(order.getId());
                    orderMappingGoodsItemMapper.insert(orderMappingGoodsItem);
                }
            }

            dataSourceTransactionManager.commit(transactionStatus);
            responseVo.setData(orders);
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transactionStatus);
            ExceptionUtil.throwSqlException(e.toString());
        }

        responseVo.setData(orders);
        return responseVo;
    }
}
