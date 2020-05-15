package com.demo.bookapi.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScans (value = {
		@ComponentScan("com.demo.bookapi.daoimpl"),
		@ComponentScan("com.demo.bookapi.serviceimpl")
})
public class AppConfig {

	@Autowired
	private Environment env;
	
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean= new LocalSessionFactoryBean();
		Properties properties = new Properties();
		
		// setting JDBC Properties
		properties.put(DRIVER, env.getProperty("database.driver"));
		properties.put(USER, env.getProperty("database.user"));
		properties.put(URL, env.getProperty("database.url"));
		properties.put(PASS, env.getProperty("database.password"));
		
		//setting hibernate Properties
		properties.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
		properties.put(DIALECT, env.getProperty("hibernate.dialect"));
		properties.put(FORMAT_SQL, env.getProperty("hibernate.format_sql"));
		properties.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		
		// Setting Pooling Properties
		properties.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
		properties.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
		properties.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
		properties.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
		properties.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statemets"));
		
		factoryBean.setHibernateProperties(properties);
		factoryBean.setPackagesToScan("com.demo.bookapi.model");
		
		return factoryBean;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {

		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(getSessionFactory().getObject());
		return hibernateTransactionManager;
	}
		
}
