/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:45:05
 * @LastEditTime: 2020-12-23 16:37:22
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/entity/cart/Cart.java
 * @Just do what I think it is right
 */
package store.tacomall.common.entity.cart;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

import store.tacomall.common.entity.goods.GoodsItem;
import store.tacomall.common.entity.member.Member;
import store.tacomall.common.entity.merchant.Merchant;

@Data
public class Cart {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int memberId;

    private int goodsItemId;

    private int quantity;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private Member member;

    @TableField(exist = false)
    private Merchant merchant;

    @TableField(exist = false)
    private GoodsItem goodsItem;

}