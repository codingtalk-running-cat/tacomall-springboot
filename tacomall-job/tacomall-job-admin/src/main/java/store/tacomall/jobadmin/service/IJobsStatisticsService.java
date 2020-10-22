/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-19 17:00:25
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-job/tacomall-job-admin/src/main/java/store/tacomall/jobadmin/service/IJobsStatisticsService.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.jobadmin.service;

import java.util.List;

import store.tacomall.jobadmin.service.vo.JobsDateDistributionVO;
import store.tacomall.jobadmin.service.vo.JobsImportantNumVO;
import store.tacomall.jobadmin.service.vo.JobsSuccessRatioVO;

/**
 * 统计接口
 */
public interface IJobsStatisticsService {

    /**
     * 重要数量统计
     */
    JobsImportantNumVO getImportantNum();

    /**
     * 成功比例统计
     */
    JobsSuccessRatioVO getSuccessRatio();

    /**
     * 日期分布统计
     */
    List<JobsDateDistributionVO> getDateDistribution();

}
