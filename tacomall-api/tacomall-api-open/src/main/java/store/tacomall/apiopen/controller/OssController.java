/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-26 17:56:56
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-open/src/main/java/store/tacomall/apiopen/controller/OssController.java
 * @Just do what I think it is right
 */
package store.tacomall.apiopen.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;

import store.tacomall.apiopen.service.OssService;
import store.tacomall.common.vo.ResponseVo;

@Api(tags = "云存储模块")
@RestController
@RequestMapping(value = "/open/oss")
public class OssController {

    @Autowired
    private OssService ossService;

    @ApiOperation(value = "获取鉴权配置", notes = "获取鉴权配置接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "dir", value = "存储路径", required = false, paramType = "query") })
    @PostMapping("authorize")
    public ResponseVo<Map<String, Object>> authorize(@RequestParam(value = "dir", defaultValue = "/") String dir) {
        return ossService.authorize(dir);
    }

    @ApiOperation(value = "云存储回调", notes = "云存储回调接口", httpMethod = "POST")
    @ApiImplicitParams({})
    @PostMapping("callback")
    public ResponseVo<Object> callback() {
        ResponseVo<Object> responseVo = new ResponseVo<>();
        return responseVo;
    }
}
