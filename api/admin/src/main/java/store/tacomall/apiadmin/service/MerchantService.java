/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-18 14:14:49
 * @LastEditTime: 2021-01-20 16:57:53
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/service/MerchantService.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiadmin.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.alibaba.fastjson.JSONObject;

import store.tacomall.common.entity.merchant.Merchant;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.vo.ResponsePageVo;

public interface MerchantService extends IService<Merchant> {

    /***
     * @description: 商户分页
     * @param {type}
     * @return:
     */
    ResponsePageVo<List<Merchant>> getMerchantPage(int pageIndex, int pageSize, JSONObject json);

    /***
     * @description: 商户详情
     * @param {type}
     * @return:
     */
    ResponseVo<Merchant> info(int id);

    /***
     * @description: 商户添加
     * @param {type}
     * @return:
     */
    ResponseVo<Merchant> add(JSONObject json);

}
