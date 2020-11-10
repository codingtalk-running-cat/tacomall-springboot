/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-11-03 10:16:02
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/impl/OrderServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

import cn.hutool.core.util.ObjectUtil;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import store.tacomall.common.util.ExceptionUtil;
import store.tacomall.common.util.RequestUtil;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.entity.cart.Cart;
import store.tacomall.entity.order.Order;
import store.tacomall.entity.order.OrderMappingGoodsItem;
import store.tacomall.mapper.order.OrderMapper;
import store.tacomall.mapper.order.OrderMappingGoodsItemMapper;
import store.tacomall.mapper.cart.CartMapper;
import store.tacomall.apiportal.service.OrderService;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrderMappingGoodsItemMapper orderMappingGoodsItemMapper;

    @Autowired
    TransactionDefinition transactionDefinition;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    /***
     * @description: 添加用户订单
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Order> addOrder(String cartIds, JSONObject json) {
        ResponseVo<Order> responseVo = new ResponseVo<>();
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            Order order = new Order();
            BigDecimal totalAmount = BigDecimal.ZERO;
            List<Cart> cart = cartMapper.getCarts(
                    new QueryWrapper<Cart>().lambda().eq(Cart::getMemberId, RequestUtil.getLoginUser().getInteger("id"))
                            .in(Cart::getId, Arrays.asList(cartIds.split(","))));
            for (int i = 0; i < cart.size(); i++) {
                Cart currentCart = cart.get(i);
                totalAmount = totalAmount.add(
                        currentCart.getGoodsItem().getAmount().multiply(new BigDecimal(currentCart.getQuantity())));
            }
            order.setMemberId(RequestUtil.getLoginUser().getIntValue("id"));
            order.setTotalAmount(totalAmount.setScale(2, BigDecimal.ROUND_HALF_UP));
            this.baseMapper.insert(order);

            for (int i = 0; i < cart.size(); i++) {
                Cart currentCart = cart.get(i);
                OrderMappingGoodsItem orderMappingGoodsItem = new OrderMappingGoodsItem();
                orderMappingGoodsItem.setOrderId(order.getId());
                orderMappingGoodsItem.setGoodsItemId(currentCart.getGoodsItemId());
                orderMappingGoodsItem.setAmount(currentCart.getGoodsItem().getAmount());
                orderMappingGoodsItem.setQuantity(currentCart.getQuantity());
                orderMappingGoodsItemMapper.insert(orderMappingGoodsItem);
            }

            cartMapper.delete(
                    new QueryWrapper<Cart>().lambda().eq(Cart::getMemberId, RequestUtil.getLoginUser().getInteger("id"))
                            .in(Cart::getId, Arrays.asList(cartIds.split(","))));

            dataSourceTransactionManager.commit(transactionStatus);
            responseVo.setData(order);
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transactionStatus);
            ExceptionUtil.throwSqlException(e.toString());
        }
        return responseVo;
    }

    /***
     * @description: 获取用户订单详情
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Order> getOrder(JSONObject json) {
        ResponseVo<Order> responseVo = new ResponseVo<>();
        LambdaQueryWrapper<Order> q = new QueryWrapper<Order>().lambda();
        q.eq(Order::getMemberId, RequestUtil.getLoginUser().getInteger("id"));
        if (ObjectUtil.isNotEmpty(json.getString("id"))) {
            q.eq(Order::getId, json.getInteger("id"));
        }
        q.eq(Order::getIsDelete, 0);
        responseVo.setData(this.baseMapper.getOrder(q));
        return responseVo;
    }

    /***
     * @description: 获取用户订单
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<List<Order>> getOrderPage(int pageIndex, int pageSize, JSONObject json) {
        ResponseVo<List<Order>> responseVo = new ResponseVo<>();
        Page<Order> page = new Page<>(pageIndex, pageSize);
        LambdaQueryWrapper<Order> q = new QueryWrapper<Order>().lambda();
        q.eq(Order::getMemberId, RequestUtil.getLoginUser().getInteger("id"));
        if (ObjectUtil.isNotEmpty(json.getInteger("status")) && json.getInteger("status") != -1) {
            q.eq(Order::getStatus, json.getInteger("status"));
        }
        q.eq(Order::getIsDelete, 0);
        IPage<Order> result = this.baseMapper.getOrderPage(page, q);
        responseVo.setData(result.getRecords());
        return responseVo;
    }

}
