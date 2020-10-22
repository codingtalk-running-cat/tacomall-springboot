/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: ,: 2020-10-21 20:13:32
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/goods/Goods.java
 * @Just do what I think it is right
 */
package store.tacomall.entity.goods;

import java.util.List;
import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Goods {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int merchantId;

    private int goodsCategoryId;

    private String name;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private List<GoodsItem> goodsItem;

}
