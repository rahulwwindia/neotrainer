package com.neo.trainer.service.login;

import com.neo.trainer.model.login.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface RegisterService.
 */
public interface RegisterService {

	/**
	 * Adds the new user.
	 *
	 * @param u the u
	 * @param groupName the group name
	 * @return true, if successful
	 */
	public boolean addNewUser(User u, String groupName);
}
