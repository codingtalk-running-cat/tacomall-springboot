/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:45:05
 * @LastEditTime: 2020-07-24 11:01:01
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/cn/codingtalk/tacomallentity/cart/Cart.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.cart;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

import cn.codingtalk.tacomallentity.goods.GoodsItem;

@Data
public class Cart {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int memberId;

    private int goodsItemId;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private GoodsItem goodsItem;

}