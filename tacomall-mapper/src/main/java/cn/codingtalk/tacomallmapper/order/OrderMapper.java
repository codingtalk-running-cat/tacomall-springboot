/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 15:06:00
 * @LastEditTime: 2020-07-24 11:22:19
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/cn/codingtalk/tacomallmapper/order/OrderMapper.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.order;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.codingtalk.tacomallentity.order.Order;

@Repository
public interface OrderMapper extends BaseMapper<Order> {

    IPage<Order> getOrderPage(@Param("page") Page<?> page, @Param("memberId") int memberId);

}
