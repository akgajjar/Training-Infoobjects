package com.infoobjects.tms.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Contains Web Application Initialization Configuration
 * @author Aniket
 *
 */
public class MyWebAppInitilizer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Setting Root Level Configuration class or Application Configuration
	 * @return Class<?>[]
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{AppConfig.class};
	}

	/**
	 * Setting Web Configuration class
	 * @return Class<?>[]
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class};
	}

	/**
	 * Setting Servlet Configuration
	 * @return String[]
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
