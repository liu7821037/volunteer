package com.bjb;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.bjb.util.MessageSettings;
import com.oss.OSSConfigure;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.bjb")
@MapperScan({"com.bjb.dao"})
@EnableConfigurationProperties({OSSConfigure.class}) 
public class Application {
	private static Logger logger = Logger.getLogger(Application.class);

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new org.apache.tomcat.jdbc.pool.DataSource();
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setTypeAliasesPackage("com.bjb.entity");
		sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis.xml"));
		sqlSessionFactoryBean.setMapperLocations(resolver
				.getResources("classpath:com/bjb/mapping/*.xml"));

		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
		System.out
				.println("================= message.properties =================");
		System.out.println(MessageSettings.getValue("MSG_INFO_001"));
	}

}
