package com.infoobjects.tms.config;

import java.io.IOException;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;
import static org.hibernate.cfg.Environment.*;
import static com.infoobjects.tms.utils.ConfigurationAndGenericConstants.*;

/**
 * 
 * @author Aniket
 * Appplication Configuration CLass. It Contains Application Level Configuration and beans Configuration. 
 */
@org.springframework.context.annotation.Configuration
@PropertySource(value = propertySourcePath)
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan(basePackages = servicePackageName), 
		@ComponentScan(basePackages = daoPackageName) })
public class AppConfig {

	// Environment Variable 
	@Autowired
	private Environment environment;

	/**
	 * Used to get Data Source Object
	 * @return DriverManagerDataSource
	 */
	private DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty(DRIVER));
		dataSource.setUrl(environment.getProperty(URL));
		dataSource.setUsername(environment.getProperty(USER));
		dataSource.setPassword(environment.getProperty(PASS));
		return dataSource;
	}

	/**
	 * Used to get Hibernate Properties Configuration.
	 * @return Properties
	 */
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
				
		// setting hibernate Properties
		properties.put(SHOW_SQL, environment.getProperty(SHOW_SQL));
		properties.put(DIALECT, environment.getProperty(DIALECT));
		properties.put(FORMAT_SQL, environment.getProperty(FORMAT_SQL));
		properties.put(HBM2DDL_AUTO, environment.getProperty(HBM2DDL_AUTO));

		// Setting Pooling Properties
		properties.put(C3P0_MIN_SIZE, environment.getProperty(C3P0_MIN_SIZE));
		properties.put(C3P0_MAX_SIZE, environment.getProperty(C3P0_MAX_SIZE));
		properties.put(C3P0_ACQUIRE_INCREMENT, environment.getProperty(C3P0_ACQUIRE_INCREMENT));
		properties.put(C3P0_TIMEOUT, environment.getProperty(C3P0_TIMEOUT));
		properties.put(C3P0_MAX_STATEMENTS, environment.getProperty(C3P0_MAX_STATEMENTS));
		
		return properties;
	}

	/**
	 * Used to get Session Factory Object
	 * @return SessionFactory
	 */
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

	/**
	 * Used to Get Transaction Manager Object 
	 * @return HibernateTransactionManager
	 */
	@Bean
	public HibernateTransactionManager getTransactionManager() {

		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(getSessionFactory());
		return hibernateTransactionManager;
	}

	/**
	 * Used to get Hibernate Template Object
	 * @return HibernateTemplate
	 */
	@Bean
	public HibernateTemplate getHibernateTemplate() {
		HibernateTemplate template = new HibernateTemplate();
		template.setSessionFactory(getSessionFactory());
		return template;
	}

}
