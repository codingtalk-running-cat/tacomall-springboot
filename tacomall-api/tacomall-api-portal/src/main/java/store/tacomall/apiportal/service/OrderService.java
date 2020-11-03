/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-11-03 08:59:03
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/OrderService.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.entity.order.Order;

public interface OrderService extends IService<Order> {

    /***
     * @description: 添加用户订单
     * @param {type}
     * @return:
     */
    ResponseVo<Order> addOrder(String cartIds, JSONObject json);

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
