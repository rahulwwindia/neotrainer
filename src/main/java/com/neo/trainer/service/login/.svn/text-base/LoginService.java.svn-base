package com.neo.trainer.service.login;

import java.util.List;

import com.neo.trainer.model.login.User;
import com.neo.trainer.model.onlinetest.Group1;

// TODO: Auto-generated Javadoc
/**
 * The Interface LoginService.
 */
public interface LoginService {

	
	/**
	 * Gets the user.
	 *
	 * @param userEmail the user email
	 * @return the user
	 */
	public User getUser(String userEmail);

	/**
	 * Gets the user roles.
	 *
	 * @param u the u
	 * @return the user roles
	 */
	public List<String> getUserRoles(User u);
	/**
	 * Adds the new user.
	 *
	 * @param u the u
	 * @param groupName the group name
	 * @return true, if successful
	 */
	public boolean addNewUser(User u, String groupName);
	
	public List<Group1> getGroups();
	
}
