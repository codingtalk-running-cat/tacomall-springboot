/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-02 15:30:05
 * @LastEditTime: 2021-01-05 17:01:42
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/mapper/seckill/SeckillGoodsItemApplyMapper.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.common.mapper.seckill;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import store.tacomall.common.entity.seckill.SeckillGoodsItemApply;

@Repository
public interface SeckillGoodsItemApplyMapper extends BaseMapper<SeckillGoodsItemApply> {

    SeckillGoodsItemApply getSeckillGoodsItemApply(@Param(Constants.WRAPPER) Wrapper<SeckillGoodsItemApply> wrapper);

    List<SeckillGoodsItemApply> getSeckillGoodsItemApplys(
            @Param(Constants.WRAPPER) Wrapper<SeckillGoodsItemApply> wrapper);

    @Update("update seckill_goods_item_apply set sell_out_count = sell_out_count + 1 where id = ${id} AND total_count > sell_out_count AND is_delete = 0")
    int minusOne(@Param("id") int id);

}
