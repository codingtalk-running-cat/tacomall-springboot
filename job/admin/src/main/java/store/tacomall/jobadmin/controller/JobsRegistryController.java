/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-19 16:58:49
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-job/tacomall-job-admin/src/main/java/store/tacomall/jobadmin/controller/JobsRegistryController.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.jobadmin.controller;

import com.baomidou.jobs.model.JobsRegistry;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import store.tacomall.jobadmin.service.IJobsRegistryService;

/**
 * 用户信息
 *
 * @author jobob
 * @since 2019-05-31
 */
@RestController
@RequestMapping("/v1/jobs-registry")
public class JobsRegistryController extends BaseController {
    @Autowired
    private IJobsRegistryService jobRegistryService;

    /**
     * 分页
     */
    @GetMapping("/page")
    public R<Object> page(JobsRegistry jobRegistry) {
        return success(null);// jobRegistryService.page(request, jobRegistry));
    }
}
