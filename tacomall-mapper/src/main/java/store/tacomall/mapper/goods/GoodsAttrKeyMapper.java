/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-20 15:02:59
 * @LastEditTime: 2020-11-20 15:06:13
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/goods/GoodsAttrKeyMapper.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.mapper.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import store.tacomall.entity.goods.GoodsAttrKey;

@Repository
public interface GoodsAttrKeyMapper extends BaseMapper<GoodsAttrKey> {

    List<GoodsAttrKey> getGoodsAttrKeys(@Param(Constants.WRAPPER) Wrapper<GoodsAttrKey> wrapper);
}
