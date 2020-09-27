/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-29 09:26:55
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/service/OrderService.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallentity.order.Order;

public interface OrderService extends IService<Order> {

    /***
     * @description: 添加用户订单
     * @param {type}
     * @return:
     */
    ResponseVo<Order> addOrder();

    /***
     * @description: 获取用户订单分页
     * @param {type}
     * @return:
     */
    ResponseVo<List<Order>> getOrderPage();

}
