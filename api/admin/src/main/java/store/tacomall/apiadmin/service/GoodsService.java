/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-15 15:03:36
 * @LastEditTime: 2021-01-15 15:04:27
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/service/GoodsService.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiadmin.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.alibaba.fastjson.JSONObject;

import store.tacomall.common.entity.goods.Goods;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.vo.ResponsePageVo;

public interface GoodsService extends IService<Goods> {

    /***
     * @description: 平台商品分页
     * @param {type}
     * @return:
     */
    ResponsePageVo<List<Goods>> getGoodsPage(int pageIndex, int pageSize, JSONObject json);

    /***
     * @description: 平台商品详情
     * @param {type}
     * @return:
     */
    ResponseVo<Goods> info(int id);

}