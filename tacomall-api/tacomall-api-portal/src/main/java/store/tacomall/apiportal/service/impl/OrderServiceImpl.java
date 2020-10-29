/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-27 15:37:40
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/impl/OrderServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import store.tacomall.common.vo.ResponseVo;

import store.tacomall.entity.order.Order;
import store.tacomall.mapper.order.OrderMapper;

import store.tacomall.apiportal.service.OrderService;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    /***
     * @description: 添加用户订单
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Order> addOrder() {
        ResponseVo<Order> responseVo = new ResponseVo<>();
        responseVo.setData(new Order());
        return responseVo;
    }

    /***
     * @description: 检查用户订单
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Order> checkOrder() {
        ResponseVo<Order> responseVo = new ResponseVo<>();
        responseVo.setData(new Order());
        return responseVo;
    }

    /***
     * @description: 获取用户订单
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<List<Order>> getOrderPage() {
        ResponseVo<List<Order>> responseVo = new ResponseVo<>();
        Page<Order> page = new Page<>(1, 3);
        IPage<Order> result = this.baseMapper.getOrderPage(page);
        responseVo.setData(result.getRecords());
        return responseVo;
    }

}
