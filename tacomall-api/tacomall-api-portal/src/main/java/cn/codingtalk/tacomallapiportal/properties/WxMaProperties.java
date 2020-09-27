/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-11 20:45:33
 * @LastEditTime: 2020-06-12 20:22:46
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-api\tacomall-api-portal\src\main\java\cn\codingtalk\tacomallapiportal\properties\WxMaProperties.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.properties;

import java.util.List;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "wx.miniapp")
public class WxMaProperties {

    private List<Config> configs;

    @Data
    public static class Config {

        private String appid;


        private String secret;


        private String token;


        private String aesKey;


        private String msgDataFormat;
    }

}
