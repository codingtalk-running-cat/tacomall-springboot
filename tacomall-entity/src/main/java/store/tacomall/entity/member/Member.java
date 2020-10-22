/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: ,: 2020-10-21 18:42:44
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/member/Member.java
 * @Just do what I think it is right
 */
package store.tacomall.entity.member;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Member {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String username;

    private String passwd;

    private String nickname;

    private String avatar;

    private Date birthday;

    private String signature;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private MemberWeixin memberWeixin;

    @TableField(exist = false)
    private MemberWeixinMa memberWeixinMa;

    @TableField(exist = false)
    private MemberStatisticsInfo memberStatisticsInfo;
}
