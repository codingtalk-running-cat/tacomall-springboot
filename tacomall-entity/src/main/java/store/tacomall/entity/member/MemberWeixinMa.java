/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:54:11
 * @LastEditTime: 2020-06-12 10:06:49
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-entity\src\main\java\cn\codingtalk\tacomallentity\member\MemberWeixinMa.java
 * @Just do what I think it is right
 */
package store.tacomall.entity.member;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class MemberWeixinMa {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int memberId;

    private String openId;

    private int isDelete;

    private Date createtime;

    private Date updateTime;

    private Date deleteTime;
}
