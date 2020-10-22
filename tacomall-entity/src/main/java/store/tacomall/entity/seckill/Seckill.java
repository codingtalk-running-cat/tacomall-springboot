/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:45:52
 * @LastEditTime: 2020-07-24 10:42:22
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/seckill/Seckill.java
 * @Just do what I think it is right
 */
package store.tacomall.entity.seckill;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Seckill {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}