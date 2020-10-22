/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:36:37
 * @LastEditTime: ,: 2020-10-21 18:59:14
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/GoodsCategoryService.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.entity.goods.GoodsCategory;

public interface GoodsCategoryService extends IService<GoodsCategory> {

    /***
     * @description: 获取首页楼层分类
     * @param {type}
     * @return:
     */
    ResponseVo<List<GoodsCategory>> getIndexFloorGoodsCategories();

    /***
     * @description: 获取首页分类入口分类
     * @param {type}
     * @return:
     */
    ResponseVo<List<GoodsCategory>> getIndexCategoryGoodsCategories();

    /***
     * @description: 获取所有分类
     * @param {type}
     * @return:
     */
    ResponseVo<List<GoodsCategory>> getGoodsCategories();
}
