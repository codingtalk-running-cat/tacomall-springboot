/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-10 16:59:34
 * @LastEditTime: 2020-11-14 11:11:49
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-open/src/main/java/store/tacomall/apiopen/strategy/EnumStrategy.java
 * @Just do what I think it is right
 */
package store.tacomall.apiopen.strategy;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import store.tacomall.common.vo.ResponseVo;

public interface EnumStrategy {

    ResponseVo<List<Map<String, Object>>> query(JSONObject json);

}
