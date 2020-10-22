/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:45:23
 * @LastEditTime: 2020-07-13 14:52:59
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/coupon/Coupon.java
 * @Just do what I think it is right
 */
package store.tacomall.entity.coupon;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Coupon {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}
