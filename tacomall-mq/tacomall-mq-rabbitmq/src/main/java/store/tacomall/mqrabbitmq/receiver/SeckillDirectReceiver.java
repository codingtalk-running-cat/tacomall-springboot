/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-04 18:26:46
 * @LastEditTime: 2020-11-05 08:53:18
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mq/tacomall-mq-rabbitmq/src/main/java/store/tacomall/mqrabbitmq/receiver/SeckillDirectReceiver.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.mqrabbitmq.receiver;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import store.tacomall.entity.order.Order;
import store.tacomall.entity.order.OrderMappingGoodsItem;
import store.tacomall.entity.seckill.SeckillGoodsItemApply;
import store.tacomall.mapper.order.OrderMapper;
import store.tacomall.mapper.order.OrderMappingGoodsItemMapper;
import store.tacomall.mapper.seckill.SeckillGoodsItemApplyMapper;
import store.tacomall.common.util.JwtUtil;

@Component
@RabbitListener(queues = "SeckillDirectQueue")
public class SeckillDirectReceiver {

    @Autowired
    TransactionDefinition transactionDefinition;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    SeckillGoodsItemApplyMapper seckillGoodsItemApplyMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderMappingGoodsItemMapper orderMappingGoodsItemMapper;

    @RabbitHandler
    public void process(Map<String, Object> message) {
        JwtUtil jwtUtil = new JwtUtil();
        Map<String, String> tokenMap = new HashMap<>();
        try {
            tokenMap = jwtUtil.verify((String) message.get("token"));
        } catch (Exception e) {
            return;
        }
        int seckillGoodsItemApplyId = Integer.valueOf(tokenMap.get("seckillGoodsItemApplyId")).intValue();
        int memberId = Integer.valueOf(tokenMap.get("memberId")).intValue();
        SeckillGoodsItemApply seckillGoodsItemApply = seckillGoodsItemApplyMapper.selectById(seckillGoodsItemApplyId);

        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            seckillGoodsItemApplyMapper.minusOne(seckillGoodsItemApply.getId());
            Order order = new Order();
            BigDecimal totalAmount = BigDecimal.ZERO;
            order.setMemberId(memberId);
            order.setTotalAmount(totalAmount);
            orderMapper.insert(order);

            OrderMappingGoodsItem orderMappingGoodsItem = new OrderMappingGoodsItem();
            orderMappingGoodsItem.setOrderId(order.getId());
            orderMappingGoodsItem.setGoodsItemId(seckillGoodsItemApply.getGoodsItemId());
            orderMappingGoodsItem.setAmount(BigDecimal.ZERO);
            orderMappingGoodsItem.setQuantity(1);
            orderMappingGoodsItemMapper.insert(orderMappingGoodsItem);
            dataSourceTransactionManager.commit(transactionStatus);
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transactionStatus);
        }
    }

}
