package java_test_app;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.ComponentScan;

import java_test_app.controller.filter.UrlFilter;

//@Configuration
@ComponentScan(basePackages = {"java_test_app"})
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@SpringBootApplication
public class JavaTestApplication implements ServletContextInitializer {
	public void run(String[] args) throws Exception {
		SpringApplication.run(JavaTestApplication.class, args);
	}

	public static void main(String[] args) throws Exception {
		new JavaTestApplication().run(args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//servletContext.addFilter("urlFilter", UrlFilter.class).addMappingForUrlPatterns(null, false, "/*");
	}
}
