/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-11-05 08:44:06
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/controller/GoodsController.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.entity.goods.Goods;
import store.tacomall.apiportal.service.GoodsService;

@Api(tags = "产品模块")
@RestController
@RequestMapping(value = "/portal/goods/")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /***
     * @description:
     * @param {type} 产品分页
     * @return:
     */
    @ApiOperation(value = "产品分页", notes = "产品分页接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "pageIndex", value = "分页码数", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页数量", required = true, paramType = "query"),
            @ApiImplicitParam(name = "json", value = "查询条件", required = true, paramType = "body") })
    @PostMapping("getGoodsPage")
    public ResponseVo<List<Goods>> getGoodsPage(@RequestParam(value = "pageIndex") int pageIndex,
            @RequestParam(value = "pageSize") int pageSize, @RequestBody JSONObject json) {
        return this.goodsService.getGoodsPage(pageIndex, pageSize, json);
    }
}
