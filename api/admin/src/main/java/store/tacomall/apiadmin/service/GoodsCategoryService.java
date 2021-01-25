/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-18 14:29:16
 * @LastEditTime: 2021-01-18 14:46:13
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/service/GoodsCategoryService.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiadmin.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.alibaba.fastjson.JSONObject;

import store.tacomall.common.entity.goods.GoodsCategory;
import store.tacomall.common.vo.ResponsePageVo;

public interface GoodsCategoryService extends IService<GoodsCategory> {

    ResponsePageVo<List<GoodsCategory>> getGoodsCategoryPage(int pageIndex, int pageSize, JSONObject json);

}
