/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-24 14:56:30
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
import store.tacomall.entity.cart.Cart;
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
    @ApiImplicitParams({ @ApiImplicitParam(name = "appid", value = "appid", required = true, paramType = "query"),
            @ApiImplicitParam(name = "json", value = "json", required = true, paramType = "body") })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodItems", value = "goodItems", required = true, paramType = "query") })
    @RequireAuth
    @PostMapping("addCarts")
    public ResponseVo<String> addCart(@RequestParam(value = "goodItems") List<Map<String, Object>> goodItems) {
        return this.cartService.addCarts(goodItems);
    }

    /***
     * @description:
     * @param {type} 获取用户购物车
     * @return:
     */
    @ApiOperation(value = "用户购物车", notes = "用户购物车接口", httpMethod = "POST")
    @ApiImplicitParams({})
    @RequireAuth
    @PostMapping("getCarts")
    public ResponseVo<List<Cart>> getCarts() {
        return this.cartService.getCarts();
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
