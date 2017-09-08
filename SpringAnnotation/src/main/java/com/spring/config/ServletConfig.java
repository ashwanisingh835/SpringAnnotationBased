package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.spring.controller")
@Import({ SecurityConfig.class })
public class ServletConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver urlBasedViewResolver(){
		InternalResourceViewResolver urlResolver=new InternalResourceViewResolver();
		System.out.println("hinansadna");
		urlResolver.setPrefix("/WEB-INF/jsp");
		urlResolver.setSuffix(".jsp");
		return urlResolver;
	}
	
  @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
