/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-02 15:26:49
 * @LastEditTime: 2020-11-02 16:20:32
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-entity/src/main/java/store/tacomall/entity/seckill/SeckillGoodsItemApply.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.common.entity.seckill;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

import store.tacomall.common.entity.goods.GoodsItem;

@Data
public class SeckillGoodsItemApply {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int seckillId;

    private int goodsItemId;

    private int totalCount;

    private int sellOutCount;

    private int status;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    @TableField(exist = false)
    private GoodsItem goodsItem;

}
