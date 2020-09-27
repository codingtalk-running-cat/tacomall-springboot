/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-06-12 19:38:13
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-api\tacomall-api-open\src\main\java\cn\codingtalk\tacomallapiopen\controller\OssController.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiopen.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallapiopen.service.OssService;

@RestController
@RequestMapping(value = "/open/oss")
public class OssController {

    @Autowired
    private OssService ossService;

    @PostMapping("authorize")
    public ResponseVo<Map<String, Object>> authorize(@RequestParam(value = "dir", defaultValue = "/") String dir) {
        return ossService.authorize(dir);
    }

    @PostMapping("callback")
    public ResponseVo<Object> callback() {
        ResponseVo<Object> responseVo = new ResponseVo<>();
        return responseVo;
    }
}
