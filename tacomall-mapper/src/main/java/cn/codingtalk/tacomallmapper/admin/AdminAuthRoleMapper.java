/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-02 11:00:15
 * @LastEditTime: 2020-07-02 11:53:12
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/cn/codingtalk/tacomallmapper/admin/adminAuthRoleMapper.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.admin;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.admin.AdminAuthRole;

@Repository
public interface AdminAuthRoleMapper extends BaseMapper<AdminAuthRole> {
    @Select("SELECT * FROM admin_auth_role WHERE id = #{id}")
    AdminAuthRole getAuthRole(int id);
}

