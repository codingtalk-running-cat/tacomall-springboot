/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-23 09:47:02
 * @LastEditTime: 2021-01-20 11:10:42
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/mapper/goods/GoodsCategoryMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.common.mapper.goods;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import store.tacomall.common.entity.goods.GoodsCategory;

@Repository
public interface GoodsCategoryMapper extends BaseMapper<GoodsCategory> {

    @Select("SELECT * FROM goods_category ${ew.customSqlSegment}")
    IPage<GoodsCategory> getGoodsCategoryPage(@Param("page") Page<?> page,
            @Param(Constants.WRAPPER) Wrapper<GoodsCategory> wrapper);

}
