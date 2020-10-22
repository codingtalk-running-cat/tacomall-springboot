/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-19 16:26:42
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-admin/src/main/java/store/tacomall/apiadmin/ApiAdminApplication.java
 * @Just do what I think it is right
 */
package store.tacomall.apiadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(scanBasePackages = { "store.tacomall.common", "store.tacomall.apiadmin" })
@MapperScan("store.tacomall.mapper")
public class ApiAdminApplication {
        public static void main(String[] args) {
                SpringApplication.run(ApiAdminApplication.class, args);
        }

}
