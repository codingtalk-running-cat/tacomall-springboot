/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-15 11:12:10
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/ApiPortalApplication.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {
    "cn.codingtalk.tacomallcommon",
    "cn.codingtalk.tacomallapiportal"
})
@MapperScan("cn.codingtalk.tacomallmapper")
@EnableSwagger2
public class ApiPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiPortalApplication.class, args);
    }

}
