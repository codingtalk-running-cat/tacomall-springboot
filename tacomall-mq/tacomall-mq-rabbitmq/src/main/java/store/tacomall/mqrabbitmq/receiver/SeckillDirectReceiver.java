/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-04 18:26:46
 * @LastEditTime: 2020-11-04 19:21:29
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mq/tacomall-mq-rabbitmq/src/main/java/store/tacomall/mqrabbitmq/receiver/SeckillDirectReceiver.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.mqrabbitmq.receiver;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "SeckillDirectQueue")
public class SeckillDirectReceiver {

    @RabbitHandler
    public void process(Map<String, Object> message) {
        System.out.println("DirectReceiver消费者收到消息  : " + message.toString());
        try {
            Thread.sleep(1000 * 10);
        } catch (Exception e) {

        } finally {
            System.out.println("耗时服务处理完毕！");
        }
    }

}
