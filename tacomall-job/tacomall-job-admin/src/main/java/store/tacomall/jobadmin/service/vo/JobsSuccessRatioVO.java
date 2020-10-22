/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-19 17:00:10
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-job/tacomall-job-admin/src/main/java/store/tacomall/jobadmin/service/vo/JobsSuccessRatioVO.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.jobadmin.service.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 成功比例统计 VO
 *
 * @author xxl jobob
 * @since 2019-06-15
 */
@Data
@Accessors(chain = true)
public class JobsSuccessRatioVO {
    /**
     * 成功
     */
    private Integer successful;
    /**
     * 失败
     */
    private Integer failed;

}
