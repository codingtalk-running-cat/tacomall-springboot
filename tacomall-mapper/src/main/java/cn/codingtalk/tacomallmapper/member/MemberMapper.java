/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-06-12 14:54:49
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-mapper\src\main\java\cn\codingtalk\tacomallmapper\member\MemberMapper.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.member;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.member.Member;

@Repository
public interface MemberMapper extends BaseMapper<Member> {

    Member getMember(String key, Object value);
}
