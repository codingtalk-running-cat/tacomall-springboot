/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:40:27
 * @LastEditTime: 2020-07-24 10:22:05
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/service/impl/GoodsServiceImpl.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallentity.goods.Goods;
import cn.codingtalk.tacomallmapper.goods.GoodsMapper;
import cn.codingtalk.tacomallapiportal.service.GoodsService;

@Component
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    /***
     * @description: 获取产品详情
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Goods> getGoods() {
        ResponseVo<Goods> responseVo = new ResponseVo<>();
        Goods goods = this.baseMapper.getGoods(1);
        responseVo.setData(goods);
        return responseVo;
    };
}
