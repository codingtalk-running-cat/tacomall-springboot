/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-14 10:56:39
 * @LastEditTime: 2020-11-14 11:09:51
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-open/src/main/java/store/tacomall/apiopen/controller/EnumController.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiopen.controller;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.apiopen.factory.EnumFactory;

@Api(tags = "商城枚举")
@RestController
@RequestMapping(value = "/open/enum")
public class EnumController {

    @Autowired
    private EnumFactory enumFactory;

    @ApiOperation(value = "获取枚举列表", notes = "获取枚举列表接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "key", value = "枚举类", required = false, paramType = "query"),
            @ApiImplicitParam(name = "json", value = "查询条件", required = true, paramType = "body") })
    @PostMapping("lst")
    public ResponseVo<List<Map<String, Object>>> lst(@RequestParam(value = "key") String key,
            @RequestBody JSONObject json) {
        return enumFactory.getStrategy(key).query(json);
    }
}
