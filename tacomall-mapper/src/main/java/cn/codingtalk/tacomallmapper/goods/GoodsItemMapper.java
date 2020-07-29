/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-16 17:31:01
 * @LastEditTime: 2020-07-24 11:03:40
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/cn/codingtalk/tacomallmapper/goods/GoodsItemMapper.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.goods;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.goods.GoodsItem;

@Repository
public interface GoodsItemMapper extends BaseMapper<GoodsItem> {

    @Select("SELECT * FROM goods_item WHERE goods_id = #{id}")
    List<GoodsItem> getGoodsItemById(@Param("id") int id);

    @Select("SELECT * FROM goods_item WHERE goods_id = #{goodsId}")
    List<GoodsItem> getGoodsItemByGoodsId(@Param("goodsId") int goodsId);
}
