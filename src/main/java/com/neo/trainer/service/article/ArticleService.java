package com.neo.trainer.service.article;

import java.util.List;
import com.neo.trainer.model.article.Article;
import com.neo.trainer.model.article.ViewArticle;

// TODO: Auto-generated Javadoc
/**
 * The Interface ArticleService.
 */
public interface ArticleService {

	/**
	 * Adds the article.
	 *
	 * @param article the article
	 * @return true, if successful
	 */
	boolean addArticle(Article article);

	/**
	 * Gets the article sort by date.
	 *
	 * @return the article sort by date
	 */
	List<Article> getArticleSortByDate(String articleType);

	/**
	 * Gets the article by title.
	 *
	 * @param articleTitle the article title
	 * @return the article by title
	 */
	List<Article> getArticleByTitle(String articleTitle);

	/**
	 * Post comment on article.
	 *
	 * @param viewArticle the view article
	 * @return true, if successful
	 */
	boolean postCommentOnArticle(ViewArticle viewArticle);
}
