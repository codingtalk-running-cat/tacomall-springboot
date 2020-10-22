/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-19 16:56:25
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-open/src/main/java/store/tacomall/apiopen/service/OssService.java
 * @Just do what I think it is right
 */
package store.tacomall.apiopen.service;

import java.util.Map;

import store.tacomall.common.vo.ResponseVo;

public interface OssService {
    ResponseVo<Map<String, Object>> authorize(String dir);
}
