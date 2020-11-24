/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 15:36:59
 * @LastEditTime: 2020-11-24 17:46:48
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/delivery/Delivery.java
 * @Just do what I think it is right
 */
package store.tacomall.entity.delivery;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Delivery {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}
