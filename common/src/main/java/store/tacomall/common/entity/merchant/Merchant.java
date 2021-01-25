/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-02 09:14:25
 * @LastEditTime: 2021-01-22 11:13:07
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/entity/merchant/Merchant.java
 * @Just do what I think it is right
 */
package store.tacomall.common.entity.merchant;

import java.util.Date;
import java.util.List;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Merchant {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String name;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private List<MerchantUser> merchantUsers;
}