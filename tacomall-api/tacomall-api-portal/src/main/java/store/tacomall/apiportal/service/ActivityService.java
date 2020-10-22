/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:37:03
 * @LastEditTime: ,: 2020-10-21 19:58:38
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/ActivityService.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.entity.activity.Activity;

public interface ActivityService extends IService<Activity> {

    /***
     * @description: 获取活动分页
     * @param {type}
     * @return:
     */
    ResponseVo<List<Activity>> getActivityPage();
}