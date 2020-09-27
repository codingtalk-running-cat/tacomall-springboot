/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 15:37:09
 * @LastEditTime: 2020-07-01 21:05:58
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/cn/codingtalk/tacomallentity/admin/AdminUserLoginLogger.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.admin;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class AdminUserLoginLogger {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int userId;

    private String ip;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}
