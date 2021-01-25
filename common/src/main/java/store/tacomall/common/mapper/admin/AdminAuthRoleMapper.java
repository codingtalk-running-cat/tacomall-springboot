/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-02 11:00:15
 * @LastEditTime: 2021-01-20 14:23:07
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/mapper/admin/AdminAuthRoleMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.common.mapper.admin;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import store.tacomall.common.entity.admin.AdminAuthRole;

@Repository
public interface AdminAuthRoleMapper extends BaseMapper<AdminAuthRole> {

    @Select("SELECT * FROM admin_auth_role ${ew.customSqlSegment}")
    IPage<AdminAuthRole> getAdminAuthRolePage(@Param("page") Page<?> page,
            @Param(Constants.WRAPPER) Wrapper<AdminAuthRole> wrapper);

}
