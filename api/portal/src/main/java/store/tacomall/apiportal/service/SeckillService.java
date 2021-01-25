/***
 * @Author: 码上talk|RC
 * @Date: 2020-07-13 14:38:16
 * @LastEditTime: 2020-12-08 10:11:31
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/SeckillService.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.entity.seckill.Seckill;

public interface SeckillService extends IService<Seckill> {
    ResponseVo<Map<String, Object>> info();
}
