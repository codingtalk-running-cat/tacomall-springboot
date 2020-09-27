/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-29 09:21:10
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/service/impl/CartServiceImpl.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.service.impl;

import java.util.Map;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import cn.codingtalk.tacomallcommon.utils.RequestUtil;
import cn.codingtalk.tacomallcommon.vo.ResponseVo;

import cn.codingtalk.tacomallentity.cart.Cart;
import cn.codingtalk.tacomallmapper.cart.CartMapper;
import cn.codingtalk.tacomallapiportal.service.CartService;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    /***
     * @description: 添加购物车
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<String> addCarts(List<Map<String, Object>> goodItems) {
        ResponseVo<String> responseVo = new ResponseVo<>();
        responseVo.setData("添加购物车成功");
        return responseVo;
    }

    /***
     * @description: 获取用户购物车
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<List<Cart>> getCarts() {
        ResponseVo<List<Cart>> responseVo = new ResponseVo<>();
        responseVo.setData(this.baseMapper.getCarts(RequestUtil.getLoginUser().getInteger("id")));
        return responseVo;
    }

}
