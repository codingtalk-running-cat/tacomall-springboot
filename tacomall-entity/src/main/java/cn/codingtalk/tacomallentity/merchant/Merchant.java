/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-02 09:14:25
 * @LastEditTime: 2020-07-24 10:42:12
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/cn/codingtalk/tacomallentity/merchant/Merchant.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.merchant;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Merchant {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String username;

    private String passwd;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}