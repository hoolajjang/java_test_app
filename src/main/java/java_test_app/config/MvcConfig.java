package java_test_app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java_test_app.controller.filter.UrlFilter;
import java_test_app.dao.IShortUrlInfoDao;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	@Autowired
	private IShortUrlInfoDao shortUrlData;
	
	@Bean
	public FilterRegistrationBean filterRegistration() {
	
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(urlFilter());
		registration.addUrlPatterns("/*");
		registration.setOrder(0);
		registration.setName("urlFilter");
		
		return registration;
	}
	
	@Bean
	public UrlFilter urlFilter() {
		return new UrlFilter(shortUrlData);
	}
}
