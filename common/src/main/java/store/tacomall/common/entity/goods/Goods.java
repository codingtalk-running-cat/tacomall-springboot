/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-12-29 17:03:11
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/entity/goods/Goods.java
 * @Just do what I think it is right
 */
package store.tacomall.common.entity.goods;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;
import store.tacomall.common.entity.merchant.Merchant;

@Data
public class Goods {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int goodsBrandId;

    private int merchantId;

    private String goodsCategoryId;

    private String name;

    private String cover;

    private BigDecimal amount;

    private BigDecimal marketAmount;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private Merchant merchant;

    @TableField(exist = false)
    private List<GoodsItem> goodsItem;

}
