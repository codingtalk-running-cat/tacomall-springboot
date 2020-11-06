/***
 * @Author: 码上talk|RC
 * @Date: 2020-09-27 15:25:27
 * @LastEditTime: 2020-11-06 08:25:50
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/merchant/MerchantUserMapper.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.mapper.merchant;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import store.tacomall.entity.merchant.MerchantUser;

@Repository
public interface MerchantUserMapper extends BaseMapper<MerchantUser> {

    MerchantUser getMerchantUser(@Param(Constants.WRAPPER) Wrapper<MerchantUser> wrapper);

}
