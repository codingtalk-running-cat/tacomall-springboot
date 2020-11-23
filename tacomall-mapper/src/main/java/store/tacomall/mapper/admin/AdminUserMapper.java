/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 17:37:54
 * @LastEditTime: 2020-11-23 15:39:03
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/admin/AdminUserMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.mapper.admin;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import store.tacomall.entity.admin.AdminUser;

@Repository
public interface AdminUserMapper extends BaseMapper<AdminUser> {

    AdminUser getUser(@Param(Constants.WRAPPER) Wrapper<AdminUser> wrapper);

}
