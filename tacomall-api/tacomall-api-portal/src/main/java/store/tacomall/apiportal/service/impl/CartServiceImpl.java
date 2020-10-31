/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-30 15:59:32
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/impl/CartServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service.impl;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import cn.hutool.core.util.ObjectUtil;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import store.tacomall.common.util.RequestUtil;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.entity.cart.Cart;
import store.tacomall.mapper.cart.CartMapper;
import store.tacomall.apiportal.service.CartService;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    /***
     * @description: 添加购物车
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<String> addCart(int goodsItemId, int quantity) {
        ResponseVo<String> responseVo = new ResponseVo<>();
        Cart cart = new Cart();
        cart.setMemberId(RequestUtil.getLoginUser().getIntValue("id"));
        cart.setGoodsItemId(goodsItemId);
        cart.setQuantity(quantity);
        this.baseMapper.insert(cart);
        responseVo.setData("添加购物车成功");
        return responseVo;
    }

    /***
     * @description: 删除购物车
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Boolean> deleteCart(String cartIds) {
        ResponseVo<Boolean> responseVo = new ResponseVo<>();
        this.baseMapper.delete(
                new QueryWrapper<Cart>().lambda().eq(Cart::getMemberId, RequestUtil.getLoginUser().getInteger("id"))
                        .in(Cart::getId, Arrays.asList(cartIds.split(","))));
        return responseVo;
    }

    /***
     * @description: 获取用户购物车
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<List<Cart>> getCart(JSONObject json) {
        ResponseVo<List<Cart>> responseVo = new ResponseVo<>();
        LambdaQueryWrapper<Cart> q = new QueryWrapper<Cart>().lambda();
        q.eq(Cart::getMemberId, RequestUtil.getLoginUser().getInteger("id"));
        if (ObjectUtil.isNotEmpty(json.getString("ids"))) {
            q.in(Cart::getId, Arrays.asList(json.getString("ids").split(",")));
        }
        q.eq(Cart::getIsDelete, 0);
        responseVo.setData(this.baseMapper.getCarts(q));
        return responseVo;
    }

}
