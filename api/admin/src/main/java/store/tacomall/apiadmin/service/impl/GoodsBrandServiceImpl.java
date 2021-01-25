/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-18 14:28:45
 * @LastEditTime: 2021-01-18 14:51:16
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/service/impl/GoodsBrandServiceImpl.java
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

import store.tacomall.apiadmin.service.GoodsBrandService;
import store.tacomall.common.entity.goods.GoodsBrand;
import store.tacomall.common.mapper.goods.GoodsBrandMapper;
import store.tacomall.common.vo.ResponsePageVo;

@Service
public class GoodsBrandServiceImpl extends ServiceImpl<GoodsBrandMapper, GoodsBrand> implements GoodsBrandService {

    /***
     * @description: 平台商品品牌分页
     * @param {type}
     * @return:
     */
    @Override
    public ResponsePageVo<List<GoodsBrand>> getGoodsBrandPage(int pageIndex, int pageSize, JSONObject json) {
        ResponsePageVo<List<GoodsBrand>> responsePageVo = new ResponsePageVo<>();
        Page<GoodsBrand> page = new Page<>(pageIndex, pageSize);
        LambdaQueryWrapper<GoodsBrand> q = new QueryWrapper<GoodsBrand>().lambda();
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").get("keyword"))) {
            q.like(GoodsBrand::getName, json.getJSONObject("query").get("keyword"));
        }
        IPage<GoodsBrand> result = this.baseMapper.getGoodsBrandPage(page, q);
        responsePageVo.setData(result.getRecords());
        responsePageVo.buildPage(result.getCurrent(), result.getSize(), result.getTotal());
        return responsePageVo;
    }

}
