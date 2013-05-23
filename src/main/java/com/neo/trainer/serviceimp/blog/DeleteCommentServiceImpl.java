package com.neo.trainer.serviceimp.blog;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.blog.Comments;
import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.service.blog.DeleteCommentService;

// TODO: Auto-generated Javadoc
/**
 * The Class DeleteCommentServiceImpl.
 */
@Service
public class DeleteCommentServiceImpl implements DeleteCommentService {
	
	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(DeleteCommentServiceImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/* (non-Javadoc)
	 * @see com.neo.trainer.service.blog.DeleteCommentService#deleteComment(java.lang.String)
	 */
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
