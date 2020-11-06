/***
 * @Author: 码上talk|RC
 * @Date: 2020-10-19 16:11:45
 * @LastEditTime: ,: 2020-10-20 14:42:25
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/store/tacomall/apimerchant/service/order/OrderService.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apimerchant.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import store.tacomall.entity.order.Order;
import store.tacomall.common.vo.ResponseVo;

public interface OrderService extends IService<Order> {

    /***
     * @description: 商户订单分页
     * @param {type}
     * @return:
     */
    ResponseVo<List<Order>> getOrderPage(int pageIndex, int pageSize);

    /***
     * @description: 商户订单详情
     * @param {type}
     * @return:
     */
    ResponseVo<Order> info(int id);

}
