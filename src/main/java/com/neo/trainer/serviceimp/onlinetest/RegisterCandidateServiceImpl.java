package com.neo.trainer.serviceimp.onlinetest;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.login.User;
import com.neo.trainer.model.onlinetest.Candidate;
import com.neo.trainer.model.onlinetest.Group1;
import com.neo.trainer.service.onlinetest.RegisterCandidateService;
import com.neo.trainer.serviceimp.login.RegisterServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class RegisterCandidateServiceImpl.
 */
@Service
public class RegisterCandidateServiceImpl implements RegisterCandidateService {
	
	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(RegisterCandidateServiceImpl.class);

	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/* (non-Javadoc)
	 * @see com.neo.trainer.service.onlinetest.RegisterCandidateService#addNewCand(com.neo.trainer.model.onlinetest.Candidate, java.lang.String)
	 */
	public boolean addNewCand(Candidate c, String CandGroup) {
		List<Group1> listGroup = null;
		try {

			listGroup = (List<Group1>) hibernateTemplate.find(
					"from Group1 where groupName=?", CandGroup);
			log.info("listGroup: " + listGroup);

			c.setCandGroup(listGroup.get(0));
			hibernateTemplate.save(c);
			return true;

		} catch (Exception e) {
			log.info("Exception caught:" + e);
			e.printStackTrace();
		}
		return false;
	}
}
