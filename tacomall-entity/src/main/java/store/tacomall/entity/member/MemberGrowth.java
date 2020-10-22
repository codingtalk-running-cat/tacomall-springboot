/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:54:59
 * @LastEditTime: ,: 2020-10-20 19:54:21
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/member/MemberGrowth.java
 * @Just do what I think it is right
 */
package store.tacomall.entity.member;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class MemberGrowth {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}
