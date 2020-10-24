/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:32:41
 * @LastEditTime: 2020-10-24 14:14:24
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/GoodsService.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.entity.goods.Goods;

public interface GoodsService extends IService<Goods> {
    /***
     * @description: 获取产品详情
     * @param {type}
     * @return:
     */
    ResponseVo<Goods> getGoods(int id);

    /***
     * @description: 根据产品分类ID查询商品分页
     * @param {type}
     * @return:
     */
    ResponseVo<List<Goods>> getGoodsPage(int pageIndex, int pageSize, JSONObject json);
}
