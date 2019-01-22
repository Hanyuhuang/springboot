package com.hyh.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hyh.component.MyHandlerInterceptor;
import com.hyh.component.MyLocaleResolver;
import com.hyh.dao.EmployeeDao;
import com.hyh.service.EmployeeService;
import com.hyh.service.EmployeeServiceImpl;

@EnableScheduling
@EnableCaching
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer{

	public void addViewControllers(ViewControllerRegistry registry) {
         registry.addViewController("/").setViewName("login");
         registry.addViewController("/main").setViewName("main");
    }
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**")
		.excludePathPatterns("/","/language","/login");
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}
	
	@Bean
	public EmployeeDao employeeDao() {
		return new EmployeeDao();
	}
	
	@Bean
	public EmployeeService employeeService() {
		return new EmployeeServiceImpl();
	}
}
