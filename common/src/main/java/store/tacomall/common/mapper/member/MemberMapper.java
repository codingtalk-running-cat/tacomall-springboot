/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2021-01-20 15:04:57
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/mapper/member/MemberMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.common.mapper.member;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import store.tacomall.common.entity.member.Member;

@Repository
public interface MemberMapper extends BaseMapper<Member> {

    Member getMember(@Param(Constants.WRAPPER) Wrapper<Member> wrapper);

    IPage<Member> getMemberPage(@Param("page") Page<?> page, @Param(Constants.WRAPPER) Wrapper<Member> wrapper);
}
