/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: ,: 2020-10-21 19:54:05
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/goods/GoodsMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.mapper.goods;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import store.tacomall.entity.goods.Goods;

@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

    IPage<Goods> getGoodsPage(@Param("page") Page<?> page, @Param(Constants.WRAPPER) Wrapper<Goods> wrapper);

    Goods getGoods(@Param(Constants.WRAPPER) Wrapper<Goods> wrapper);
}
