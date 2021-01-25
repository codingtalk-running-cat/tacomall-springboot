/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:45:39
 * @LastEditTime: 2021-01-05 16:50:59
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/entity/order/Order.java
 * @Just do what I think it is right
 */
package store.tacomall.common.entity.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;
import store.tacomall.common.entity.member.Member;

import com.baomidou.mybatisplus.annotation.*;

@Data
@TableName(value = "`order`")
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int memberId;

    private int merchantId;

    private BigDecimal totalAmount;

    private int status;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private Member member;

    @TableField(exist = false)
    private List<OrderMappingGoodsItem> orderMappingGoodsItem;

}
