/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-10 16:58:58
 * @LastEditTime: 2020-11-14 11:03:33
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-open/src/main/java/store/tacomall/apiopen/factory/EnumFactory.java
 * @Just do what I think it is right
 */
package store.tacomall.apiopen.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.ObjectUtil;

import store.tacomall.common.enumeration.BizEnum;
import store.tacomall.common.util.ExceptionUtil;
import store.tacomall.apiopen.strategy.EnumStrategy;

@Service
public class EnumFactory {

    @Autowired
    Map<String, EnumStrategy> strategys = new ConcurrentHashMap<>(3);

    public EnumStrategy getStrategy(String id) {
        EnumStrategy strategy = strategys.get(id);
        if (ObjectUtil.isNull(strategy)) {
            ExceptionUtil.throwClientException(BizEnum.PAGE_NOT_EXSIT.getMessage());
        }
        return strategy;
    }

}
