/***
 * @Author: 码上talk|RC
 * @Date: 2020-09-27 15:24:47
 * @LastEditTime: 2020-09-27 15:24:56
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/merchant/MerchantUserLoginLogger.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.common.entity.merchant;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class MerchantUserLoginLogger {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int userId;

    private String ip;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}
