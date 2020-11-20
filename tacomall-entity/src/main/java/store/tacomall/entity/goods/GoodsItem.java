/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:56:34
 * @LastEditTime: 2020-11-20 16:37:45
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/goods/GoodsItem.java
 * @Just do what I think it is right
 */
package store.tacomall.entity.goods;

import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class GoodsItem {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int goodsId;

    private String attrJson;

    private String name;

    private BigDecimal amount;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}