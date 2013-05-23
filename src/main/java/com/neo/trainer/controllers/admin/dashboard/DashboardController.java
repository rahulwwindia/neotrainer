package com.neo.trainer.controllers.admin.dashboard;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neo.trainer.service.dashboard.DashboardService;
import com.neo.trainer.service.onlinetest.QuestionsService;

@Controller
public class DashboardController {
	private static final Logger log = Logger
			.getLogger(DashboardController.class);

	@Autowired
	DashboardService dashServ;

	@RequestMapping(value = "/dash", method = RequestMethod.GET)
	public ModelAndView displayDashSettings() {
		log.info("Inside DashboardController displayDashSettings...");
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("posts", dashServ.getPosts());
		modelMap.addAttribute("article",dashServ.getArticles());
		modelMap.addAttribute("technologies",dashServ.getTechnologies());
		modelMap.addAttribute("quest",dashServ.getOnlineTest());
		return new ModelAndView("setDash", modelMap);
	}

	@RequestMapping(value = "/showSelected", method = RequestMethod.POST)
	public ModelAndView showSelected(@RequestParam String topics) {
		
		ModelMap modelMap = new ModelMap();
		
		dashServ.saveDashOption(topics);
		
		return new ModelAndView("showDash", modelMap);
	}

	/*
	 * public enum topic { blogger, articles, technologies, onlinetest }
	 */
}
