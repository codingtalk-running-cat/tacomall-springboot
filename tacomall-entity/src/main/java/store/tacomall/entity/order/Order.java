/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:45:39
 * @LastEditTime: 2020-11-03 10:15:43
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/order/Order.java
 * @Just do what I think it is right
 */
package store.tacomall.entity.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
@TableName(value = "`order`")
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int memberId;

    private BigDecimal totalAmount;

    private int status;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private List<OrderMappingGoodsItem> orderMappingGoodsItem;

}
