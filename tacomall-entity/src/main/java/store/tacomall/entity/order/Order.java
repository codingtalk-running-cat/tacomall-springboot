/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:45:39
 * @LastEditTime: 2020-07-13 14:53:13
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/order/Order.java
 * @Just do what I think it is right
 */
package store.tacomall.entity.order;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}
