/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 15:04:54
 * @LastEditTime: 2020-07-13 15:05:21
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/cn/codingtalk/tacomallmapper/coupon/CouponMapper.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.coupon;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.coupon.Coupon;

@Repository
public interface CouponMapper extends BaseMapper<Coupon>{
    
}
