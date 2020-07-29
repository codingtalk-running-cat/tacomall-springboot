/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 15:07:31
 * @LastEditTime: 2020-07-13 15:07:57
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/cn/codingtalk/tacomallmapper/member/MemberAddressMapper.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.member;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.member.MemberAddress;

@Repository
public interface MemberAddressMapper extends BaseMapper<MemberAddress>{
    
}