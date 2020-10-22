/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: ,: 2020-10-20 19:14:45
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/member/MemberMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.mapper.member;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import store.tacomall.entity.member.Member;

@Repository
public interface MemberMapper extends BaseMapper<Member> {

    Member getMember(@Param(Constants.WRAPPER) Wrapper<Member> wrapper);
}
