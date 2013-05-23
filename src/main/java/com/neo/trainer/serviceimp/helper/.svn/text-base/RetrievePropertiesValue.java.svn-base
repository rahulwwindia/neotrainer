package com.neo.trainer.serviceimp.helper;

import java.util.Properties;

import javax.servlet.jsp.jstl.core.Config;

import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class RetrievePropertiesValue.
 */
@Service("help")
public class RetrievePropertiesValue {

	/**
	 * Gets the propertis value by key.
	 *
	 * @param key the key
	 * @return the propertis value by key
	 */
	public String getPropertisValueByKey(String key) {

		Properties prop = new Properties();
		java.net.URL url = Config.class.getClassLoader().getResource(
				"demoApp.properties");
		try {
			prop.load(url.openStream());

		} catch (Exception e) {
			System.out.println(e);
		}
		return prop.getProperty(key);

	}

	/**
	 * Gets the property key.
	 *
	 * @param url the url
	 * @return the property key
	 */
	public String getPropertyKey(String url) {
		String[] arr = url.split("/");
		String key = arr[arr.length - 1];
		return key.split("\\.")[0];
	}

}
