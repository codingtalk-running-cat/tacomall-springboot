/***
 * @Author: 码上talk|RC
 * @Date: 2020-12-22 16:05:40
 * @LastEditTime: 2020-12-23 15:22:26
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/portal/src/main/java/store/tacomall/apiportal/factory/OrderFactory.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiportal.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.ObjectUtil;

import store.tacomall.common.enumeration.BizEnum;
import store.tacomall.common.util.ExceptionUtil;
import store.tacomall.apiportal.strategy.OrderStrategy;

@Service
public class OrderFactory {

    @Autowired
    Map<String, OrderStrategy> strategys = new ConcurrentHashMap<>();

    public OrderStrategy getStrategy(String fromType) {
        OrderStrategy strategy = strategys.get(fromType);
        if (ObjectUtil.isNull(strategy)) {
            ExceptionUtil.throwClientException(BizEnum.ORDER_FROM_TYPE_NOT_EXSIT.getMessage());
        }
        return strategy;
    }

}
