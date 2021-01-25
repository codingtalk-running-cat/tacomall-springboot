/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-25 15:27:05
 * @LastEditTime: 2020-11-25 15:51:49
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/GoodsItemService.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiportal.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.entity.goods.GoodsItem;

public interface GoodsItemService extends IService<GoodsItem> {

    /***
     * @description: 获取商品详情
     * @param {type}
     * @return:
     */
    ResponseVo<GoodsItem> getGoodsItem(JSONObject json);

}
