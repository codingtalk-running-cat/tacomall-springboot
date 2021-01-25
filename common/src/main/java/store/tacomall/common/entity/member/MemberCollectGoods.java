/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:53:44
 * @LastEditTime: 2020-07-24 10:37:08
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/member/MemberCollectGoods.java
 * @Just do what I think it is right
 */
package store.tacomall.common.entity.member;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class MemberCollectGoods {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}