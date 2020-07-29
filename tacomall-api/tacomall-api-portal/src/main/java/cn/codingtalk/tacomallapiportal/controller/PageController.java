
/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 10:51:51
 * @LastEditTime: 2020-07-24 10:34:05
 * @LastEditors: 码上talk|RC
 * @Description: package cn.codingtalk.tacomallapiportal.controller;
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/controller/PageController.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallapiportal.factory.PageFactory;

@Api(tags = "用户模块")
@RestController
@RequestMapping(value = "/portal/page/")
public class PageController {

    @Autowired
    private PageFactory PageFactory;

    @ApiOperation(value = "获取页面信息", notes = "获取页面信息接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "page", value = "page", required = true, paramType = "path") })
    @PostMapping("info")
    public ResponseVo<Map<String, Object>> info(@RequestParam(value = "page") String page) throws Exception {
        return PageFactory.getStrategy(page).buildPage();
    }
}
