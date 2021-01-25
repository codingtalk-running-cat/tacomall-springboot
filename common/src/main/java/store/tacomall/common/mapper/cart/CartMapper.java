/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 15:04:03
 * @LastEditTime: 2020-12-21 15:00:41
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/cart/CartMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.common.mapper.cart;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import store.tacomall.common.entity.cart.Cart;

@Repository
public interface CartMapper extends BaseMapper<Cart> {

    Cart getCart(@Param(Constants.WRAPPER) Wrapper<Cart> wrapper);

    List<Cart> getCarts(@Param(Constants.WRAPPER) Wrapper<Cart> wrapper);
}
