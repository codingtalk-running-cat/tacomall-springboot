/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-15 10:01:59
 * @LastEditTime: 2020-07-24 10:35:56
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/cn/codingtalk/tacomallentity/activity/Activity.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.activity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Activity {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}