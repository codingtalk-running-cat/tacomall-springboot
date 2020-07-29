/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:32:41
 * @LastEditTime: 2020-07-16 17:06:18
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/service/GoodsService.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallentity.goods.Goods;

public interface GoodsService extends IService<Goods>{
    /***
     * @description: 获取产品详情
     * @param {type}
     * @return:
     */
    ResponseVo<Goods> getGoods();
}
