package com.neo.trainer.controllers.blog;

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

import com.neo.trainer.model.blog.Comments;
import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.model.login.User;
import com.neo.trainer.service.blog.BlogCommentService;

// TODO: Auto-generated Javadoc
/**
 * The Class BlogComment.
 */
@Controller
public class BlogComment {

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(BlogComment.class);

	/** The blog serv. */
	@Autowired
	BlogCommentService blogServ;

	/**
	 * The blog comm.
	 * 
	 * @param blogComment
	 *            the blog comment
	 * @param result
	 *            the result
	 * @param model
	 *            the model
	 * @param request
	 *            the request
	 * @return the string
	 */
	/*
	 * @Autowired BlogCommentService blogComm;
	 */

	/** The delete comm. */
	/*
	 * @Autowired DeleteCommentService deleteComm;
	 */

	/**
	 * Post comment.
	 * 
	 * @param blogComment
	 *            the blog comment
	 * @param result
	 *            the result
	 * @param model
	 *            the model
	 * @param request
	 *            the request
	 * @return the string
	 */
	@RequestMapping(value = "/saveComment", method = RequestMethod.POST)
	public String postComment(@Valid Comments blogComment,
			BindingResult result, Model model, HttpServletRequest request) {
		log.info("Inside controller postComment...");
		String postID = request.getParameter("postID");
		String cID = request.getParameter("cID");
		log.info("cID: " + cID);
		if (cID != "") {
			blogComment.setCommId(Integer.parseInt(cID));
		}
		String commMsg = "";
		ModelMap modelMap = new ModelMap();
		if (!result.hasErrors()) {
			log.info("Does not contain errors.");
			HttpSession httpSession = request.getSession(false);
			boolean valid = blogServ.saveComments(blogComment,
					(User) httpSession.getAttribute("userSessionName"), postID);
			if (valid) {
				commMsg = "Comment successfully saved.";
			} else {
				commMsg = "Comment could not be saved.";
			}
		}

		return "redirect:viewComments.htm?postID=" + postID + "&&commMsg="
				+ commMsg;
	}

	/**
	 * View comments.
	 * 
	 * @param req
	 *            the req
	 * @param model
	 *            the model
	 * @return the model and view
	 */
	@RequestMapping(value = "/viewComments", method = RequestMethod.GET)
	public ModelAndView viewComments(HttpServletRequest req, Model model) {
		String postID = req.getParameter("postID");
		log.info("inside controller viewComments..." + "postID: " + postID);
		ModelMap modelMap = new ModelMap();

		Posts p = blogServ.getPost(Integer.parseInt(postID));
		modelMap.addAttribute("post", p);

		modelMap.addAttribute("hmComm",
				blogServ.viewComments(Integer.parseInt(postID)));

		model.addAttribute("blogComment", new Comments());

		model.addAttribute("commMsg", req.getParameter("commMsg"));
		return new ModelAndView("showComments", modelMap);
	}

	/**
	 * Delete comment.
	 * 
	 * @param model
	 *            the model
	 * @param request
	 *            the request
	 * @param commId
	 *            the comm id
	 * @return the string
	 */
	@RequestMapping(value = "/deleteComm", method = RequestMethod.GET)
	public String deleteComment(Model model, HttpServletRequest request,
			@RequestParam String commId) {
		log.info("Inside controller deleteComment...commId: " + commId);
		String postID = request.getParameter("postID");
		String commMsg = "";

		boolean valid = blogServ.deleteComment(commId);
		if (valid) {
			commMsg = "Comment Deleted!!!";
		}
		return "redirect:viewComments.htm?postID=" + postID + "&&commMsg="
				+ commMsg;
	}

}
