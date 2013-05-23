package com.neo.trainer.controllers.login;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.model.deshboard.Dashboard;
import com.neo.trainer.model.login.User;
import com.neo.trainer.model.onlinetest.Candidate;
import com.neo.trainer.service.dashboard.DashboardService;
import com.neo.trainer.service.login.LoginService;
import com.neo.trainer.service.onlinetest.LoginCandidateService;
import com.neo.trainer.service.onlinetest.QuestionSetService;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
public class LoginController {

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(LoginController.class);

	/** The login serv. */
	@Autowired
	LoginService loginServ; 

	/** The candlogin servadmin. */
	@Autowired
	LoginCandidateService candloginServ;

	@Autowired
	QuestionSetService questSetServ;
	
	@Autowired
	DashboardService dashServ;
 
	/*
	 * @Autowired RegisterService regService;
	 */
	/**
	 * Login popup.
	 * 
	 * @param request
	 *            the request
	 * @param model
	 *            the model
	 * @return the model and view
	 */
	@RequestMapping(value = "/loginPopup", method = RequestMethod.GET)
	public ModelAndView loginPopup(HttpServletRequest request, Model model) {
		log.info("Inside controller loginPopup...");
		ModelMap modelMap = new ModelMap();

		String postID = request.getParameter("postID");
		modelMap.addAttribute("postID", postID);
		// modelMap.addAttribute("source", source);
		modelMap.addAttribute("error", request.getParameter("error"));
		return new ModelAndView("popupLogin", modelMap);
	}

	// Alind's new URI for Login From headder

	@RequestMapping(value = "/loginH", method = RequestMethod.GET)
	public ModelAndView loginHead(HttpServletRequest request, Model model) {
		log.info("Inside controller loginPopup...");
		ModelMap modelMap = new ModelMap();

		String postID = request.getParameter("postID");
		modelMap.addAttribute("postID", postID);
		// modelMap.addAttribute("source", source);
		modelMap.addAttribute("error", request.getParameter("error"));
		return new ModelAndView("popupLogin", modelMap);
	}

	/**
	 * Login candi.
	 * 
	 * @param request
	 *            the request
	 * @param model
	 *            the model
	 * @return the model and view
	 */
	@RequestMapping(value = "/loginCand", method = RequestMethod.GET)
	public String loginCandi(HttpServletRequest request, Model model,
			HttpSession session) {
		if (session.getAttribute("userSessionName") != null) {
			return "home";
		} else {

			log.info("Inside controller loginPopup...");

			String postID = request.getParameter("postID");
			model.addAttribute("postID", postID);
			model.addAttribute("error", request.getParameter("error"));
			return "candLogin";
		}
	}   
   
	/**
	 * Login.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */ 
	@RequestMapping(value = "/securitylogin", method = RequestMethod.GET)
	public String login(ModelMap model) {
		log.info("--------------login called at controller.-----------");
		        
		model.addAttribute("newCand", new Candidate());   
		return "facade";      
	}  
 
	/**
	 * Loginerror.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		System.out.println("Test Login Failed");
		model.addAttribute("error", "true");
		model.addAttribute("newCand", new Candidate());   
		return "facade";
	}   

	/**
	 * Logout.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/securitylogout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		log.info("--------------logout called at controller.-----------");
		
		return "facade";    
	}

	/**
	 * Prints the welcome.
	 * 
	 * @param model
	 *            the model
	 * @param principal
	 *            the principal
	 * @param request
	 *            the request
	 * @return the string
	 */
	@RequestMapping(value = "/welcomeUser", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal,
			HttpServletRequest request) {
		User u=null;
		if(principal!=null)
		{
		 u= loginServ.getUser(principal.getName());
		log.info("u at controller: " + u);
		}
		if (u != null) {
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("userSessionName", u);

			List<String> roleList = loginServ.getUserRoles(u);
			model.addAttribute("grouplist", loginServ.getGroups());
			for (int i = 0; i < roleList.size(); i++) {
				if ("ROLE_ADMIN".equals(roleList.get(i))) {
					 
					return "redirect:dash.htm";
				} else if ("ROLE_USER".equals(roleList.get(i))) {

					List<Dashboard> dashOption=dashServ.getDashOption();
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
			// return "home";
		}
		model.addAttribute("newCand", new Candidate());   
		return "facade";
	}

	/** 
	 * Register.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		log.info("Inside controller register...");
		model.addAttribute("grouplist", loginServ.getGroups());
		model.addAttribute("newUser", new User());
		return "register";
	}

	/**
	 * Adds the user.
	 * 
	 * @param newUser
	 *            the new user
	 * @param result
	 *            the result
	 * @param model
	 *            the model
	 * @param groupUser
	 *            the group user
	 * @return the model and view
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@Valid User newUser, BindingResult result,
			Model model, @RequestParam String groupUser) {
		log.info("Inside controller addUser..." + groupUser);
		// ModelMap modelMap = new ModelMap();

		boolean success = loginServ.addNewUser(newUser, groupUser);
		if (success) {
			model.addAttribute("success", "Registration successful");
		} else {
			model.addAttribute("success", "Registration failed! Provide other email address.");

		}
		model.addAttribute("grouplist", loginServ.getGroups());
		model.addAttribute("newUser", new User());
		return "register";
	}

}
