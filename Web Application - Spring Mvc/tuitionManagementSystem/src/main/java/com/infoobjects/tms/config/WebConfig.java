package com.infoobjects.tms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Contains Web Application Level Configuration
 * @author Aniket
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.infoobjects.tms.controller"})
public class WebConfig extends WebMvcConfigurerAdapter{

	/**
	 * Setting up Resource Location 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
}
