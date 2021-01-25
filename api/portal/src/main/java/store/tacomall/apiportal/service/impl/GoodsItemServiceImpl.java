/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-25 15:28:49
 * @LastEditTime: 2020-11-25 15:52:55
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/impl/GoodsItemServiceImpl.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiportal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import cn.hutool.core.util.ObjectUtil;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.entity.goods.GoodsItem;
import store.tacomall.common.mapper.goods.GoodsItemMapper;
import store.tacomall.apiportal.service.GoodsItemService;

@Service
public class GoodsItemServiceImpl extends ServiceImpl<GoodsItemMapper, GoodsItem> implements GoodsItemService {

    /***
     * @description: 获取商品集合
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<GoodsItem> getGoodsItem(JSONObject json) {
        ResponseVo<GoodsItem> responseVo = new ResponseVo<>();
        LambdaQueryWrapper<GoodsItem> q = new QueryWrapper<GoodsItem>().lambda();
        if (ObjectUtil.isNotEmpty(json.getString("id"))) {
            q.eq(GoodsItem::getId, json.getString("id"));
        }
        q.eq(GoodsItem::getIsDelete, 0);
        responseVo.setData(this.baseMapper.selectOne(q));
        return responseVo;
    }

}
