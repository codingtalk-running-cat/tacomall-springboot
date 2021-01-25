/***
 * @Author: ,: 码上talk|RC
 * @Date: ,: 2020-10-19 16:12:03
 * @LastEditTime: 2021-01-06 16:07:59
 * @LastEditors: 码上talk|RC
 * @Description: ,: 
 * @FilePath: /tacomall-springboot/api/merchant/src/main/java/store/tacomall/apimerchant/service/impl/OrderServiceImpl.java
 * @微信: ,:  13680065830
 * @邮箱: ,:  3189482282@qq.com
 * @oops: ,: Just do what I think it is right
 */
package store.tacomall.apimerchant.service.impl;

import java.util.List;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import store.tacomall.apimerchant.service.OrderService;
import store.tacomall.common.entity.order.Order;
import store.tacomall.common.mapper.order.OrderMapper;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.vo.ResponsePageVo;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    /***
     * @description: 商户商品分页
     * @param {type}
     * @return:
     */
    @Override
    public ResponsePageVo<List<Order>> getOrderPage(int pageIndex, int pageSize, JSONObject json) {
        ResponsePageVo<List<Order>> responsePageVo = new ResponsePageVo<>();
        Page<Order> page = new Page<>(pageIndex, pageSize);
        LambdaQueryWrapper<Order> q = new QueryWrapper<Order>().lambda();
        if (ObjectUtil.isNotEmpty(json.getInteger("status")) && json.getInteger("status") != -1) {
            q.eq(Order::getStatus, json.getInteger("status"));
        }
        q.eq(Order::getIsDelete, 0);
        IPage<Order> result = this.baseMapper.getOrderPage(page, q);
        responsePageVo.setData(result.getRecords());
        return responsePageVo;
    }

    /***
     * @description: 商户商品详情
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Order> info(int id) {
        ResponseVo<Order> responseVo = new ResponseVo<>();
        LambdaQueryWrapper<Order> q = new QueryWrapper<Order>().lambda();
        q.eq(Order::getId, id);
        q.eq(Order::getIsDelete, 0);
        responseVo.setData(this.baseMapper.getOrder(q));
        return responseVo;
    }

}