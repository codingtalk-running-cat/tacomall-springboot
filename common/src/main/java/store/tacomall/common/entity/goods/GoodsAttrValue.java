/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:59:03
 * @LastEditTime: 2020-11-20 15:05:35
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/goods/GoodsAttrValue.java
 * @Just do what I think it is right
 */
package store.tacomall.common.entity.goods;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class GoodsAttrValue {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int attrKeyId;

    private String name;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}