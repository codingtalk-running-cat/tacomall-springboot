/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:40:12
 * @LastEditTime: ,: 2020-10-21 19:33:14
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/impl/GoodsCategoryServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import cn.hutool.core.util.ArrayUtil;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.entity.goods.GoodsCategory;
import store.tacomall.common.mapper.goods.GoodsCategoryMapper;
import store.tacomall.apiportal.service.GoodsCategoryService;

@Component
public class GoodsCategoryServiceImpl extends ServiceImpl<GoodsCategoryMapper, GoodsCategory>
        implements GoodsCategoryService {
    /***
     * @description: 获取商品分类树
     * @param {type}
     * @return:
     */
    private void buildSubs(GoodsCategory root, List<GoodsCategory> subs) {
        List<GoodsCategory> children = subs.stream().filter(sub -> (sub.getPId() == root.getId()))
                .collect(Collectors.toList());
        if (!ArrayUtil.isEmpty(children)) {
            root.setChildren(children);
            children.forEach(child -> buildSubs(child, subs));
        }
    }

    /***
     * @description: 获取所有商品分类
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<List<GoodsCategory>> getIndexFloorGoodsCategories() {
        ResponseVo<List<GoodsCategory>> responseVo = new ResponseVo<>();
        responseVo.setData(this.baseMapper.selectList(new QueryWrapper<GoodsCategory>().lambda()
                .eq(GoodsCategory::getIsIndexFloor, 1).orderByAsc(GoodsCategory::getCreateTime)));
        return responseVo;
    };

    /***
     * @description: 获取所有商品分类
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<List<GoodsCategory>> getIndexCategoryGoodsCategories() {
        ResponseVo<List<GoodsCategory>> responseVo = new ResponseVo<>();
        responseVo.setData(this.baseMapper.selectList(new QueryWrapper<GoodsCategory>().lambda()
                .eq(GoodsCategory::getIsIndexCategory, 1).orderByAsc(GoodsCategory::getCreateTime)));
        return responseVo;
    };

    /***
     * @description: 获取所有商品分类
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<List<GoodsCategory>> getGoodsCategories() {
        ResponseVo<List<GoodsCategory>> responseVo = new ResponseVo<>();
        List<GoodsCategory> roots = new ArrayList<>();
        List<GoodsCategory> subs = new ArrayList<>();
        this.baseMapper.selectList(new QueryWrapper<GoodsCategory>().lambda().orderByAsc(GoodsCategory::getCreateTime))
                .forEach(i -> {
                    if (i.getPId() == 0) {
                        roots.add(i);
                        return;
                    }
                    subs.add(i);
                });
        roots.forEach(i -> {
            this.buildSubs(i, subs);
        });
        responseVo.setData(roots);
        return responseVo;
    };
}
