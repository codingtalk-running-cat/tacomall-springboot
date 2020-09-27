/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-10 17:00:09
 * @LastEditTime: 2020-07-24 10:13:52
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/strategy/impl/IndexStrategy.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.strategy.impl;

import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallapiportal.strategy.Strategy;
import cn.codingtalk.tacomallapiportal.service.ActivityService;

@Component("index")
public class IndexStrategy implements Strategy {

    @Autowired
    private ActivityService activityService;

    @Override
    public ResponseVo<Map<String, Object>> buildPage() {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        map.put("activity", this.activityService.getPageActivity().getData());
        responseVo.setData(map);
        return responseVo;
    }
}
