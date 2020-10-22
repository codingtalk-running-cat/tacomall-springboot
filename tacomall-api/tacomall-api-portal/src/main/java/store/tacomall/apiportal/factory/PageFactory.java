/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-10 16:58:58
 * @LastEditTime: 2020-10-19 17:44:39
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/factory/PageFactory.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.ObjectUtil;

import store.tacomall.common.enumeration.BizEnum;
import store.tacomall.common.util.ExceptionUtil;
import store.tacomall.apiportal.strategy.Strategy;

@Service
public class PageFactory {

    @Autowired
    Map<String, Strategy> strategys = new ConcurrentHashMap<>(3);

    public Strategy getStrategy(String id) throws Exception {
        Strategy strategy = strategys.get(id);
        if (ObjectUtil.isNull(strategy)) {
            ExceptionUtil.throwClientException(BizEnum.PAGE_NOT_EXSIT.getMessage());
        }
        return strategy;
    }

}
