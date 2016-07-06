package com.bjb.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MessageSettings {
	public static Properties prop;

	public static Properties getProperties() {
		if (prop == null) {
			prop = new Properties();
			InputStream in = StaticSelectUtil.class
					.getResourceAsStream("message.properties");
			try {
				prop.load(in);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
	
	public static String getValue(String key){
		return MessageSettings.getProperties().getProperty(key).trim();
	}
}
