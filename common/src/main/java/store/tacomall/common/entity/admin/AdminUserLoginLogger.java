/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 15:37:09
 * @LastEditTime: 2020-10-19 17:47:46
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/admin/AdminUserLoginLogger.java
 * @Just do what I think it is right
 */
package store.tacomall.common.entity.admin;

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
