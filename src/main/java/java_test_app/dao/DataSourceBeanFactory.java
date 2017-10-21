package java_test_app.dao;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class DataSourceBeanFactory {
	@Autowired
	@Qualifier("shortUrlDataSource")
	private DataSource ds;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Bean(destroyMethod = "clearCache")
	public SqlSessionTemplate javaTestAppSessionTemplate() {
		try {
			Resource[] resources = new Resource[] {
					new ClassPathResource("sql/shortUrlInfo.xml"),
				};

			SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
			sqlSessionFactory.setDataSource(ds);
			sqlSessionFactory.setMapperLocations(resources);

			return new SqlSessionTemplate(sqlSessionFactory.getObject());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return null;
	}
	/*
	@Bean
	public IShortUrlInfoDao shortUrlInfoDao() {
		SqlSessionTemplate sessionTemplate = javaTestAppSessionTemplate();
		return sessionTemplate.getMapper(IShortUrlInfoDao.class);
	}
	*/
}
