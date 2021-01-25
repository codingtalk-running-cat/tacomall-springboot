/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:55:54
 * @LastEditTime: ,: 2020-10-21 14:38:36
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/member/MemberStatisticsInfo.java
 * @Just do what I think it is right
 */
package store.tacomall.common.entity.member;

import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class MemberStatisticsInfo {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int memberId;

    private BigDecimal consumeAmount;

    private int orderNonPaymentCount;

    private int orderPaidCount;

    private int orderDoneCount;

    private int orderReturnCount;

    private int integralCount;

    private int growthCount;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}