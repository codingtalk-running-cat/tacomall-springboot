/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-15 15:03:08
 * @LastEditTime: 2021-01-19 14:21:57
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/controller/GoodsController.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiadmin.controller;

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
import store.tacomall.common.vo.ResponsePageVo;
import store.tacomall.common.entity.goods.Goods;
import store.tacomall.common.entity.goods.GoodsCategory;
import store.tacomall.common.entity.goods.GoodsBrand;
import store.tacomall.apiadmin.service.GoodsService;
import store.tacomall.apiadmin.service.GoodsCategoryService;
import store.tacomall.apiadmin.service.GoodsBrandService;

@Api(tags = "商品模块")
@RestController
@RequestMapping(value = "/admin/goods/")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Autowired
    private GoodsBrandService goodsBrandService;

    /***
     * @description: 商品分页
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "商品分页", notes = "商品分页接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "pageIndex", value = "分页码数", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页数量", required = true, paramType = "query"),
            @ApiImplicitParam(name = "json", value = "查询条件", required = true, paramType = "body") })
    @PostMapping("page")
    public ResponsePageVo<List<Goods>> goodsPage(@RequestParam(value = "pageIndex") int pageIndex,
            @RequestParam(value = "pageSize") int pageSize, @RequestBody JSONObject json) {
        return goodsService.getGoodsPage(pageIndex, pageSize, json);
    }

    /***
     * @description: 商品详情
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "商品详情", notes = "商品详情接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "商品ID", required = true, paramType = "query") })
    @PostMapping("info")
    public ResponseVo<Goods> info(@RequestParam(value = "id") int id) {
        return goodsService.info(id);
    }

    /***
     * @description: 商品分类分页
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "商品分类分页", notes = "商品分类分页接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "pageIndex", value = "分页码数", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页数量", required = true, paramType = "query"),
            @ApiImplicitParam(name = "json", value = "查询条件", required = true, paramType = "body") })
    @PostMapping("goodsCategoryPage")
    public ResponsePageVo<List<GoodsCategory>> goodsCategoryPage(@RequestParam(value = "pageIndex") int pageIndex,
            @RequestParam(value = "pageSize") int pageSize, @RequestBody JSONObject json) {
        return goodsCategoryService.getGoodsCategoryPage(pageIndex, pageSize, json);
    }

    /***
     * @description: 商品品牌分页
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "商品品牌分页", notes = "商品品牌分页接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "pageIndex", value = "分页码数", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页数量", required = true, paramType = "query"),
            @ApiImplicitParam(name = "json", value = "查询条件", required = true, paramType = "body") })
    @PostMapping("goodsBrandPage")
    public ResponsePageVo<List<GoodsBrand>> goodsBrandPage(@RequestParam(value = "pageIndex") int pageIndex,
            @RequestParam(value = "pageSize") int pageSize, @RequestBody JSONObject json) {
        return goodsBrandService.getGoodsBrandPage(pageIndex, pageSize, json);
    }
}
