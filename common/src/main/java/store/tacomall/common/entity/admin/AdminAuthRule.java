/***
* @Author: 码上talk|RC
* @Date: 2020-06-12 15:38:07
 * @LastEditTime: 2021-01-20 14:22:38
 * @LastEditors: 码上talk|RC
* @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/entity/admin/AdminAuthRule.java
* @Just do what I think it is right
*/
package store.tacomall.common.entity.admin;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class AdminAuthRule {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int pId;

    private String name;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}
