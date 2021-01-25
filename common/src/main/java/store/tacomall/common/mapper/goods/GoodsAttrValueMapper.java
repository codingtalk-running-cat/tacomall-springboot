/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-20 15:03:11
 * @LastEditTime: 2020-11-20 15:12:13
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/goods/GoodsAttrValueMapper.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.common.mapper.goods;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import store.tacomall.common.entity.goods.GoodsAttrValue;

@Repository
public interface GoodsAttrValueMapper extends BaseMapper<GoodsAttrValue> {

    @Select("SELECT * FROM goods_attr_value WHERE attr_key_id = #{attrKeyId}")
    List<GoodsAttrValue> getGoodsAttrValueByAttrKeyId(@Param("attrKeyId") int attrKeyId);
}
