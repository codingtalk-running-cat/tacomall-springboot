/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-16 18:08:27
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/cn/codingtalk/tacomallentity/goods/Goods.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.goods;

import java.util.List;
import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Goods {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int is_delete;

    private String name;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private List<GoodsItem> goodsItem;

}
