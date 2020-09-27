/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 17:14:48
 * @LastEditTime: 2020-06-12 17:44:40
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-mapper\src\main\java\cn\codingtalk\tacomallmapper\admin\AdminUserLoginLoggerMapper.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.admin;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.admin.AdminUserLoginLogger;

@Repository
public interface AdminUserLoginLoggerMapper extends BaseMapper<AdminUserLoginLogger>{
    
}