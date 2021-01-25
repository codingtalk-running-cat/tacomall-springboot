/***
 * @Author: ,: 码上talk|RC
 * @Date: ,: 2020-10-21 18:11:32
 * @LastEditTime: 2021-01-18 14:12:36
 * @LastEditors: 码上talk|RC
 * @Description: ,: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/mapper/merchant/MerchantMapper.java
 * @微信: ,:  13680065830
 * @邮箱: ,:  3189482282@qq.com
 * @oops: ,: Just do what I think it is right
 */
package store.tacomall.common.mapper.merchant;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import store.tacomall.common.entity.merchant.Merchant;

@Repository
public interface MerchantMapper extends BaseMapper<Merchant> {

    Merchant getMerchant(@Param(Constants.WRAPPER) Wrapper<Merchant> wrapper);

    IPage<Merchant> getMerchantPage(@Param("page") Page<?> page, @Param(Constants.WRAPPER) Wrapper<Merchant> wrapper);

    Merchant getMerchantByGoodsItemId(@Param("goodsItemId") int goodsItemId);

}
