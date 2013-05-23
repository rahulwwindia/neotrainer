package com.neo.trainer.serviceimp.blog;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.model.login.User;
import com.neo.trainer.model.onlinetest.Group1;
import com.neo.trainer.service.blog.ShowPostsService;
import com.neo.trainer.serviceimp.login.LoginServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowPostsServiceImpl.
 */
@Service
public class ShowPostsServiceImpl implements ShowPostsService {
	
	/** The Constant log. */ 
	private static final Logger log = Logger.getLogger(LoginServiceImpl.class);

	/** The session factory. */
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/* (non-Javadoc)
	 * @see com.neo.trainer.service.blog.ShowPostsService#getPosts(java.lang.String)
	 */
	public HashMap<Posts, String> getPosts(String groupName) {
		List<User> listUser = null;
		List<Group1> listGroup1 = null;
		HashMap<Posts, String> hmPosts = new HashMap<Posts, String>();
		Set<Posts> setPosts = null;
		Iterator setItr = null;
		Posts p;
		try {
		
			listGroup1 = (List<Group1>) (hibernateTemplate.find(
					"from Group1 where groupName =?", groupName));
			log.info("listGroup1: " + listGroup1);

			log.info("listGroup1: " + listGroup1.get(0));
			setPosts = null;
			setItr = null;
			setPosts = listGroup1.get(0).getPosts();
			log.info("setPosts: " + setPosts);
			if (!setPosts.isEmpty()) {
				setItr = setPosts.iterator();
				while (setItr.hasNext()) {
					p = (Posts) setItr.next();
					hmPosts.put(p, p.getUser().getUserName());
				}
			}
			log.info("hmPosts: " + hmPosts);
			return hmPosts;
		} catch (Exception e) {
			log.error("Exception caught: " + e);
			e.printStackTrace();
		}
		return null;
	}
}
