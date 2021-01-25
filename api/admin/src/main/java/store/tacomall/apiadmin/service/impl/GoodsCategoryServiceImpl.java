/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-18 14:28:29
 * @LastEditTime: 2021-01-20 14:25:13
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/service/impl/GoodsCategoryServiceImpl.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiadmin.service.impl;

import java.util.List;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.alibaba.fastjson.JSONObject;

import store.tacomall.apiadmin.service.GoodsCategoryService;
import store.tacomall.common.entity.goods.GoodsCategory;
import store.tacomall.common.mapper.goods.GoodsCategoryMapper;
import store.tacomall.common.vo.ResponsePageVo;

@Service
public class GoodsCategoryServiceImpl extends ServiceImpl<GoodsCategoryMapper, GoodsCategory>
        implements GoodsCategoryService {

    /***
     * @description: 平台商品分类分页
     * @param {type}
     * @return:
     */
    @Override
    public ResponsePageVo<List<GoodsCategory>> getGoodsCategoryPage(int pageIndex, int pageSize, JSONObject json) {
        ResponsePageVo<List<GoodsCategory>> responsePageVo = new ResponsePageVo<>();
        Page<GoodsCategory> page = new Page<>(pageIndex, pageSize);
        LambdaQueryWrapper<GoodsCategory> q = new QueryWrapper<GoodsCategory>().lambda();
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").get("keyword"))) {
            q.like(GoodsCategory::getName, json.getJSONObject("query").get("keyword"));
        }
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").getInteger("pId"))) {
            q.eq(GoodsCategory::getPId, json.getJSONObject("query").getInteger("pId"));
        }
        IPage<GoodsCategory> result = this.baseMapper.getGoodsCategoryPage(page, q);
        responsePageVo.setData(result.getRecords());
        responsePageVo.buildPage(result.getCurrent(), result.getSize(), result.getTotal());
        return responsePageVo;
    }

}
