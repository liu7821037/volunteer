package com.bjb.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class GetApplicationContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
		
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
		GetApplicationContext.applicationContext = applicationContext;
	}
		
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
	
	public static Object getBean(String name){
		return applicationContext.getBean(name);
	}

}
