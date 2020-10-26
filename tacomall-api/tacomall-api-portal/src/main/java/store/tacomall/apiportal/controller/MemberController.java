/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-26 19:19:27
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/controller/MemberController.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.controller;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import store.tacomall.apiportal.annotation.IgnoreAuth;
import store.tacomall.apiportal.annotation.RequireAuth;
import store.tacomall.entity.member.Member;
import store.tacomall.entity.order.Order;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.apiportal.service.MemberService;
import store.tacomall.apiportal.service.CartService;
import store.tacomall.apiportal.service.OrderService;

@Api(tags = "用户模块")
@RestController
@RequestMapping(value = "/portal/member/")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    /***
     * @description: 微信用户登录
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "小程序用户注册接口", notes = "小程序用户注册接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "appid", value = "微信小程序appid", required = true, paramType = "query"),
            @ApiImplicitParam(name = "json", value = "微信授权回调数据", required = true, paramType = "body") })
    @IgnoreAuth
    @PostMapping("wxMaLogin")
    public ResponseVo<String> miniAppLogin(@RequestParam(value = "appid") String appid, @RequestBody JSONObject json)
            throws Exception {
        return this.memberService.wxMaLogin(appid, json);
    }

    /***
     * @description: 获取用户信息
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "用户信息", notes = "用户信息接口", httpMethod = "POST")
    @ApiImplicitParams({})
    @RequireAuth
    @PostMapping("info")
    public ResponseVo<Member> info() {
        return this.memberService.info();
    }

    /***
     * @description: 添加用户购物车
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "添加购物车", notes = "添加购物车接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "goodsItemId", value = "商品ID", required = true, paramType = "query"),
            @ApiImplicitParam(name = "quantity", value = "商品数量", required = true, paramType = "query") })
    @RequireAuth
    @PostMapping("addCart")
    public ResponseVo<String> addCart(@RequestParam(value = "goodsItemId") int goodsItemId,
            @RequestParam(value = "quantity") int quantity) {
        return this.cartService.addCarts(goodsItemId, quantity);
    }

    /***
     * @description:
     * @param {type} 获取用户购物车
     * @return:
     */
    @ApiOperation(value = "用户购物车", notes = "用户购物车接口", httpMethod = "POST")
    @ApiImplicitParams({})
    @RequireAuth
    @PostMapping("getCart")
    public ResponseVo<List<Map<String, Object>>> getCart() {
        return this.cartService.getCart();
    }

    /***
     * @description:
     * @param {type} 添加用户订单
     * @return:
     */
    @ApiOperation(value = "添加用户订单", notes = "添加用户订单接口", httpMethod = "POST")
    @ApiImplicitParams({})
    @RequireAuth
    @PostMapping("addOrder")
    public ResponseVo<Order> addOrder() {
        return this.orderService.addOrder();
    }

    /***
     * @description:
     * @param {type} 获取用户订单
     * @return:
     */
    @ApiOperation(value = "用户订单", notes = "用户订单接口", httpMethod = "POST")
    @ApiImplicitParams({})
    @RequireAuth
    @PostMapping("getOrderPage")
    public ResponseVo<List<Order>> getOrderPage() {
        return this.orderService.getOrderPage();
    }
}
