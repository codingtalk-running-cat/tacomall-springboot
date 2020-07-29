/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-24 10:37:01
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/cn/codingtalk/tacomallentity/member/Member.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.member;

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

    private int integral;

    private int growth;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private MemberWeixin userWeixin;
}
