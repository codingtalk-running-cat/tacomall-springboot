/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-29 09:28:10
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/service/impl/OrderServiceImpl.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import cn.codingtalk.tacomallcommon.utils.RequestUtil;
import cn.codingtalk.tacomallcommon.vo.ResponseVo;

import cn.codingtalk.tacomallentity.order.Order;
import cn.codingtalk.tacomallmapper.order.OrderMapper;

import cn.codingtalk.tacomallapiportal.service.OrderService;

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
     * @description: 获取用户订单
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<List<Order>> getOrderPage() {
        ResponseVo<List<Order>> responseVo = new ResponseVo<>();
        Page<Order> page = new Page<>(1, 3);
        IPage<Order> result = this.baseMapper.getOrderPage(page, RequestUtil.getLoginUser().getInteger("id"));
        responseVo.setData(result.getRecords());
        return responseVo;
    }

}
