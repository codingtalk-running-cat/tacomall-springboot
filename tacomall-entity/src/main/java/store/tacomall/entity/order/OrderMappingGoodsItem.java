/***
 * @Author: 码上talk|RC
 * @Date: 2020-10-30 18:05:13
 * @LastEditTime: 2020-10-30 18:07:28
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/order/OrderMappingGoodsItem.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.entity.order;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class OrderMappingGoodsItem {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int orderId;

    private int goodsItemId;

    private BigDecimal amount;

    private int quantity;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}
