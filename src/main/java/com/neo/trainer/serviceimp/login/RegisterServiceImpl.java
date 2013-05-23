package com.neo.trainer.serviceimp.login;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import com.neo.trainer.model.login.User;
import com.neo.trainer.model.onlinetest.Group1;
import com.neo.trainer.service.login.RegisterService;

// TODO: Auto-generated Javadoc
/**
 * The Class RegisterServiceImpl.
 */
@Service
public class RegisterServiceImpl implements RegisterService {
	
	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(RegisterServiceImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/* (non-Javadoc)
	 * @see com.neo.trainer.service.login.RegisterService#addNewUser(com.neo.trainer.model.login.User, java.lang.String)
	 */
	public boolean addNewUser(User u, String groupName) {
		List<Group1> listGroup = null;
		try {
		
			listGroup = (List<Group1>) (hibernateTemplate.find(
					"from Group1 where groupName =?", groupName));
			log.info("listGroup: " + listGroup.get(0));

			User user = new User();
			user.setUserName(u.getUserName());
			user.setComments(u.getComments());
			user.setEmail(u.getEmail());
			user.setPassword(u.getPassword());
			user.setGroupUser(listGroup.get(0));

			hibernateTemplate.save(user);
			return true;
		} catch (Exception e) {
			log.info("Exception caught:" + e);
			e.printStackTrace();
		}
		return false;
	}
}
