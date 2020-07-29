/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:58:17
 * @LastEditTime: 2020-07-24 10:36:08
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/cn/codingtalk/tacomallentity/goods/GoodsAftermarket.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.goods;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class GoodsAftermarket {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}