/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-16 17:14:14
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/cn/codingtalk/tacomallmapper/goods/GoodsMapper.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.goods;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.goods.Goods;

@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

    Goods getGoods(@Param("id") int id);
}
