/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-04 18:26:46
 * @LastEditTime: 2020-11-05 09:46:33
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mq/tacomall-mq-rabbitmq/src/main/java/store/tacomall/mqrabbitmq/controller/SeckillController.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.mqrabbitmq.controller;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq/seckill")
public class SeckillController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("/buy")
    public Map<String, Object> buy(@RequestParam(value = "token") String token, @RequestBody JSONObject json) {
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("json", json);
        rabbitTemplate.convertAndSend("SeckillDirectExchange", "SeckillDirectRouting", map);
        return new HashMap<>();
    }

}
