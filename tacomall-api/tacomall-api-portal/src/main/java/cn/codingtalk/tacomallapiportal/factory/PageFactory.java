/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-10 16:58:58
 * @LastEditTime: 2020-07-13 11:40:38
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/factory/PageFactory.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.codingtalk.tacomallcommon.utils.ObjectUtil;
import cn.codingtalk.tacomallcommon.utils.ExceptionUtil;
import cn.codingtalk.tacomallcommon.enumeration.BizEnum;
import cn.codingtalk.tacomallapiportal.strategy.Strategy;

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
