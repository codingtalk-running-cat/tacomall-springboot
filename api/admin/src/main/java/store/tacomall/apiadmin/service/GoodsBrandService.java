/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-18 14:29:33
 * @LastEditTime: 2021-01-18 14:46:35
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/service/GoodsBrandService.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiadmin.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.alibaba.fastjson.JSONObject;

import store.tacomall.common.entity.goods.GoodsBrand;
import store.tacomall.common.vo.ResponsePageVo;

public interface GoodsBrandService extends IService<GoodsBrand> {

    ResponsePageVo<List<GoodsBrand>> getGoodsBrandPage(int pageIndex, int pageSize, JSONObject json);

}