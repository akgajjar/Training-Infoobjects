package com.infoobjects.tms.config;

import java.io.IOException;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import static org.hibernate.cfg.Environment.*;
import static com.infoobjects.tms.utils.ConfigurationAndGenericConstants.*;

@Configuration
@PropertySource(value = propertySourcePath)
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan(basePackages = servicePackageName), 
		@ComponentScan(basePackages = daoPackageName) })
public class AppConfig {

	@Autowired
	private Environment env;

	private DriverManagerDataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty(DRIVER));
		dataSource.setUrl(env.getProperty(URL));
		dataSource.setUsername(env.getProperty(USER));
		dataSource.setPassword(env.getProperty(PASS));
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();

		// setting hibernate Properties
		properties.put(SHOW_SQL, env.getProperty(SHOW_SQL));
		properties.put(DIALECT, env.getProperty(DIALECT));
		properties.put(FORMAT_SQL, env.getProperty(FORMAT_SQL));
		properties.put(HBM2DDL_AUTO, env.getProperty(HBM2DDL_AUTO));

		// Setting Pooling Properties
		properties.put(C3P0_MIN_SIZE, env.getProperty(C3P0_MIN_SIZE));
		properties.put(C3P0_MAX_SIZE, env.getProperty(C3P0_MAX_SIZE));
		properties.put(C3P0_ACQUIRE_INCREMENT, env.getProperty(C3P0_ACQUIRE_INCREMENT));
		properties.put(C3P0_TIMEOUT, env.getProperty(C3P0_TIMEOUT));
		properties.put(C3P0_MAX_STATEMENTS, env.getProperty(C3P0_MAX_STATEMENTS));
		return properties;
	}

	@Bean
	public SessionFactory getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		factoryBean.setHibernateProperties(getHibernateProperties());
		factoryBean.setDataSource(getDataSource());
		factoryBean.setPackagesToScan(entityPackageName);

		try {
			factoryBean.afterPropertiesSet();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

		return factoryBean.getObject();
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {

		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(getSessionFactory());
		return hibernateTransactionManager;
	}

	@Bean
	public HibernateTemplate getHibernateTemplate() {
		HibernateTemplate template = new HibernateTemplate();
		template.setSessionFactory(getSessionFactory());
		return template;
	}

	@Bean
	public ViewResolver configureViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix(viewResolverPrefix);
		viewResolver.setSuffix(viewResolverSuffix);
		return viewResolver;
	}

}
