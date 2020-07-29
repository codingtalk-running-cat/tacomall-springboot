/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:37:03
 * @LastEditTime: 2020-07-15 11:24:42
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/service/ActivityService.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallentity.activity.Activity;

public interface ActivityService extends IService<Activity> {

    /***
     * @description: 获取活动分页
     * @param {type}
     * @return:
     */
    ResponseVo<List<Activity>> getPageActivity();
}