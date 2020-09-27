package cn.codingtalk.tacomallapiopen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
        "cn.codingtalk.tacomallcommon",
        "cn.codingtalk.tacomallapiopen"
})
@MapperScan("cn.codingtalk.tacomallmapper")
public class ApiOpenApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiOpenApplication.class, args);
    }
}
