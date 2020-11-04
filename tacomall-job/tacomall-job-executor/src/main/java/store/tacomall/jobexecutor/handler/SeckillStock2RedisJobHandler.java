/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-11-04 15:31:06
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-job/tacomall-job-executor/src/main/java/store/tacomall/jobexecutor/handler/SeckillStock2RedisJobHandler.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.jobexecutor.handler;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;

import com.baomidou.jobs.api.JobsResponse;
import com.baomidou.jobs.exception.JobsException;
import com.baomidou.jobs.handler.IJobsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import store.tacomall.common.util.StringUtil;
import store.tacomall.entity.seckill.Seckill;
import store.tacomall.entity.seckill.SeckillGoodsItemApply;
import store.tacomall.mapper.seckill.SeckillMapper;
import store.tacomall.mapper.seckill.SeckillGoodsItemApplyMapper;
import store.tacomall.jobexecutor.utils.RedisUtil;

/**
 * 处理器 SeckillSku2Redis
 *
 * @author jobob
 * @since 2019-07-16
 */
@Component
public class SeckillStock2RedisJobHandler implements IJobsHandler {

    @Autowired
    private SeckillMapper seckillMapper;

    @Autowired
    private SeckillGoodsItemApplyMapper seckillGoodsItemApplyMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public JobsResponse execute(String tenantId, String param) throws JobsException {
        Date date = DateUtil.date();
        Page<Seckill> page = new Page<>(1, 2);
        String redisPreFix = "seckill:stock:";
        redisUtil.select(redisPreFix + "*").forEach((key, value) -> {
            if (date.getTime() > Long.parseLong(Arrays.asList(value.split("/")).get(0))) {
                redisUtil.delete(key);
            }
        });
        IPage<Seckill> result = seckillMapper.selectPage(page,
                new QueryWrapper<Seckill>().lambda().ge(Seckill::getEndTime, date));
        if (!ArrayUtil.isEmpty(result.getRecords())) {
            for (int i = 0; i < result.getRecords().size(); i++) {
                Seckill seckill = result.getRecords().get(i);
                seckillGoodsItemApplyMapper
                        .getSeckillGoodsItemApplys(new QueryWrapper<SeckillGoodsItemApply>().lambda()
                                .ge(SeckillGoodsItemApply::getSeckillId, seckill.getId()))
                        .forEach((SeckillGoodsItemApply seckillGoodsItemApply) -> {
                            String redisKey = redisPreFix + seckillGoodsItemApply.getGoodsItem().getId();
                            String redisValue = seckill.getEndTime().getTime() + "/"
                                    + seckillGoodsItemApply.getTotalCount();
                            if (!StringUtil.isEmpty(redisUtil.get(redisKey))) {
                                return;
                            }
                            redisUtil.set(redisKey, redisValue);
                        });
            }
        }
        return JobsResponse.ok();
    }
}
