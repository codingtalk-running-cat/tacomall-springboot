/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 17:37:54
 * @LastEditTime: 2021-01-20 14:23:16
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/mapper/admin/AdminUserMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.common.mapper.admin;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.apache.ibatis.annotations.Select;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import store.tacomall.common.entity.admin.AdminUser;

@Repository
public interface AdminUserMapper extends BaseMapper<AdminUser> {

    AdminUser getUser(@Param(Constants.WRAPPER) Wrapper<AdminUser> wrapper);

    @Select("SELECT * FROM admin_user ${ew.customSqlSegment}")
    IPage<AdminUser> getAdminUserPage(@Param("page") Page<?> page,
            @Param(Constants.WRAPPER) Wrapper<AdminUser> wrapper);

}
