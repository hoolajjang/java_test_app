package java_test_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"java_test_app"})
@EnableAutoConfiguration // (exclude={DataSourceAutoConfiguration.class})
public class JavaTestApplication {
	public void run(String[] args) throws Exception {
		SpringApplication.run(JavaTestApplication.class, args);
	}

	public static void main(String[] args) throws Exception {
		new JavaTestApplication().run(args);
	}
}
