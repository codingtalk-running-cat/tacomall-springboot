/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-16 17:31:01
 * @LastEditTime: 2020-11-03 09:41:09
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/goods/GoodsItemMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.mapper.goods;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import store.tacomall.entity.goods.GoodsItem;

@Repository
public interface GoodsItemMapper extends BaseMapper<GoodsItem> {

    @Select("SELECT * FROM goods_item WHERE id = #{id}")
    List<GoodsItem> getGoodsItemById(@Param("id") int id);

    @Select("SELECT * FROM goods_item WHERE goods_id = #{goodsId}")
    List<GoodsItem> getGoodsItemsByGoodsId(@Param("goodsId") int goodsId);
}
