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

import com.neo.trainer.model.blog.Editor;
import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.service.blog.BlogPostService;
import com.neo.trainer.service.onlinetest.QuestionSetService;

// TODO: Auto-generated Javadoc
/**
 * The Class BlogPostController.
 */
@Controller
public class BlogPostController {

	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(BlogPostController.class);

	/** The bg post. */
	@Autowired
	BlogPostService bgPost;

	/**
	 * The delete post.
	 *
	 * @param posts the posts
	 * @param result the result
	 * @param model the model
	 * @param request the request
	 * @return the model and view
	 *//*
	@Autowired
	DeletePostsService deletePost;*/

	/** The show post. */
	/*@Autowired
	ShowPostsService showPost;*/

	/**
	 * Post quest.
	 *
	 * @param posts the posts
	 * @param result the result
	 * @param model the model
	 * @param request the request
	 * @return the model and view
	 */
	@RequestMapping(value = "/postQuest", method = RequestMethod.POST)
	public ModelAndView postQuest(@Valid Posts posts, BindingResult result,
			Model model, HttpServletRequest request) {
		log.info("Inside controller Post Quest...");
		String postMsg = "";
		ModelMap modelMap = new ModelMap();
		if (!result.hasErrors()) {
			log.info("Does not contain errors.");
			log.info("-------------------\n" + posts.getPostContent());
			HttpSession httpSession = request.getSession(false);
			boolean success = bgPost.savePost(posts,
					httpSession.getAttribute("userSessionName").toString(),request.getParameter("groupName"));
			if (success) { 
				postMsg = "Post successfully saved...";
			} else {
				postMsg = "Post could not be saved.";

			}
		}
		model.addAttribute("groupList",bgPost.getGroup() ); 
		modelMap.addAttribute("postMsg", postMsg);
		return new ModelAndView("postQuest", modelMap); 
	}

	/**
	 * Post quest.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/postQ", method = RequestMethod.GET)
	public String postQuest(Model model) {
		System.out.println("Group List"+bgPost.getGroup());   
		model.addAttribute("groupList",bgPost.getGroup() ); 
		model.addAttribute("posts", new Posts());
		return "postQuest";
	}  
	
	/** 
	 * Show posts.
	 *
	 * @param postID the post id
	 * @param request the request
	 * @return the string
	 */
	@RequestMapping(value = "/deletePosts", method = RequestMethod.GET)
	public String showPosts(@RequestParam String postID,HttpServletRequest request) {
		log.info("inside controller ShowPosts..." + postID);
		ModelMap modelMap = new ModelMap();
		String group=request.getParameter("grpName");
		boolean success=bgPost.deletePosts(postID);
		String postDelMsg="";
		if(success){
			postDelMsg="Post deleted...";
					}
		//modelMap.addAttribute("grpName", group);
		//modelMap.addAttribute("postDelMsg", postDelMsg);
	return "redirect:showPost.htm?grpName="+group;	
	}
	
	/**
	 * Show posts.
	 *
	 * @param grpName the grp name
	 * @return the model and view
	 */
	@RequestMapping(value = "/showPost", method = RequestMethod.GET)
	public ModelAndView showPosts(@RequestParam String grpName) {
		log.info("inside controller ShowPosts..." + grpName);
		ModelMap modelMap = new ModelMap();

		log.info("MAP DATA :"+ bgPost.getPosts(grpName));
		  
		modelMap.addAttribute("hmPosts", bgPost.getPosts(grpName));
		modelMap.addAttribute("grpName", grpName);
		return new ModelAndView("showPosts", modelMap);
	}
}
