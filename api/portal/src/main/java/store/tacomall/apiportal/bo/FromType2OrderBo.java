/***
 * @Author: 码上talk|RC
 * @Date: 2020-12-23 15:53:03
 * @LastEditTime: 2020-12-23 15:57:04
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/portal/src/main/java/store/tacomall/apiportal/bo/FromType2OrderBo.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiportal.bo;

import java.util.List;

import lombok.Data;
import store.tacomall.common.entity.merchant.Merchant;

@Data
public class FromType2OrderBo {
    private Merchant merchant;
    private List<FromType2OrderValueBo> value;
}
