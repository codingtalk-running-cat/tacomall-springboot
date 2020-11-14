/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:57:06
 * @LastEditTime: 2020-11-14 11:17:55
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/goods/GoodsBrand.java
 * @Just do what I think it is right
 */
package store.tacomall.entity.goods;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class GoodsBrand {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String name;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}