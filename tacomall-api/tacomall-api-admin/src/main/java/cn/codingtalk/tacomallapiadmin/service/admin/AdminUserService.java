/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-02 10:40:48
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

    ResponseVo<String> login(String username, String password);

    ResponseVo<String> logout();

    ResponseVo<AdminUser> info();
}
