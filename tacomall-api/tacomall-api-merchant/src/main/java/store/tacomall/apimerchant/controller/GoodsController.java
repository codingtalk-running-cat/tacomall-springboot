/***
 * @Author: 码上talk|RC
 * @Date: 2020-10-19 16:10:26
 * @LastEditTime: 2020-10-26 17:50:49
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/store/tacomall/apimerchant/controller/GoodsController.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apimerchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;
import com.alibaba.fastjson.JSONObject;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.entity.goods.Goods;
import store.tacomall.apimerchant.service.goods.GoodsService;

@Api(tags = "商品模块")
@RestController
@RequestMapping(value = "/merchant/goods/")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /***
     * @description: 商户商品分页
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "商家商品分页", notes = "商家商品分页接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "pageIndex", value = "分页码数", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页数量", required = true, paramType = "query") })
    @PostMapping("page")
    public ResponseVo<List<Goods>> goodsPage(@RequestParam(value = "pageIndex") int pageIndex,
            @RequestParam(value = "pageSize") int pageSize) {
        return goodsService.getGoodsPage(pageIndex, pageSize);
    }

    /***
     * @description: 商户商品详情
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "商户商品详情", notes = "商户商品详情接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "商品ID", required = true, paramType = "query") })
    @PostMapping("info")
    public ResponseVo<Goods> info(@RequestParam(value = "id") int id) {
        return goodsService.info(id);
    }

    /***
     * @description: 商户商品添加
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "商户商品添加", notes = "商户商品添加接口", httpMethod = "POST")
    @ApiImplicitParams({})
    @PostMapping("add")
    public ResponseVo<Boolean> add(@RequestBody JSONObject json) {
        return goodsService.add(json);
    }
}
