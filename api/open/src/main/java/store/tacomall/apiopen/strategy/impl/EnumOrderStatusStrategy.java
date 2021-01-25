/***
 * @Author: 码上talk|RC
 * @Date: 2020-12-15 15:16:04
 * @LastEditTime: 2020-12-15 15:35:18
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-open/src/main/java/store/tacomall/apiopen/strategy/impl/EnumOrderStatusStrategy.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiopen.strategy.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.apiopen.strategy.EnumStrategy;

@Component("orderStatus")
public class EnumOrderStatusStrategy implements EnumStrategy {

    @Override
    public ResponseVo<List<Map<String, Object>>> query(JSONObject json) {
        ResponseVo<List<Map<String, Object>>> responseVo = new ResponseVo<>();
        responseVo.setData(new ArrayList<>());
        return responseVo;
    }
}
