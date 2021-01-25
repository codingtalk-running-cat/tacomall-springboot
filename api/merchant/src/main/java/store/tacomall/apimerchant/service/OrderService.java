/***
 * @Author: 码上talk|RC
 * @Date: 2020-10-19 16:11:45
 * @LastEditTime: 2020-12-15 15:26:11
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/store/tacomall/apimerchant/service/OrderService.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apimerchant.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import store.tacomall.common.entity.order.Order;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.vo.ResponsePageVo;

public interface OrderService extends IService<Order> {

    /***
     * @description: 商户订单分页
     * @param {type}
     * @return:
     */
    ResponsePageVo<List<Order>> getOrderPage(int pageIndex, int pageSize, JSONObject json);

    /***
     * @description: 商户订单详情
     * @param {type}
     * @return:
     */
    ResponseVo<Order> info(int id);

}
