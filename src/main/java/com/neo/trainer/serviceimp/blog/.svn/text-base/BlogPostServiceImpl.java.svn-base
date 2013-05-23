package com.neo.trainer.serviceimp.blog;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.model.login.User;
import com.neo.trainer.model.onlinetest.Group1;
import com.neo.trainer.service.blog.BlogPostService;

// TODO: Auto-generated Javadoc
/**
 * The Class BlogPostServiceImpl.
 */
@Service
public class BlogPostServiceImpl implements BlogPostService {

	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(BlogPostServiceImpl.class);
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/* (non-Javadoc) 
	 * @see com.neo.trainer.service.blog.BlogPostService#savePost(com.neo.trainer.model.blog.Posts, java.lang.String)
	 */
	public boolean savePost(Posts post, String userName,String groupName) {
		List<User> listUser = null;
		List<Group1> groupList = null;
		List<Posts> listPosts = null; 
		try {  
			System.out.println("groupName"+groupName);
				listUser = (List<User>) hibernateTemplate.find(
					"from User where userName=?", userName);
				
				groupList = (List<Group1>) hibernateTemplate.find(
						"from Group1 where groupName=?", groupName.trim());
			log.info("user id: " + listUser.get(0).getUserId());
  
			post.setUser(listUser.get(0));
			post.setGroupPost(groupList.get(0));   
			post.setPostDate(new Date());  
			hibernateTemplate.save(post); 
			log.info("Post saved: " + post.getPostTitle() + " : "
					+ post.getPostDate() + " : " + post.getUser().getUserName() +""+post.getPostContent());
			
			return true;  

		} catch (Exception e) {
			log.error("Exception in save post." + e);
			e.printStackTrace();
		}  
		return false;
	} 
	 
	public List<Group1> getGroup()
	{
	
		return (List<Group1>) hibernateTemplate.find("from Group1");
	}
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
