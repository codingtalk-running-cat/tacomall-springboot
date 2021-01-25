/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-02 11:01:31
 * @LastEditTime: 2021-01-18 16:26:01
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/mapper/admin/AdminAuthRuleMapper.java
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

import store.tacomall.common.entity.admin.AdminAuthRule;

@Repository
public interface AdminAuthRuleMapper extends BaseMapper<AdminAuthRule> {

    @Select("SELECT * FROM admin_auth_rule ${ew.customSqlSegment}")
    IPage<AdminAuthRule> getAdminAuthRulePage(@Param("page") Page<?> page,
            @Param(Constants.WRAPPER) Wrapper<AdminAuthRule> wrapper);
}