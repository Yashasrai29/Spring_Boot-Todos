package com.thoughtclan.springdemos.postprocessors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Bean post processor implementation which gets triggered after each bean is initialized.
 */
public class LoggingBeanPostProcessor implements BeanPostProcessor {
	private static final Logger logger = LoggerFactory.getLogger(LoggingBeanPostProcessor.class);
	
	/**
	 * Logs a note that the bean post processor is initialized.
	 * 
	 * @param bean Bean that is initialized
	 * @param beanName Name of bean
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		logger.info("Before initializing {}.", beanName);
		return bean;
	}

	/**
	 * Logs a note that the bean post processor is initialized.
	 * 
	 * @param bean Bean that is initialized
	 * @param beanName Name of bean
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		logger.info("After initializing {}.", beanName);
		return bean;
	}
}
