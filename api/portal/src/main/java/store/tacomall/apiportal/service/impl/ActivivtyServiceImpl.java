/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:39:23
 * @LastEditTime: ,: 2020-10-21 19:58:32
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/impl/ActivivtyServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.entity.activity.Activity;
import store.tacomall.common.mapper.activity.ActivityMapper;
import store.tacomall.apiportal.service.ActivityService;

@Component
public class ActivivtyServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {

    /***
     * @description: 获取活动分页
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<List<Activity>> getActivityPage() {
        ResponseVo<List<Activity>> responseVo = new ResponseVo<>();
        Page<Activity> page = new Page<>(1, 3);
        IPage<Activity> result = this.baseMapper.getActivityPage(page);
        responseVo.setData(result.getRecords());
        return responseVo;
    };
}
