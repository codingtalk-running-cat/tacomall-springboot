/***
 * @Author: 码上talk|RC
 * @Date: 2020-09-27 15:24:02
 * @LastEditTime: 2020-12-15 15:58:08
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/merchant/MerchantUser.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.common.entity.merchant;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class MerchantUser {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int merchantId;

    private String username;

    private String passwd;

    private int status;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private Merchant merchant;
}