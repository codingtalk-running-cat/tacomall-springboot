/***
 * @Author: 码上talk|RC
 * @Date: 2020-09-27 15:25:27
 * @LastEditTime: 2020-09-27 15:25:58
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/cn/codingtalk/tacomallmapper/merchant/MerchantUserMapper.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.merchant;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.merchant.MerchantUser;

@Repository
public interface MerchantUserMapper extends BaseMapper<MerchantUser> {

    MerchantUser getUserInfo(int id);

}
