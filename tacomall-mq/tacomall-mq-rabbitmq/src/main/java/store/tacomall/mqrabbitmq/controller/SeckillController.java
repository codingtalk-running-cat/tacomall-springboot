/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-04 18:26:46
 * @LastEditTime: 2020-11-04 19:25:11
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

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq/seckill")
public class SeckillController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("/buy")
    public String buy(@RequestParam(value = "goodsItemId") int goodsItemId,
            @RequestParam(value = "memberId") int memberId) {
        Map<String, Object> map = new HashMap<>();
        map.put("goodsItemId", goodsItemId);
        map.put("memberId", memberId);
        rabbitTemplate.convertAndSend("SeckillDirectExchange", "SeckillDirectRouting", map);
        return "ok";
    }

}
