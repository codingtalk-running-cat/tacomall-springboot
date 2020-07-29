/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 15:37:32
 * @LastEditTime: 2020-07-24 10:35:29
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/cn/codingtalk/tacomallentity/admin/AdminAuthRole.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.admin;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class AdminAuthRole {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String name;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}
