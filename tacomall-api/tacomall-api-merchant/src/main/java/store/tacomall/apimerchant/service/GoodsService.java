/***
 * @Author: 码上talk|RC
 * @Date: 2020-10-19 16:12:39
 * @LastEditTime: 2020-11-10 16:10:38
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/store/tacomall/apimerchant/service/GoodsService.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apimerchant.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.alibaba.fastjson.JSONObject;

import store.tacomall.entity.goods.Goods;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.vo.ResponsePageVo;

public interface GoodsService extends IService<Goods> {

    /***
     * @description: 商户商品分页
     * @param {type}
     * @return:
     */
    ResponsePageVo<List<Goods>> getGoodsPage(int pageIndex, int pageSize, JSONObject json);

    /***
     * @description: 商户商品详情
     * @param {type}
     * @return:
     */
    ResponseVo<Goods> info(int id);

    /***
     * @description: 商户商品添加
     * @param {type}
     * @return:
     */
    ResponseVo<Boolean> add(JSONObject json);
}
