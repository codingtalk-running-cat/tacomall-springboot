/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-18 15:01:19
 * @LastEditTime: 2021-01-20 14:24:03
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/service/impl/AdminAuthRoleServiceImpl.java
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

import store.tacomall.apiadmin.service.AdminAuthRoleService;
import store.tacomall.common.entity.admin.AdminAuthRole;
import store.tacomall.common.mapper.admin.AdminAuthRoleMapper;
import store.tacomall.common.vo.ResponsePageVo;

@Service
public class AdminAuthRoleServiceImpl extends ServiceImpl<AdminAuthRoleMapper, AdminAuthRole>
        implements AdminAuthRoleService {

    @Autowired
    AdminAuthRoleMapper adminAuthRuleMapper;

    /***
     * @description: 权限分页
     * @param {type}
     * @return:
     */
    @Override
    public ResponsePageVo<List<AdminAuthRole>> getAdminAuthRolePage(int pageIndex, int pageSize, JSONObject json) {
        ResponsePageVo<List<AdminAuthRole>> responsePageVo = new ResponsePageVo<>();
        Page<AdminAuthRole> page = new Page<>(pageIndex, pageSize);
        LambdaQueryWrapper<AdminAuthRole> q = new QueryWrapper<AdminAuthRole>().lambda();
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").get("keyword"))) {
            q.like(AdminAuthRole::getName, json.getJSONObject("query").get("keyword"));
        }
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").getInteger("pId"))) {
            q.eq(AdminAuthRole::getPId, json.getJSONObject("query").getInteger("pId"));
        }
        IPage<AdminAuthRole> result = this.baseMapper.getAdminAuthRolePage(page, q);
        responsePageVo.setData(result.getRecords());
        responsePageVo.buildPage(result.getCurrent(), result.getSize(), result.getTotal());
        return responsePageVo;
    }

}
