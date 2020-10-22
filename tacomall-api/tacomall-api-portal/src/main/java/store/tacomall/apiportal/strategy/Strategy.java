/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-10 16:59:34
 * @LastEditTime: 2020-07-16 17:12:16
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/strategy/Strategy.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.strategy;

import java.util.Map;

import store.tacomall.common.vo.ResponseVo;

public interface Strategy {

    ResponseVo<Map<String, Object>> buildPage();

}
