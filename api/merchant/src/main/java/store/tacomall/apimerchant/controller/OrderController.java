/***
 * @Author: 码上talk|RC
 * @Date: 2020-10-19 16:10:40
 * @LastEditTime: 2020-12-15 15:26:31
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/store/tacomall/apimerchant/controller/OrderController.java
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
import store.tacomall.common.vo.ResponsePageVo;
import store.tacomall.common.entity.order.Order;
import store.tacomall.apimerchant.service.OrderService;

@Api(tags = "订单模块")
@RestController
@RequestMapping(value = "/merchant/order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /***
     * @description: 商户订单分页
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "商户订单分页", notes = "商户订单分页接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "pageIndex", value = "分页码数", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页数量", required = true, paramType = "query"),
            @ApiImplicitParam(name = "json", value = "查询条件", required = true, paramType = "body") })
    @PostMapping("page")
    public ResponsePageVo<List<Order>> goodsPage(@RequestParam(value = "pageIndex") int pageIndex,
            @RequestParam(value = "pageSize") int pageSize, @RequestBody JSONObject json) {
        return orderService.getOrderPage(pageIndex, pageSize, json);
    }

    /***
     * @description: 商户订单详情
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "商户订单详情", notes = "商户订单详情接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "订单ID", required = true, paramType = "query") })
    @PostMapping("info")
    public ResponseVo<Order> info(@RequestParam(value = "id") int id) {
        return orderService.info(id);
    }
}
