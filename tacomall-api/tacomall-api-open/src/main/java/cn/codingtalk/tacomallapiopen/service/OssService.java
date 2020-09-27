/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-06-12 18:25:30
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-api\tacomall-api-open\src\main\java\cn\codingtalk\tacomallapiopen\service\OssService.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiopen.service;


import java.util.Map;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;



public interface OssService {
    ResponseVo<Map<String, Object>> authorize(String dir);
}
