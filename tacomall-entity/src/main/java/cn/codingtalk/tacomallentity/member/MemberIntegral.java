/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:55:16
 * @LastEditTime: 2020-07-24 10:40:18
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/cn/codingtalk/tacomallentity/member/MemberIntegral.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.member;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class MemberIntegral {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}
