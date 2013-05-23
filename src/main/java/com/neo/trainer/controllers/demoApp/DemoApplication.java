package com.neo.trainer.controllers.demoApp;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neo.trainer.service.demoApp.DemoAppService;
import com.neo.trainer.serviceimp.helper.RetrievePropertiesValue;

// TODO: Auto-generated Javadoc
/**
 * The Class DemoApplication.
 */
@Controller
public class DemoApplication {

	/**
	 * Spring demo app.
	 * 
	 * @param model
	 *            the model
	 * @param request
	 *            the request
	 * @return the string
	 */
	@Autowired
	private DemoAppService demoAppService;
	
	
	@RequestMapping(value = "/demoApp.htm", method = RequestMethod.GET)
	public String springDemoApp(@ModelAttribute("app") String app, Model model, HttpServletRequest request) {
		String url = request.getRequestURI();
		String[] arr = url.split("/");
		String key = arr[arr.length - 1];

		model.addAttribute("key", app.toLowerCase()+key.split("\\.")[0].toLowerCase());
		model.addAttribute("demoApp", demoAppService.getDemoApp(app));

		return "demoApp"; 
	}


}
