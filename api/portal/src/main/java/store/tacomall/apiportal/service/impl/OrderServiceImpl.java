/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-12-23 18:44:07
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/portal/src/main/java/store/tacomall/apiportal/service/impl/OrderServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hutool.core.util.ObjectUtil;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import store.tacomall.common.util.RequestUtil;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.entity.order.Order;
import store.tacomall.common.mapper.order.OrderMapper;
import store.tacomall.apiportal.service.OrderService;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    TransactionDefinition transactionDefinition;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

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
