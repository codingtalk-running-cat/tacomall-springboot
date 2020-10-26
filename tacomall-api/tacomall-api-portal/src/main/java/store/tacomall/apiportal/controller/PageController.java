
/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 10:51:51
 * @LastEditTime: 2020-10-26 18:41:39
 * @LastEditors: 码上talk|RC
 * @Description: package store.tacomall.apiportal.controller;
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/controller/PageController.java
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
import store.tacomall.apiportal.factory.PageFactory;

@Api(tags = "用户模块")
@RestController
@RequestMapping(value = "/portal/page/")
public class PageController {

    @Autowired
    private PageFactory PageFactory;

    @ApiOperation(value = "获取页面信息", notes = "获取页面信息接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "page", value = "页面ID", required = true, paramType = "query"),
            @ApiImplicitParam(name = "json", value = "页面参数", required = true, paramType = "body") })
    @PostMapping("info")
    public ResponseVo<Map<String, Object>> info(@RequestParam(value = "page") String page, @RequestBody JSONObject json)
            throws Exception {
        return PageFactory.getStrategy(page).buildPage(json);
    }
}
