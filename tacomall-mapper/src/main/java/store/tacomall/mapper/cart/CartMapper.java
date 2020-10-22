/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 15:04:03
 * @LastEditTime: 2020-07-24 11:22:09
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/cart/CartMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.mapper.cart;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import store.tacomall.entity.cart.Cart;

@Repository
public interface CartMapper extends BaseMapper<Cart> {

    List<Cart> getCarts(@Param("memberId") int memberId);
}
