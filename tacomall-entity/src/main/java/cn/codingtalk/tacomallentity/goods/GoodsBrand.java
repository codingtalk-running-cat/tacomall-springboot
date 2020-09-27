/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:57:06
 * @LastEditTime: 2020-07-24 10:36:28
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/cn/codingtalk/tacomallentity/goods/GoodsBrand.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.goods;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class GoodsBrand {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}