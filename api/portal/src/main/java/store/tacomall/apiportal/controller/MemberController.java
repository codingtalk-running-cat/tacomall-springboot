/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-12-25 19:10:10
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/portal/src/main/java/store/tacomall/apiportal/controller/MemberController.java
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

import store.tacomall.apiportal.annotation.LoginUser;
import store.tacomall.common.entity.cart.Cart;
import store.tacomall.common.entity.member.Member;
import store.tacomall.common.entity.order.Order;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.apiportal.service.MemberService;
import store.tacomall.apiportal.service.CartService;
import store.tacomall.apiportal.service.OrderService;
import store.tacomall.apiportal.factory.OrderFactory;

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

    @Autowired
    private OrderFactory orderFactory;

    /***
     * @description: 微信用户登录
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "小程序用户注册接口", notes = "小程序用户注册接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "appid", value = "微信小程序appid", required = true, paramType = "query"),
            @ApiImplicitParam(name = "json", value = "微信授权回调数据", required = true, paramType = "body") })
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
    @LoginUser
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
    @LoginUser
    @PostMapping("addCart")
    public ResponseVo<String> addCart(@RequestParam(value = "goodsItemId") int goodsItemId,
            @RequestParam(value = "quantity") int quantity) {
        return this.cartService.addCart(goodsItemId, quantity);
    }

    /***
     * @description:
     * @param {type} 获取用户购物车
     * @return:
     */
    @ApiOperation(value = "用户购物车", notes = "用户购物车接口", httpMethod = "POST")
    @ApiImplicitParams({})
    @LoginUser
    @PostMapping("getCarts")
    public ResponseVo<List<Cart>> getCarts() {
        return this.cartService.getCarts(new JSONObject());
    }

    /***
     * @description:
     * @param {type} 获取用户购物车
     * @return:
     */
    @ApiOperation(value = "用户删除购物车", notes = "用户删除购物车接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cartIds", value = "购物车记录ID字符串", required = true, paramType = "query") })
    @LoginUser
    @PostMapping("deleteCart")
    public ResponseVo<Boolean> deleteCart(@RequestParam(value = "cartIds") String cartIds) {
        return this.cartService.deleteCart(cartIds);
    }

    /***
     * @description:
     * @param {type} 添加用户订单
     * @return:
     */
    @ApiOperation(value = "添加用户订单", notes = "添加用户订单接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "fromType", value = "生成订单入口", required = true, paramType = "query"),
            @ApiImplicitParam(name = "json", value = "生成订单数据", required = true, paramType = "body") })
    @LoginUser
    @PostMapping("addOrder")
    public ResponseVo<List<Order>> addOrder(@RequestParam(value = "fromType") String fromType,
            @RequestBody JSONObject json) {
        return orderFactory.getStrategy(fromType).genOrder(json);
    }

    /***
     * @description:
     * @param {type} 获取用户订单
     * @return:
     */
    @ApiOperation(value = "用户订单", notes = "用户订单接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "pageIndex", value = "分页页数", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页码数", required = true, paramType = "query"),
            @ApiImplicitParam(name = "json", value = "查询条件", required = true, paramType = "body") })
    @LoginUser
    @PostMapping("getOrderPage")
    public ResponseVo<List<Order>> getOrderPage(@RequestParam(value = "pageIndex") int pageIndex,
            @RequestParam(value = "pageSize") int pageSize, @RequestBody JSONObject json) {
        return this.orderService.getOrderPage(pageIndex, pageSize, json);
    }
}
