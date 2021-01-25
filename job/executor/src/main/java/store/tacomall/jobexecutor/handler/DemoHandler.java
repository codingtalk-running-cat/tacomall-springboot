/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-12-08 15:36:13
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-job/tacomall-job-executor/src/main/java/store/tacomall/jobexecutor/handler/DemoHandler.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.jobexecutor.handler;

import com.baomidou.jobs.api.JobsResponse;
import com.baomidou.jobs.exception.JobsException;
import com.baomidou.jobs.handler.IJobsHandler;
import org.springframework.stereotype.Component;

/**
 * 处理器 SeckillSku2Redis
 *
 * @author jobob
 * @since 2019-07-16
 */
@Component
public class DemoHandler implements IJobsHandler {

    @Override
    public JobsResponse execute(String tenantId, String param) throws JobsException {

        return JobsResponse.ok();
    }
}
