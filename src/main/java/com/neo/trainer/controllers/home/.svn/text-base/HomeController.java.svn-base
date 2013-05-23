package com.neo.trainer.controllers.home;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neo.trainer.model.admin.TechTutorial;
import com.neo.trainer.model.admin.Technologies;
import com.neo.trainer.model.article.Article;
import com.neo.trainer.model.blog.Editor;
import com.neo.trainer.model.demoApp.DemoTechnology;
import com.neo.trainer.model.deshboard.Dashboard;
import com.neo.trainer.model.login.User;
import com.neo.trainer.model.onlinetest.Candidate;
import com.neo.trainer.service.admin.demoapp.DemoAppServiceAdmin;
import com.neo.trainer.service.article.ArticleService;
import com.neo.trainer.service.dashboard.DashboardService;
import com.neo.trainer.service.login.LoginService;
import com.neo.trainer.service.onlinetest.QuestionSetService;
import com.neo.trainer.serviceimp.admin.TechnologyServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * Sample controller for going to the home page with a message.
 */
@Controller
public class HomeController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/** The article service impl. */
	@Autowired
	TechnologyServiceImpl techSerImpl;

	@Autowired
	ArticleService articleServiceImpl;

	@Autowired
	LoginService loginServ;

	/** The quest set serv. */
	@Autowired
	QuestionSetService questSetServ;
	
	@Autowired
	DemoAppServiceAdmin demoAppServiceAdmin;
	
	@Autowired
	DashboardService dashServ;

	/**
	 * Selects the home page and populates the model with a message.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request,
			HttpSession session) { 

		HashMap<String, ArrayList<TechTutorial>> map = techSerImpl
				.getTechNTuteMAp();
		 List<DemoTechnology> demoList = demoAppServiceAdmin.getDemoAppTech();

		session.setAttribute("map", map);
		session.setAttribute("demoList", demoList);
	
		model.addAttribute("grouplist", loginServ.getGroups());
		/*
		 * model.addAttribute("questSetMap", questSetServ.getQuestionSet());
		 */
		if (session.getAttribute("userSessionName") != null) {

			if ((User.class).equals(session.getAttribute("userSessionName")
					.getClass())) {
				User u = (User) session.getAttribute("userSessionName");
				List<String> roleList = loginServ.getUserRoles(u);
				for (int i = 0; i < roleList.size(); i++) {
					if ("ROLE_ADMIN".equals(roleList.get(i))) {
						logger.info("admin login");
						System.out.println("admin login");
  
						return "redirect:dash.htm";
					} else if ("ROLE_USER".equals(roleList.get(i))) {
						
						List<Dashboard> dashOption=dashServ.getDashOption();
						System.out.println("+++++++"+dashOption.toString());
						for (Dashboard dash : dashOption) {
							if(dash.getDashOption().equalsIgnoreCase("articles"))
								model.addAttribute("article",dashServ.getArticles());
							if(dash.getDashOption().equalsIgnoreCase("blogger"))
								model.addAttribute("posts", dashServ.getPosts());
							if(dash.getDashOption().equalsIgnoreCase("technologies"))
								model.addAttribute("technologies",dashServ.getTechnologies());
							if(dash.getDashOption().equalsIgnoreCase("onlinetest"))
								model.addAttribute("quest",dashServ.getOnlineTest());
							
							}
						
						return "home";
					}  
				}
			} 
  
		}

		model.addAttribute("newCand", new Candidate());
		return "facade";

	}

	/**
	 * shows Technical Blog page.
	 * 
	 * @param model
	 *            the model
	 * @param request
	 *            the request
	 * @return the string
	 */
	@RequestMapping(value = "/technicalBlog", method = RequestMethod.GET)
	public String technicaleditorPage(Model model, HttpServletRequest request) {
		logger.info("Welcome to Technical Blog Page!");

		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();

		model.addAttribute("editor", new Editor());

		return "techBlogEditor";
	}

}
