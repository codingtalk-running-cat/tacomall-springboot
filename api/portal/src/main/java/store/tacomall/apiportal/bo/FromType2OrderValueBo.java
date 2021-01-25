/***
 * @Author: 码上talk|RC
 * @Date: 2020-12-23 15:53:24
 * @LastEditTime: 2020-12-23 16:06:28
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/portal/src/main/java/store/tacomall/apiportal/bo/FromType2OrderValueBo.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiportal.bo;

import lombok.Data;
import store.tacomall.common.entity.goods.GoodsItem;

@Data
public class FromType2OrderValueBo {
    private int quantity;
    private GoodsItem goodsItem;
}
