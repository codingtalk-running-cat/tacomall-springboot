/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:54:59
 * @LastEditTime: 2020-07-24 10:37:16
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/cn/codingtalk/tacomallentity/member/MemberGrowth.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.member;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class MemberGrowth {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}
