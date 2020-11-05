/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-05 08:20:39
 * @LastEditTime: 2020-11-05 08:24:27
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/properties/SeckillProperties.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiportal.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "seckill")
public class SeckillProperties {

    private String mqHost;

    private String mqPort;

}
