/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-23 09:47:02
 * @LastEditTime: 2020-07-23 09:48:01
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/cn/codingtalk/tacomallmapper/goods/GoodsCategoryMapper.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.goods;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.goods.GoodsCategory;

@Repository
public interface GoodsCategoryMapper extends BaseMapper<GoodsCategory> {
}
