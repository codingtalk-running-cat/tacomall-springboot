/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 15:38:07
 * @LastEditTime: 2020-11-23 14:50:08
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/admin/AdminAuthRoute.java
 * @Just do what I think it is right
 */
package store.tacomall.entity.admin;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class AdminAuthRoute {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String name;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}
