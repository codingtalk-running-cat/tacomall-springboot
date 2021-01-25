/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-12-23 18:43:36
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/portal/src/main/java/store/tacomall/apiportal/service/OrderService.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.entity.order.Order;

public interface OrderService extends IService<Order> {

    /***
     * @description: 获取用户订单详情
     * @param {type}
     * @return:
     */
    ResponseVo<Order> getOrder(JSONObject json);

    /***
     * @description: 获取用户订单分页
     * @param {type}
     * @return:
     */
    ResponseVo<List<Order>> getOrderPage(int pageIndex, int pageSize, JSONObject json);

}
