package com.infoobjects.tms.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitilizer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	/*
	 * public void onStartup(ServletContext container) {
	 * container.addListener("org.springframework.web.context.ContextLoaderListener"
	 * ); ServletRegistration.Dynamic registration =
	 * container.addServlet("dispatcher", new DispatcherServlet());
	 * registration.setLoadOnStartup(1); }
	 */
}
