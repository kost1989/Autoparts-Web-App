package ru.auto.dunkan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Spring MVC configuration
 * 
 * @author Marten Deinum
 * @author Koen Serneels
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ru.auto.dunkan.repository",
		                       "ru.auto.dunkan.controller"})
public class WebMvcContextConfiguration implements WebMvcConfigurer {

	private final ApplicationContext applicationContext;

	@Autowired
	public WebMvcContextConfiguration(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Bean
	ViewResolver viewResolver(){
		var resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp" );
		return resolver;
	}

}
