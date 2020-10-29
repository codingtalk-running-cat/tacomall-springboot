/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-29 17:52:22
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/impl/CartServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service.impl;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import store.tacomall.common.util.RequestUtil;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.entity.cart.Cart;
import store.tacomall.entity.goods.GoodsItem;
import store.tacomall.entity.merchant.Merchant;
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
    public ResponseVo<String> addCarts(int goodsItemId, int quantity) {
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
     * @description: 获取用户购物车
     * @param {type}
     * @return:
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResponseVo<List<Map<String, Object>>> getCart() {
        ResponseVo<List<Map<String, Object>>> responseVo = new ResponseVo<>();
        List<Map<String, Object>> result = new ArrayList<>();
        this.baseMapper.getCarts(
                new QueryWrapper<Cart>().lambda().eq(Cart::getMemberId, RequestUtil.getLoginUser().getInteger("id")))
                .stream().forEach((Cart cart) -> {
                    Map<String, Object> listItem = new HashMap<>();
                    listItem.put("id", cart.getId());
                    listItem.put("quantity", cart.getQuantity());
                    listItem.put("goodsItem", cart.getGoodsItem());
                    for (int i = 0; i < result.size(); i++) {
                        Merchant merchant = (Merchant) result.get(i).get("merchant");
                        if (cart.getMerchant().getId() == merchant.getId()) {
                            List<Map<String, Object>> list = (List<Map<String, Object>>) result.get(i).get("list");
                            list.add(listItem);
                            return;
                        }
                    }
                    Map<String, Object> map = new HashMap<>();
                    List<Map<String, Object>> list = new ArrayList<>();
                    list.add(listItem);
                    map.put("merchant", cart.getMerchant());
                    map.put("list", list);
                    result.add(map);
                });
        responseVo.setData(result);
        return responseVo;
    }

}
