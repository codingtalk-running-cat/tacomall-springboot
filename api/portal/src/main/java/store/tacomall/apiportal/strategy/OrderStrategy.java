/***
 * @Author: 码上talk|RC
 * @Date: 2020-12-22 16:02:06
 * @LastEditTime: 2020-12-23 15:18:35
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/portal/src/main/java/store/tacomall/apiportal/strategy/OrderStrategy.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiportal.strategy;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import store.tacomall.common.entity.order.Order;
import store.tacomall.common.vo.ResponseVo;

public interface OrderStrategy {

    ResponseVo<List<Order>> genOrder(JSONObject json);

}
