package store.tacomall.jobadmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.tacomall.jobadmin.service.IJobsInfoService;
import store.tacomall.jobadmin.service.IJobsLogService;
import store.tacomall.jobadmin.service.IJobsRegistryService;
import store.tacomall.jobadmin.service.IJobsStatisticsService;
import store.tacomall.jobadmin.service.vo.JobsDateDistributionVO;
import store.tacomall.jobadmin.service.vo.JobsImportantNumVO;
import store.tacomall.jobadmin.service.vo.JobsSuccessRatioVO;

import java.util.List;

@Service
public class JobsStatisticsServiceImpl implements IJobsStatisticsService {
    @Autowired
    private IJobsInfoService jobsInfoService;
    @Autowired
    private IJobsLogService jobsLogService;
    @Autowired
    private IJobsRegistryService jobsRegistryService;

    @Override
    public JobsImportantNumVO getImportantNum() {
        JobsImportantNumVO vo = new JobsImportantNumVO();
        vo.setRunTaskNum(jobsRegistryService.countAll());
        vo.setTriggeredNum(jobsLogService.countAll());
        vo.setOnlineExecutorNum(jobsRegistryService.countOnline());
        return vo;
    }

    @Override
    public JobsSuccessRatioVO getSuccessRatio() {
        JobsSuccessRatioVO vo = new JobsSuccessRatioVO();
        vo.setSuccessful(jobsLogService.countSuccess());
        vo.setFailed(jobsLogService.countAll() - vo.getSuccessful());
        return vo;
    }

    @Override
    public List<JobsDateDistributionVO> getDateDistribution() {
        return jobsLogService.getJobsDateDistributionVO();
    }
}
