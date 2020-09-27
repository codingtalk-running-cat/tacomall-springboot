/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-06-12 21:44:31
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-api\tacomall-api-admin\src\main\java\cn\codingtalk\tacomallapiadmin\ApiAdminApplication.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
        "cn.codingtalk.tacomallcommon",
        "cn.codingtalk.tacomallapiadmin"
})
@MapperScan("cn.codingtalk.tacomallmapper")
public class ApiAdminApplication {
        public static void main(String[] args) {
        SpringApplication.run(ApiAdminApplication.class, args);
    }

}
