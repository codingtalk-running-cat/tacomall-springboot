/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-12-29 16:27:35
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/open/src/main/java/store/tacomall/apiopen/service/OssService.java
 * @Just do what I think it is right
 */
package store.tacomall.apiopen.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import store.tacomall.common.entity.oss.OssObject;
import store.tacomall.common.vo.ResponseVo;

public interface OssService {
    ResponseVo<Map<String, Object>> authorize(String dir, int insertDb);

    ResponseVo<OssObject> callback(HttpServletRequest request);
}
