/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-15 10:03:33
 * @LastEditTime: 2020-07-24 11:14:12
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/cn/codingtalk/tacomallmapper/activity/ActivityMapper.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.activity;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.codingtalk.tacomallentity.activity.Activity;

@Repository
public interface ActivityMapper extends BaseMapper<Activity> {

    @Select("SELECT * FROM activity")
    IPage<Activity> getActivityPage(Page<?> page);

}