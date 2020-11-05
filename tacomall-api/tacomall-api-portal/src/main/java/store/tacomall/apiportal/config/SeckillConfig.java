/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-05 09:01:47
 * @LastEditTime: 2020-11-05 09:03:52
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/config/SeckillConfig.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import store.tacomall.apiportal.properties.SeckillProperties;

@Configuration
@EnableConfigurationProperties(SeckillProperties.class)
public class SeckillConfig {

    public static String mqHost;

    public static String mqPort;

    @Autowired
    public SeckillConfig(SeckillProperties properties) {
        mqHost = properties.getMqHost();
        mqPort = properties.getMqPort();
    }
}
