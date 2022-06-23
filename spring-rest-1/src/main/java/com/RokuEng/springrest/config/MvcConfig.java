package com.RokuEng.springrest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
@EnableWebMvc
@ComponentScan("com.RokuEng.springrest")
public class MvcConfig implements WebMvcConfigurer {

	@Configuration
	public static class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
		@Override
		protected Class<?>[] getRootConfigClasses() {
			return new Class[] {
				JpaConfig.class,
				MvcConfig.class
			};
		}

		@Override
		protected Class<?>[] getServletConfigClasses() {
			return new Class[] {
				MvcConfig.class
			};
		}

		@Override
		protected String[] getServletMappings() {
			return new String[] {
				"/"
			};
		}
	}
}
