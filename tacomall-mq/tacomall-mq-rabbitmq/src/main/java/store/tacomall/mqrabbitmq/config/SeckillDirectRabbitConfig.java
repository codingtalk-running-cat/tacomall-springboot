/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-04 18:26:46
 * @LastEditTime: 2020-11-04 18:57:06
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mq/tacomall-mq-rabbitmq/src/main/java/store/tacomall/mqrabbitmq/config/SeckillDirectRabbitConfig.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.mqrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeckillDirectRabbitConfig {

    @Bean
    public Queue SeckillDirectQueue() {
        return new Queue("SeckillDirectQueue", true);
    }

    @Bean
    DirectExchange SeckillDirectExchange() {
        return new DirectExchange("SeckillDirectExchange");
    }

    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(SeckillDirectQueue()).to(SeckillDirectExchange()).with("SeckillDirectRouting");
    }
}
