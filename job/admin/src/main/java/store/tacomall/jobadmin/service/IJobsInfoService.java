/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-19 16:58:23
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-job/tacomall-job-admin/src/main/java/store/tacomall/jobadmin/service/IJobsInfoService.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.jobadmin.service;

import com.baomidou.jobs.model.JobsInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 任务信息接口
 *
 * @author jobob
 * @since 2019-07-18
 */
public interface IJobsInfoService {

    R<IPage<JobsInfo>> page(HttpServletRequest request, JobsInfo jobsInfo);

    /**
     * 执行任务总数
     *
     * @return
     */
    int count();

    List<JobsInfo> listNextTime(long nextTime);

    /**
     * 根据 ID 更新任务信息
     *
     * @param jobInfo 任务信息对象
     * @return
     */
    boolean updateById(JobsInfo jobInfo);

    /**
     * 执行、指定 ID 任务
     *
     * @param id    主键 ID
     * @param param 执行参数
     * @return
     */
    boolean execute(Long id, String param);

    /**
     * 启动、指定 ID 任务
     *
     * @param id 主键 ID
     * @return
     */
    boolean start(Long id);

    /**
     * 停止、指定 ID 任务
     *
     * @param id 主键 ID
     * @return
     */
    boolean stop(Long id);

    /**
     * 删除、指定 ID 任务
     *
     * @param id 主键 ID
     * @return
     */
    boolean remove(Long id);

    /**
     * 根据 ID 获取任务信息对象
     *
     * @param id 任务 ID
     * @return
     */
    JobsInfo getById(Long id);
}
