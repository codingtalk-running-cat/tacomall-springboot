/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-02 11:01:31
 * @LastEditTime: 2020-07-02 11:23:46
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/cn/codingtalk/tacomallmapper/admin/AdminAuthRuleMapper.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.admin;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.admin.AdminAuthRule;

@Repository
public interface AdminAuthRuleMapper extends BaseMapper<AdminAuthRule> {

    List<AdminAuthRule> getAuthRuleByRoleId(int id);
}