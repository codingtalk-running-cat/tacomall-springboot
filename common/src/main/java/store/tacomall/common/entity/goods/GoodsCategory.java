/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:56:54
 * @LastEditTime: ,: 2020-10-21 18:57:24
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/goods/GoodsCategory.java
 * @Just do what I think it is right
 */
package store.tacomall.common.entity.goods;

import java.util.Date;
import java.util.List;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class GoodsCategory {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int pId;

    private int isIndexFloor;

    private int isIndexCategory;

    private String name;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private List<GoodsCategory> children;

}