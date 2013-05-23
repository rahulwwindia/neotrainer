package com.neo.trainer.serviceimp.login;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.service.blog.*;
import com.neo.trainer.service.login.LoginService;
import com.neo.trainer.model.login.User;
import com.neo.trainer.model.login.UserRoles;
import com.neo.trainer.model.onlinetest.Group1;
import com.neo.trainer.model.onlinetest.QuestionSet;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginServiceImpl.
 */
@Service
public class LoginServiceImpl implements LoginService {

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(LoginServiceImpl.class);

	/** The session factory. */
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neo.trainer.service.login.LoginService#getUser(java.lang.String)
	 */
	public User getUser(String userEmail) {
		List<User> listUser = null;
		try {

			listUser = (List<User>) (hibernateTemplate.find(
					"from User u where u.email=?", userEmail));

			log.info("listUser: " + listUser);
			if (listUser.isEmpty()) {
				return null;
			} else {
				return listUser.get(0);
			}
		} catch (Exception e) {
			log.error("Excepton in getUser....." + e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neo.trainer.service.login.LoginService#getUserRoles(com.neo.trainer
	 * .model.login.User)
	 */
	public List<String> getUserRoles(User u) {
		List<String> listUserRoles = new ArrayList<String>();
		try {
			log.info("user: " + u);
			Set<UserRoles> setUserRoles = u.getUserRole();
			log.info("user roles: " + setUserRoles);
			if (!setUserRoles.isEmpty()) {
				Iterator it = setUserRoles.iterator();
				while (it.hasNext()) {
					UserRoles ur = (UserRoles) it.next();
					log.info("authority: " + ur.getAuthority());
					listUserRoles.add(ur.getAuthority());
				}
				return listUserRoles;
			} else {
				return null;
			}

		} catch (Exception e) {
			log.error("Excepton in getUserRoles....." + e);
		}

		return null;
	}

	public boolean addNewUser(User u, String groupName) {
		List<Group1> listGroup = null;
		List<UserRoles> listusrRole = null;
		Set<UserRoles> setUserRoles = new HashSet<UserRoles>();
		List<User> listUser = null;
		
		try {			
			listUser = (List<User>) (hibernateTemplate.find(
					"from User where email =?", u.getEmail()));
			
			if (listUser.isEmpty()) {
				log.info("New user---------");
				listGroup = (List<Group1>) (hibernateTemplate.find(
						"from Group1 where groupName =?", groupName));
				log.info("listGroup: " + listGroup.get(0));

				User user = new User();
				user.setUserName(u.getUserName());
				user.setComments(u.getComments());
				user.setEmail(u.getEmail());
				user.setPassword(u.getPassword());
				user.setEnabled(1);
				user.setGroupUser(listGroup.get(0));
				user.setCrDate(new Date());

				listusrRole = (List<UserRoles>) (hibernateTemplate.find(
						"from UserRoles where authority =?", "ROLE_USER"));
				// userRoles.add("");
				setUserRoles.add(listusrRole.get(0));
				user.setUserRole(setUserRoles);

				hibernateTemplate.save(user);
				return true;
			} else
				return false;
		} catch (Exception e) {
			log.info("Exception caught:" + e);
			e.printStackTrace();
		}
		return false;
	}

	public List<Group1> getGroups() {
		List<Group1> listGroups = null;
		listGroups = (List<Group1>) (hibernateTemplate.find("from Group1"));
		return listGroups;
	}
}
