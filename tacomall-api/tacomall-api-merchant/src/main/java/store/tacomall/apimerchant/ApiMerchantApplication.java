/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-19 15:54:24
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/store/tacomall/apimerchant/ApiMerchantApplication.java
 * @Just do what I think it is right
 */
package store.tacomall.apimerchant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = { "store.tacomall.common", "store.tacomall.apimerchant" })
@MapperScan("store.tacomall.mapper")
@EnableSwagger2
public class ApiMerchantApplication {
        public static void main(String[] args) {
                SpringApplication.run(ApiMerchantApplication.class, args);
        }

}
