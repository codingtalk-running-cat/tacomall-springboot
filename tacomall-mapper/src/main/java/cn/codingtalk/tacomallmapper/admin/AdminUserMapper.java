/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 17:37:54
 * @LastEditTime: 2020-07-02 14:05:52
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/cn/codingtalk/tacomallmapper/admin/AdminUserMapper.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.admin;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.admin.AdminUser;

@Repository
public interface AdminUserMapper extends BaseMapper<AdminUser>{

    AdminUser getUserInfo(int id);
    
}
