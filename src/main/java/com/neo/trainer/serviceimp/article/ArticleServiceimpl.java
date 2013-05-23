package com.neo.trainer.serviceimp.article;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.article.Article;
import com.neo.trainer.model.article.ViewArticle;
import com.neo.trainer.service.article.ArticleService;

// TODO: Auto-generated Javadoc
/**
 * The Class ArticleServiceimpl.
 */
@Service
public class ArticleServiceimpl implements ArticleService {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(ArticleServiceimpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/* (non-Javadoc)
	 * @see com.neo.trainer.service.article.ArticleService#addArticle(com.neo.trainer.model.article.Article)
	 */
	public boolean addArticle(Article article) {
		System.out.println("in add article");
		if (article != null) {
			logger.info("in add Article method");
			article.setDate(new Date());
			hibernateTemplate.saveOrUpdate(article);
			return true;
		}

		return false;
	}  

	/* (non-Javadoc)
	 * @see com.neo.trainer.service.article.ArticleService#getArticleSortByDate()
	 */
	public List<Article> getArticleSortByDate(String articleType) {   
		@SuppressWarnings("unchecked")
		List<Article> lstArticle = hibernateTemplate.find("from Article where articleType='"+articleType+"'");
				/*.findByCriteria(DetachedCriteria.forClass(Article.class)
						.addOrder(Order.desc("date")));*/
		return lstArticle; 
	} 
   
	/* (non-Javadoc)  
	 * @see com.neo.trainer.service.article.ArticleService#getArticleByTitle(java.lang.String)
	 */
	public List<Article> getArticleByTitle(String articleTitle) {
	
		logger.info("in getArticle By Title method :"+articleTitle);    
		@SuppressWarnings("unchecked")
		List<Article> lstArticle = hibernateTemplate
				.findByCriteria(DetachedCriteria.forClass(Article.class).add(
						Restrictions.eq("title", articleTitle)));
		return lstArticle;
	}
  
	/* (non-Javadoc)
	 * @see com.neo.trainer.service.article.ArticleService#postCommentOnArticle(com.neo.trainer.model.article.ViewArticle)
	 */
	public boolean postCommentOnArticle(ViewArticle viewArticle) {
		logger.info("in post comment on article");
		if (viewArticle != null) {

			viewArticle.setDate(new Date());

			Article article = viewArticle.getFkArticle();
			Set<ViewArticle> sViewArticle = new HashSet<ViewArticle>();
			sViewArticle.add(viewArticle);
			article.setViewArticle(sViewArticle);
			hibernateTemplate.update(article);
  
			hibernateTemplate.saveOrUpdate(viewArticle);
			return true;
		}
		return false;
	}

}
