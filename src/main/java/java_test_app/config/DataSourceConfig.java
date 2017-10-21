package java_test_app.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {
	@Bean
	@Primary
	@ConfigurationProperties(prefix="datasource.test")
	public DataSource shortUrlDataSource() {
		return DataSourceBuilder.create().build();
	}
}
