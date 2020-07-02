/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-01 21:21:00
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/cn/codingtalk/tacomallapimerchant/ApiMerchantApplication.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapimerchant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
        "cn.codingtalk.tacomallcommon",
        "cn.codingtalk.tacomallapiadmin"
})
@MapperScan("cn.codingtalk.tacomallmapper")
public class ApiMerchantApplication {
        public static void main(String[] args) {
        SpringApplication.run(ApiMerchantApplication.class, args);
    }

}
