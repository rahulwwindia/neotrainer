package com.neo.trainer.service.blog;

import java.util.HashMap;
import java.util.List;

import com.neo.trainer.model.blog.Comments;
import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.model.login.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface BlogCommentService.
 */
public interface BlogCommentService {
	
	/**
	 * View comments.(called when view comment link clicked at posts.jsp)
	 *
	 * @param postId the post id
	 * @return the hash map
	 */
	public HashMap<Comments, String> viewComments(int postId);

	/**
	 * Gets the post.(called when view comment link clicked at posts.jsp)
	 *
	 * @param postId the post id
	 * @return the post
	 */
	public Posts getPost(int postId);

	/**
	 * Save comments.(saves new & edited comments)
	 *
	 * @param c the c
	 * @param user the user
	 * @param postId the post id
	 * @return true, if successful
	 */
	public boolean saveComments(Comments c, User user, String postId);
	
	/**
	 * Delete comment.
	 *
	 * @param commandId the command id
	 * @return true, if successful
	 */
	public boolean deleteComment(String commandId);
	
	
}
