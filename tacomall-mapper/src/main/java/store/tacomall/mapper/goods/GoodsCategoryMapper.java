/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-23 09:47:02
 * @LastEditTime: ,: 2020-10-21 17:15:40
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/goods/GoodsCategoryMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.mapper.goods;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import store.tacomall.entity.goods.GoodsCategory;

@Repository
public interface GoodsCategoryMapper extends BaseMapper<GoodsCategory> {

    @Select("SELECT * FROM goods_category")
    IPage<GoodsCategory> getGoodsCategoryPage(@Param("page") Page<?> page);

}
