/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:40:12
 * @LastEditTime: 2020-07-23 11:18:46
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/service/impl/GoodsCategoryServiceImpl.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

import cn.codingtalk.tacomallcommon.utils.ListUtil;
import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallentity.goods.GoodsCategory;
import cn.codingtalk.tacomallmapper.goods.GoodsCategoryMapper;
import cn.codingtalk.tacomallapiportal.service.GoodsCategoryService;

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
        if (!ListUtil.isEmpty(children)) {
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
    public ResponseVo<List<GoodsCategory>> getGoodsCategories() {
        ResponseVo<List<GoodsCategory>> responseVo = new ResponseVo<>();
        List<GoodsCategory> roots = new ArrayList<>();
        List<GoodsCategory> subs = new ArrayList<>();
        this.baseMapper.selectList(Wrappers.<GoodsCategory>query().orderByAsc("create_time")).forEach(i -> {
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
