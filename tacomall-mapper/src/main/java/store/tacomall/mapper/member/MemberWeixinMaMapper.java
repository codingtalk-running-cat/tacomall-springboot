/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 14:45:58
 * @LastEditTime: ,: 2020-10-21 18:39:40
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/member/MemberWeixinMaMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.mapper.member;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import store.tacomall.entity.member.MemberWeixinMa;

@Repository
public interface MemberWeixinMaMapper extends BaseMapper<MemberWeixinMa> {

    @Select("SELECT * FROM member_weixin_ma WHERE member_id = #{memberId}")
    MemberWeixinMa getMemberWeixinMaByMemberId(@Param("memberId") int memberId);

}
