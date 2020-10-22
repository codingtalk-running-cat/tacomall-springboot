/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 15:38:07
 * @LastEditTime: 2020-07-02 14:24:06
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/admin/AdminAuthRule.java
 * @Just do what I think it is right
 */
package store.tacomall.entity.admin;

import java.util.List;
import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class AdminAuthRule {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String name;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private List<AdminAuthRuleView> view;
}
