/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-18 15:00:44
 * @LastEditTime: 2021-01-18 16:29:04
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/service/AdminAuthRoleService.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiadmin.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.alibaba.fastjson.JSONObject;

import store.tacomall.common.entity.admin.AdminAuthRole;
import store.tacomall.common.vo.ResponsePageVo;

public interface AdminAuthRoleService extends IService<AdminAuthRole> {

    /***
     * @description: 角色分页
     * @param {type}
     * @return:
     */
    ResponsePageVo<List<AdminAuthRole>> getAdminAuthRolePage(int pageIndex, int pageSize, JSONObject json);

}