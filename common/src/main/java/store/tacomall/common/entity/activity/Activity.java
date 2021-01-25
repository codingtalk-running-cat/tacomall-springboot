/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-15 10:01:59
 * @LastEditTime: 2020-12-23 14:20:22
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/entity/activity/Activity.java
 * @Just do what I think it is right
 */
package store.tacomall.common.entity.activity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Activity {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String cover;

    private String url;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}