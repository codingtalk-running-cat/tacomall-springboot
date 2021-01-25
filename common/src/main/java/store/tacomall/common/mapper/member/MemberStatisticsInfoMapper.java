/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 15:11:28
 * @LastEditTime: ,: 2020-10-21 18:40:00
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/member/MemberStatisticsInfoMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.common.mapper.member;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import store.tacomall.common.entity.member.MemberStatisticsInfo;

@Repository
public interface MemberStatisticsInfoMapper extends BaseMapper<MemberStatisticsInfo> {

    @Select("SELECT * FROM member_statistics_info WHERE member_id = #{memberId}")
    MemberStatisticsInfo getMemberStatisticsInfoByMemberId(@Param("memberId") int memberId);

}
