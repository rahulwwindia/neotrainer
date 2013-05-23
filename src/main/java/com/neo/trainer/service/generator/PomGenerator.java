package com.neo.trainer.service.generator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface PomGenerator.
 */
public interface PomGenerator {
	
	/**
	 * Generate pom.
	 *
	 * @param request the request
	 * @param key the key
	 * @param response the response
	 * @return true, if successful
	 */
	public boolean generatePom(HttpServletRequest request , String key,HttpServletResponse response);

}
