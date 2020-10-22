/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-02 11:00:15
 * @LastEditTime: 2020-07-02 11:53:12
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/admin/adminAuthRoleMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.mapper.admin;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import store.tacomall.entity.admin.AdminAuthRole;

@Repository
public interface AdminAuthRoleMapper extends BaseMapper<AdminAuthRole> {
    @Select("SELECT * FROM admin_auth_role WHERE id = #{id}")
    AdminAuthRole getAuthRole(int id);
}
