/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-01 21:04:40
 * @LastEditTime: 2020-07-24 10:35:37
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/cn/codingtalk/tacomallentity/admin/AdminAuthRuleView.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.admin;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class AdminAuthRuleView {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String name;

    private String path;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}
