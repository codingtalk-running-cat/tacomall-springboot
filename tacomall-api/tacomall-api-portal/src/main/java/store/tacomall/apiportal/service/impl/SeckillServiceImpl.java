/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:40:58
 * @LastEditTime: 2020-11-03 14:51:02
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/impl/SeckillServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.entity.seckill.Seckill;
import store.tacomall.entity.seckill.SeckillGoodsItemApply;
import store.tacomall.mapper.seckill.SeckillMapper;
import store.tacomall.mapper.seckill.SeckillGoodsItemApplyMapper;
import store.tacomall.apiportal.service.SeckillService;

@Service
public class SeckillServiceImpl extends ServiceImpl<SeckillMapper, Seckill> implements SeckillService {

    @Autowired
    private SeckillGoodsItemApplyMapper seckillGoodsItemApplyMapper;

    @Override
    public ResponseVo<Map<String, Object>> info() {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        List<SeckillGoodsItemApply> list = new ArrayList<>();
        Date date = DateUtil.date();
        Seckill seckill = this.baseMapper.selectOne(
                new QueryWrapper<Seckill>().lambda().le(Seckill::getStartTime, date).ge(Seckill::getEndTime, date));
        if (!ObjectUtil.isEmpty(seckill)) {
            list = seckillGoodsItemApplyMapper.getSeckillGoodsItemApplys(new QueryWrapper<SeckillGoodsItemApply>()
                    .lambda().eq(SeckillGoodsItemApply::getSeckillId, seckill.getId()));
        }
        map.put("queryTime", date);
        map.put("startTime", seckill.getStartTime());
        map.put("endTime", seckill.getEndTime());
        map.put("list", list);
        responseVo.setData(map);
        return responseVo;
    }

    @Override
    public ResponseVo<Map<String, Object>> buy() {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        return responseVo;
    }
}