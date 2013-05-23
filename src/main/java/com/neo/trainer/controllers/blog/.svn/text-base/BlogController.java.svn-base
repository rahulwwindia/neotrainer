package com.neo.trainer.controllers.blog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neo.trainer.model.blog.Editor;
import com.neo.trainer.model.blog.Login;
import com.neo.trainer.service.blog.ITechnicalBlogService;

// TODO: Auto-generated Javadoc
/**
 * Controller for submitting editor data.
 */

@Controller
public class BlogController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(BlogController.class);

	/** The i technical blog service impl. */
	@Autowired
	ITechnicalBlogService iTechnicalBlogServiceImpl;

	/**
	 * Addtechnical blog.
	 *
	 * @param editor the editor
	 * @param result the result
	 * @param model the model
	 * @param request the request
	 * @return the string
	 */
	@RequestMapping(value = "/editor", method = RequestMethod.POST)
	public String addtechnicalBlog(@Valid Editor editor, BindingResult result,
			Model model, HttpServletRequest request) {
		String successMsg = "";
		if (!result.hasErrors()) {
			HttpSession session = request.getSession(false);

			String user = (String) session.getAttribute("user");
			String email = (String) session.getAttribute("email");

			if (user != null
					&& user.toLowerCase().trim()
							.equals(editor.getName().toLowerCase().trim())
					&& email != null
					&& email.equals(editor.getEmailId().trim())) {

				boolean retSuccess = iTechnicalBlogServiceImpl.addBlog(editor);

				if (retSuccess)
					successMsg = "Your data is submitted";

				else
					successMsg = "Your data cannot be submitted";

			}

			else {
				successMsg = "Invalid User or You are not Logged In.";
			}

			model.addAttribute("successMsg", successMsg);
		}
		return "techBlogEditor";
	}

	/**
	 * User sign in page.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/signInPage", method = RequestMethod.GET)
	public String userSignInPage(Model model) {
		model.addAttribute("loginUser", new Login());
		return "signIn";
	}

	/**
	 * User sign in submit.
	 *
	 * @param loginUser the login user
	 * @param result the result
	 * @param model the model
	 * @param request the request
	 * @return the string
	 */
	@RequestMapping(value = "/signInUser", method = RequestMethod.POST)
	public String userSignInSubmit(@Valid Login loginUser,
			BindingResult result, Model model, HttpServletRequest request) {
		if (!result.hasErrors()) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", loginUser.getUser());
			session.setAttribute("email", loginUser.getEmailId());
			model.addAttribute("editor", new Editor());
			return "techBlogEditor";
		}
		return "signIn";
	}

}