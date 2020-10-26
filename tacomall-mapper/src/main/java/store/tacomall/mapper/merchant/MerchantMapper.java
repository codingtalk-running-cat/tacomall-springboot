/***
 * @Author: ,: 码上talk|RC
 * @Date: ,: 2020-10-21 18:11:32
 * @LastEditTime: 2020-10-26 15:52:36
 * @LastEditors: 码上talk|RC
 * @Description: ,: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/merchant/MerchantMapper.java
 * @微信: ,:  13680065830
 * @邮箱: ,:  3189482282@qq.com
 * @oops: ,: Just do what I think it is right
 */
package store.tacomall.mapper.merchant;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import store.tacomall.entity.merchant.Merchant;

@Repository
public interface MerchantMapper extends BaseMapper<Merchant> {

    Merchant getMerchantByGoodsItemId(@Param("goodsItemId") int goodsItemId);

}
