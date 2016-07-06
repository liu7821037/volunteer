package com.bjb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BasicConfig {
	
	private String propertiesFile;
	private Properties properties;
	
	public BasicConfig(String propertiesFile) {
		this.propertiesFile = propertiesFile;
	}
	
	public String getConfig(String key){
		return getConfig(key, null);
	}

	public String getConfig(String key, String defaultValue){
		
		if (properties == null)
		{
			properties = new Properties();
			InputStream inStream = getClass().getResourceAsStream(propertiesFile);
			try {	
				properties.load(inStream);
			} catch (IOException e) {
				e.printStackTrace();
				properties = null;
			}finally{
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(properties != null){
			return properties.getProperty(key, defaultValue);
		}
		return null;
	}
}