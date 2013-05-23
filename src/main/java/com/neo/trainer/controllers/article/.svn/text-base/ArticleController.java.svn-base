package com.neo.trainer.controllers.article;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neo.trainer.model.article.Article;
import com.neo.trainer.model.article.ViewArticle;
import com.neo.trainer.service.article.ArticleService;

// TODO: Auto-generated Javadoc
/**
 * The Class ArticleController.
 */
@Controller
public class ArticleController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(ArticleController.class);

	/** The i article service impl. */
	@Autowired
	ArticleService articleServiceImpl;

	/**
	 * called when article is posted.
	 * 
	 * @param article
	 *            the article
	 * @param result
	 *            the result
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/article", method = RequestMethod.POST)
	public String addArticle(@Valid Article article, BindingResult result,
			Model model) {
		String successMsg = "";   
	System.out.println("@@@@@@@@@@"+article.getArticleType());
		List<Article> lstArticle = articleServiceImpl.getArticleByTitle(article
				.getTitle());
		System.out.println("lstArticle :" + lstArticle);
		if (lstArticle.isEmpty()) {
			
			boolean retSuccess = articleServiceImpl.addArticle(article);

			if (retSuccess)
				successMsg = "Your Article is submitted";

			else
				successMsg = "Your Article cannot be submitted";
		} else {
			successMsg = "Article with same title already exist. Give unique Article Title.";
		}

		model.addAttribute("articleOf", article.getArticleType());
		return "redirect:articlePage";
	}  

	/**
	 * called when an article is to be viewed.
	 * 
	 * @param articleTitle
	 *            the article title
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/viewArticle", method = RequestMethod.GET)
	public String viewArticle(
			@RequestParam("articleTitle") String articleTitle, Model model) {

		List<Article> lstArticle = articleServiceImpl
				.getArticleByTitle(articleTitle);

		if (lstArticle != null && lstArticle.size() == 1) {
			model.addAttribute("articlePost", lstArticle.get(0));
			model.addAttribute("articleId", lstArticle.get(0));
			System.out.println("00000");
			model.addAttribute("viewArticle", new ViewArticle());

			return "viewArticlePage";
		}

		String successMsg = "No such Article is posted.";
		model.addAttribute("successMsg", successMsg);

		return "redirect:articlePage";
	}
	
	/**
	 * View article.
	 * 
	 * @param viewArticle
	 *            the view article
	 * @param result
	 *            the result
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/postComment", method = RequestMethod.POST)
	public String viewArticle(@Valid ViewArticle viewArticle,
			BindingResult result, Model model) {
		String successMsg = "";
		logger.info("in view article");
		if (!result.hasErrors()) {
			boolean retSuccess = articleServiceImpl
					.postCommentOnArticle(viewArticle);
			if (retSuccess) { 
				successMsg = "Cannot post your comment";
				model.addAttribute("successMsg", successMsg);
			}
		} 
		return "viewArticlePage";
	}

	/**
	 * shows Article page.
	 * 
	 * @param articleType
	 *            the article type
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/articlePage", method = RequestMethod.GET)
	public String articlePage(@RequestParam("articleOf") String articleType,
			Model model) { 
       
		model.addAttribute("articleType", articleType);
		model.addAttribute("article", new Article());

		List<Article> lstArticle = articleServiceImpl.getArticleSortByDate(articleType);

		model.addAttribute("ArticleList", lstArticle);
		model.addAttribute("articleOf", articleType);
  
		return "article"; 
	}


}
