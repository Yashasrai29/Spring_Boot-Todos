package com.thoughtclan.springdemos.postprocessors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Bean factory post processor implementation which gets triggered after context is initialized.
 */
@Component
public class LoggingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	private static final Logger logger = LoggerFactory.getLogger(LoggingBeanFactoryPostProcessor.class);

	/**
	 * Logs a note that the post processor is initialized.
	 * 
	 * @param beanFactory Bean factory object
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		logger.info("Context initialized");
	}
}
