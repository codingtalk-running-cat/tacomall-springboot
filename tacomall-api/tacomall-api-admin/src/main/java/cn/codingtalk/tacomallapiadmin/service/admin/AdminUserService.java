/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-10 15:56:45
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-admin/src/main/java/cn/codingtalk/tacomallapiadmin/service/admin/AdminUserService.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiadmin.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.codingtalk.tacomallentity.admin.AdminUser;
import cn.codingtalk.tacomallcommon.vo.ResponseVo;

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
}
