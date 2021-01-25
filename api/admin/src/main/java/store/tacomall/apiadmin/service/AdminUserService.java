/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2021-01-18 16:30:32
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/service/AdminUserService.java
 * @Just do what I think it is right
 */
package store.tacomall.apiadmin.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.alibaba.fastjson.JSONObject;

import store.tacomall.common.entity.admin.AdminAuthRule;
import store.tacomall.common.entity.admin.AdminUser;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.vo.ResponsePageVo;

public interface AdminUserService extends IService<AdminUser> {

    /***
     * @description: 用户登录
     * @param {type}
     * @return:
     */
    ResponseVo<String> login(String username, String password);

    /***
     * @description: 用户注销
     * @param {type}
     * @return:
     */
    ResponseVo<String> logout();

    /***
     * @description: 用户信息
     * @param {type}
     * @return:
     */
    ResponseVo<AdminUser> info();

    /***
     * @description: 用户权限
     * @param {type}
     * @return:
     */
    ResponseVo<List<AdminAuthRule>> rules();

    /***
     * @description: 用户列表
     * @param {type}
     * @return:
     */
    ResponsePageVo<List<AdminUser>> getAdminUserPage(int pageIndex, int pageSize, JSONObject json);
}
