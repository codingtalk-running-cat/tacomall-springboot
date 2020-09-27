/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:36:37
 * @LastEditTime: 2020-07-23 11:18:21
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/service/GoodsCategoryService.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallentity.goods.GoodsCategory;

public interface GoodsCategoryService extends IService<GoodsCategory> {
    /***
     * @description: 获取所有分类
     * @param {type}
     * @return:
     */
    ResponseVo<List<GoodsCategory>> getGoodsCategories();
}
