package com.neo.trainer.service.blog;

import java.util.HashMap;
import java.util.List;

import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.model.onlinetest.Group1;

// TODO: Auto-generated Javadoc
/**
 * The Interface BlogPostService.
 */
public interface BlogPostService {
	
	/**
	 * Save post.
	 *
	 * @param post the post
	 * @param userName the user name
	 * @return true, if successful
	 */
	public boolean savePost(Posts post, String userName,String groupName);
	public List<Group1> getGroup();
	/**
	 * Delete posts.
	 *
	 * @param postId the post id
	 * @return true, if successful
	 */
	public boolean deletePosts(String postId);
	/**
	 * Gets the posts.(called when group selected from header technical blog)
	 *
	 * @param groupName the group name
	 * @return the posts
	 */
	public HashMap<Posts, String> getPosts(String groupName);
}
