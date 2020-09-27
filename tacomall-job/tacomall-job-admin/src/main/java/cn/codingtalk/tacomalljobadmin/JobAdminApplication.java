package cn.codingtalk.tacomalljobadmin;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Job Admin
 *
 * @author jobob
 * @since 2019-05-31
 */
@EnableTransactionManagement
@SpringBootApplication
public class JobAdminApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(JobAdminApplication.class);
		application.setBannerMode(Banner.Mode.CONSOLE);
		application.run(args);
	}
}