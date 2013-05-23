package com.neo.trainer.serviceimp.blog;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.blog.Comments;
import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.service.blog.DeletePostsService;
import com.neo.trainer.serviceimp.login.LoginServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class DeletePostsServiceImpl.
 */
@Service
public class DeletePostsServiceImpl implements DeletePostsService {
	
	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(DeletePostsServiceImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/* (non-Javadoc)
	 * @see com.neo.trainer.service.blog.DeletePostsService#deletePosts(java.lang.String)
	 */
	public boolean deletePosts(String postId) {
		try {
				Posts p = (Posts) hibernateTemplate.get(Posts.class,
					Integer.parseInt(postId));
			hibernateTemplate.delete(p);
			return true;
		} catch (Exception e) {
			log.info("Exception caught: " + e);
			e.printStackTrace();
		}
		return false;
	}
}
