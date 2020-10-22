/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-02 09:14:25
 * @LastEditTime: ,: 2020-10-21 18:11:16
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/merchant/Merchant.java
 * @Just do what I think it is right
 */
package store.tacomall.entity.merchant;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Merchant {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}