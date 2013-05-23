package com.neo.trainer.controllers.technology;

import javax.persistence.Version;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neo.trainer.serviceimp.admin.TechnologyServiceImpl;
import com.neo.trainer.serviceimp.helper.RetrievePropertiesValue;

// TODO: Auto-generated Javadoc
/**
 * The Class TechnologyController.
 */
@Controller
public class TechnologyController {
	
	/** The pro. */
	RetrievePropertiesValue pro = new RetrievePropertiesValue();
	
	

	/**
	 * App.
	 *
	 * @param model the model
	 * @param request the request
	 * @return the string
	 */
	@RequestMapping(value = "/mySqlInstall.htm", method = RequestMethod.GET)
	public String app(Model model, HttpServletRequest request) {

		String key = pro.getPropertyKey(request.getRequestURI());
		String steps = pro.getPropertisValueByKey(key);

		
		model.addAttribute("steps", steps);
		
		
		return "wizard";
	}

}
