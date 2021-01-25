/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-16 17:31:01
 * @LastEditTime: 2020-12-21 15:36:24
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/goods/GoodsItemMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.common.mapper.goods;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import store.tacomall.common.entity.goods.GoodsItem;

@Repository
public interface GoodsItemMapper extends BaseMapper<GoodsItem> {

    GoodsItem getGoodsItem(@Param(Constants.WRAPPER) Wrapper<GoodsItem> wrapper);

    List<GoodsItem> getGoodsItemById(@Param("id") int id);

    @Select("SELECT * FROM goods_item WHERE goods_id = #{goodsId} AND is_delete = 0")
    List<GoodsItem> getGoodsItemsByGoodsId(@Param("goodsId") int goodsId);

    @Update("UPDATE goods_item SET stock = stock - ${count} WHERE id = ${id} AND stock >= ${count} AND is_delete = 0")
    int minus(@Param("id") int id, @Param("count") int count);
}
