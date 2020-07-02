/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-02 09:18:03
 * @LastEditTime: 2020-07-02 09:19:30
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/cn/codingtalk/tacomallmapper/merchant/MerchantMapper.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.merchant;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.merchant.Merchant;

@Repository
public interface MerchantMapper extends BaseMapper<Merchant> {

}