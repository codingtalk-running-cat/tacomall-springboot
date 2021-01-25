/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-18 15:01:39
 * @LastEditTime: 2021-01-20 14:24:39
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/service/impl/AdminAuthRuleServiceImpl.java
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
import org.springframework.beans.factory.annotation.Autowired;

import store.tacomall.apiadmin.service.AdminAuthRuleService;
import store.tacomall.common.entity.admin.AdminAuthRule;
import store.tacomall.common.mapper.admin.AdminAuthRuleMapper;
import store.tacomall.common.vo.ResponsePageVo;

@Service
public class AdminAuthRuleServiceImpl extends ServiceImpl<AdminAuthRuleMapper, AdminAuthRule>
        implements AdminAuthRuleService {

    @Autowired
    AdminAuthRuleMapper adminAuthRuleMapper;

    /***
     * @description: 权限分页
     * @param {type}
     * @return:
     */
    @Override
    public ResponsePageVo<List<AdminAuthRule>> getAdminAuthRulePage(int pageIndex, int pageSize, JSONObject json) {
        ResponsePageVo<List<AdminAuthRule>> responsePageVo = new ResponsePageVo<>();
        Page<AdminAuthRule> page = new Page<>(pageIndex, pageSize);
        LambdaQueryWrapper<AdminAuthRule> q = new QueryWrapper<AdminAuthRule>().lambda();
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").get("keyword"))) {
            q.like(AdminAuthRule::getName, json.getJSONObject("query").get("keyword"));
        }
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").getInteger("pId"))) {
            q.eq(AdminAuthRule::getPId, json.getJSONObject("query").getInteger("pId"));
        }
        IPage<AdminAuthRule> result = this.baseMapper.getAdminAuthRulePage(page, q);
        responsePageVo.setData(result.getRecords());
        responsePageVo.buildPage(result.getCurrent(), result.getSize(), result.getTotal());
        return responsePageVo;
    }

}
