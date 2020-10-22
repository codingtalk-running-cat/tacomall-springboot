/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:58:39
 * @LastEditTime: 2020-07-13 14:56:11
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/goods/GoodsAttrCategory.java
 * @Just do what I think it is right
 */
package store.tacomall.entity.goods;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class GoodsAttrCategory {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}