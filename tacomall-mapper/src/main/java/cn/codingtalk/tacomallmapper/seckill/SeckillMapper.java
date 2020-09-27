/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 15:06:30
 * @LastEditTime: 2020-07-13 15:06:57
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mapper/src/main/java/cn/codingtalk/tacomallmapper/seckill/SeckillMapper.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.seckill;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.seckill.Seckill;

@Repository
public interface SeckillMapper extends BaseMapper<Seckill>{
    
}