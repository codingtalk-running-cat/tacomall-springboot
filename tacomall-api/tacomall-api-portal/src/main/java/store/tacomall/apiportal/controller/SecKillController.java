/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-24 10:44:02
 * @LastEditTime: 2020-11-02 16:07:27
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/controller/SecKillController.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.controller;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.apiportal.annotation.LoginUser;
import store.tacomall.apiportal.service.SeckillService;

@Api(tags = "秒杀模块")
@RestController
@RequestMapping(value = "/portal/seckill/")
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    @ApiOperation(value = "获取秒杀商品", notes = "获取秒杀商品接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "json", value = "查询条件", required = true, paramType = "body") })
    @PostMapping("info")
    @LoginUser(required = false)
    public ResponseVo<Map<String, Object>> info(@RequestBody JSONObject json) {
        return seckillService.info();
    }
}
