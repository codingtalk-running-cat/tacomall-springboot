/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-02 11:01:31
 * @LastEditTime: 2020-11-23 14:56:03
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/store/tacomall/mapper/admin/AdminAuthRouteMapper.java
 * @Just do what I think it is right
 */
package store.tacomall.mapper.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import store.tacomall.entity.admin.AdminAuthRoute;

@Repository
public interface AdminAuthRouteMapper extends BaseMapper<AdminAuthRoute> {

    List<AdminAuthRoute> getRoutesByRoleId(@Param("roleId") int roleId);
}