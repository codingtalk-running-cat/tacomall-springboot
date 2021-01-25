/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:54:40
 * @LastEditTime: 2020-07-13 14:54:02
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/member/MemberCoupon.java
 * @Just do what I think it is right
 */
package store.tacomall.common.entity.member;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class MemberCoupon {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}