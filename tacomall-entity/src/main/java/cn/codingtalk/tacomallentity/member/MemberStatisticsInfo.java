/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:55:54
 * @LastEditTime: 2020-07-13 14:55:02
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/cn/codingtalk/tacomallentity/member/MemberStatisticsInfo.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.member;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class MemberStatisticsInfo {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}