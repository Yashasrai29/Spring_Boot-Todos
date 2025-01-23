package com.thoughtclan.springdemos.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.thoughtclan.springdemos.data.TodoDao;
import com.thoughtclan.springdemos.services.TodoService;
import com.thoughtclan.springdemos.services.impl.TodoServiceImpl;

/**
 * Java configuration class which scans for Spring beans in the base package "com.thoughtclan.springdemos".
 */
@Configuration
@ComponentScan("com.thoughtclan.springdemos")
public class TodoConfig {

	/**
	 * Returns property map from "config.properties". Defined as static as this is a {@link BeanFactoryPostProcessor}.
	 * 
	 * @return
	 * @throws IOException
	 */
	@Bean
    public static PropertyPlaceholderConfigurer ppc() throws IOException {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(new ClassPathResource("config.properties"));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }
	
	// you could also define a bean like this
	@Bean
	public TodoService todoService1(@Autowired TodoDao todoDao) {
		return new TodoServiceImpl(todoDao);
	}
}
