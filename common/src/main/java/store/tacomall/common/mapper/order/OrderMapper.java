/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 15:06:00
 * @LastEditTime: 2020-12-23 17:25:20
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/mapper/order/OrderMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.common.mapper.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.toolkit.Constants;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import store.tacomall.common.entity.order.Order;

@Repository
public interface OrderMapper extends BaseMapper<Order> {

    Order getOrder(@Param(Constants.WRAPPER) Wrapper<Order> wrapper);

    IPage<Order> getOrderPage(@Param("page") Page<?> page, @Param(Constants.WRAPPER) Wrapper<Order> wrapper);

    List<Order> getOrders(@Param(Constants.WRAPPER) Wrapper<Order> wrapper);

}
