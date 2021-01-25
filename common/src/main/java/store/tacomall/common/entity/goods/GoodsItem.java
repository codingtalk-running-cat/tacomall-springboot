/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:56:34
 * @LastEditTime: 2020-12-29 21:06:24
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/entity/goods/GoodsItem.java
 * @Just do what I think it is right
 */
package store.tacomall.common.entity.goods;

import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;
import store.tacomall.common.entity.merchant.Merchant;

@Data
public class GoodsItem {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int goodsId;

    private String attrJson;

    private String name;

    private String cover;

    private BigDecimal amount;

    private int stock;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private Merchant merchant;

    @TableField(exist = false)
    private Goods goods;

}