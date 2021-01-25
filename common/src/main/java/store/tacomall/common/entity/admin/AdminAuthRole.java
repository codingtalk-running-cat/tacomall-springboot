/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 15:37:32
 * @LastEditTime: 2021-01-12 15:46:25
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/entity/admin/AdminAuthRole.java
 * @Just do what I think it is right
 */
package store.tacomall.common.entity.admin;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class AdminAuthRole {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int pId;

    private String name;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}
