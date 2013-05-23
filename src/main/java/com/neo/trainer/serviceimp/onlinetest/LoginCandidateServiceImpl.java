package com.neo.trainer.serviceimp.onlinetest;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.login.User;
import com.neo.trainer.model.onlinetest.Candidate;
import com.neo.trainer.model.onlinetest.Group1;
import com.neo.trainer.service.onlinetest.LoginCandidateService;
import com.neo.trainer.serviceimp.helper.UploadFileHelper;
import com.neo.trainer.serviceimp.login.LoginServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginCandidateServiceImpl.
 */
@Service
public class LoginCandidateServiceImpl implements LoginCandidateService {

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neo.trainer.service.onlinetest.LoginCandidateService#getCand(java
	 * .lang.String)
	 */
	public Candidate getCand(String candName) {
		List<Candidate> listCand = null;
		try {
			listCand = (List<Candidate>) (hibernateTemplate.find(
					"from Candidate c where c.email=?", candName));

			log.info("listCand: " + listCand);
			if (listCand.isEmpty()) {
				return null;
			} else {
				return listCand.get(0);
			}
		} catch (Exception e) {
			log.error("Excepton in authenticateUser....." + e);
		}
		return null;
	}

	public boolean addNewCand(Candidate candidate, HttpServletRequest request) {
		List<Group1> listGroup = null;
		List<Candidate> listCandi = null;
		try {
			listCandi = (List<Candidate>) hibernateTemplate.find(
					"from Candidate where email=?", candidate.getEmail());
			if (listCandi.isEmpty()) {
				log.info("group name: " + candidate.getGroupName());
				if (candidate.getFileData() != null) {
					String path = "/resources/resume/"
							+ candidate.getFileData().getOriginalFilename();
					log.info("Resume:" + path); 

					UploadFileHelper.uploadFile(candidate, path,request);
					candidate.setResume(candidate.getFileData()
							.getOriginalFilename());
				}

				listGroup = (List<Group1>) hibernateTemplate
						.find("from Group1 where groupName='"
								+ candidate.getGroupName().trim() + "'");
				log.info("listGroup: " + listGroup);

				candidate.setExperience(candidate.getExperience());
				candidate.setCandGroup(listGroup.get(0));
				candidate.setAuthority("Cand_User");
				candidate.setEnabled(1);
				hibernateTemplate.save(candidate);

				HttpSession httpSession = request.getSession(true);
				httpSession.setAttribute("candSessionName", candidate);

				return true;
			} else
				return false;
		} catch (Exception e) {
			log.info("Exception caught:" + e);
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * public void uploadResume() {
	 * 
	 * }
	 */
}
