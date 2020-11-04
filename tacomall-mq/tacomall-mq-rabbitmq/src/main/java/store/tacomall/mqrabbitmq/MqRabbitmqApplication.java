/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-04 18:26:46
 * @LastEditTime: 2020-11-04 18:42:20
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-mq/tacomall-mq-rabbitmq/src/main/java/store/tacomall/mqrabbitmq/MqApplication.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.mqrabbitmq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "store.tacomall.common",
        "store.tacomall.mqrabbitmq"
})
@MapperScan("store.tacomall.mapper")
public class MqRabbitmqApplication {
    public static void main(String[] args) {
        SpringApplication.run(MqRabbitmqApplication.class, args);
    }
}

