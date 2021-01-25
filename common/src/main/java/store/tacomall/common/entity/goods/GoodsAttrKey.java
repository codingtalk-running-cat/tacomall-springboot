/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:58:53
 * @LastEditTime: 2020-11-20 15:28:57
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/goods/GoodsAttrKey.java
 * @Just do what I think it is right
 */
package store.tacomall.common.entity.goods;

import java.util.List;
import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class GoodsAttrKey {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int categoryId;

    private String name;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private List<GoodsAttrValue> goodsAttrValue;

}