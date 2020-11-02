/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-02 15:30:05
 * @LastEditTime: 2020-11-02 16:42:43
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/seckill/SeckillGoodsItemApplyMapper.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.mapper.seckill;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.toolkit.Constants;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import store.tacomall.entity.seckill.SeckillGoodsItemApply;

@Repository
public interface SeckillGoodsItemApplyMapper extends BaseMapper<SeckillGoodsItemApply> {

    List<SeckillGoodsItemApply> getSeckillGoodsItemApplys(
            @Param(Constants.WRAPPER) Wrapper<SeckillGoodsItemApply> wrapper);

}
