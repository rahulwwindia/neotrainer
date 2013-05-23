package com.neo.trainer.serviceimp.blog;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.service.blog.BlogCommentService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.neo.trainer.model.blog.Comments;
import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.model.login.User;

// TODO: Auto-generated Javadoc
/**
 * The Class BlogCommentServiceImpl.
 */
@Service
public class BlogCommentServiceImpl implements BlogCommentService {

	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(BlogCommentServiceImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/* (non-Javadoc)
	 * @see com.neo.trainer.service.blog.BlogCommentService#viewComments(int)
	 */
	public HashMap<Comments, String> viewComments(int postId) {
		Posts p;
		Comments c;
		HashMap<Comments, String> hmComments = new HashMap<Comments, String>();
		try {
			/*
			 * hibernateTemplate = new HibernateTemplate(sessionFactory);
			 * log.info("sessionFactory : " + sessionFactory);
			 */
			p = (Posts) hibernateTemplate.get(Posts.class, postId);
			log.info("\nPosts: " + p);

			Set<Comments> setComm = p.getComment();
			
			log.info("\nsetComm: " + setComm);
			if (!setComm.isEmpty()) {
				Iterator setItr = setComm.iterator();
				while (setItr.hasNext()) {  
					c = (Comments) setItr.next();  
					hmComments.put(c, c.getComUser().getUserName());
				}
			}
			log.info("hmComments: " + hmComments);
			return hmComments;
		} catch (Exception e) {
			log.error("Exception caught: " + e);
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.neo.trainer.service.blog.BlogCommentService#getPost(int)
	 */
	public Posts getPost(int postId) {
		Posts p;
		try {
			p = (Posts) hibernateTemplate.get(Posts.class, postId);
			log.info("Posts: " + p);
			return p;

		} catch (Exception e) {
			log.info("Exception caught: " + e);
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.neo.trainer.service.blog.BlogCommentService#saveComments(com.neo.trainer.model.blog.Comments, com.neo.trainer.model.login.User, java.lang.String)
	 */
	public boolean saveComments(Comments c, User user, String postId) {
		try {
			log.info("user :" + user);
			Posts p = (Posts) hibernateTemplate.get(Posts.class,
					Integer.parseInt(postId));
			log.info("p: " + p);
			c.setPostComm(p);
			c.setComUser(user);
			c.setCommDate(new Date());
			log.info("c: " + c);
			hibernateTemplate.saveOrUpdate(c);
			return true;
		} catch (Exception e) {
			log.error("Exception caught: " + e);
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteComment(String commandId) {
		try {
				Comments c = (Comments) hibernateTemplate.get(Comments.class,
					Integer.parseInt(commandId));
			hibernateTemplate.delete(c);
			return true;
		} catch (Exception e) {
			log.info("Exception caught: " + e);
			e.printStackTrace();
		}
		return false;
	}
}
