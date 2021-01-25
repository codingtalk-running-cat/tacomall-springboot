/***
 * @Author: 码上talk|RC
 * @Date: 2020-10-30 18:59:33
 * @LastEditTime: 2021-01-05 17:01:52
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/mapper/order/OrderMappingGoodsItemMapper.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.common.mapper.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import store.tacomall.common.entity.order.OrderMappingGoodsItem;

@Repository
public interface OrderMappingGoodsItemMapper extends BaseMapper<OrderMappingGoodsItem> {

    @Select("SELECT * FROM order_mapping_goods_item WHERE order_id = #{orderId} AND is_delete = 0")
    List<OrderMappingGoodsItem> getOrderMappingGoodsItemsByOrderId(@Param("orderId") int orderId);
}
