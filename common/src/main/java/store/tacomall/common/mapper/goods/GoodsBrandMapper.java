/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-14 11:18:09
 * @LastEditTime: 2021-01-20 11:10:34
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/mapper/goods/GoodsBrandMapper.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
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

import store.tacomall.common.entity.goods.GoodsBrand;

@Repository
public interface GoodsBrandMapper extends BaseMapper<GoodsBrand> {

    @Select("SELECT * FROM goods_brand ${ew.customSqlSegment}")
    IPage<GoodsBrand> getGoodsBrandPage(@Param("page") Page<?> page,
            @Param(Constants.WRAPPER) Wrapper<GoodsBrand> wrapper);

}
