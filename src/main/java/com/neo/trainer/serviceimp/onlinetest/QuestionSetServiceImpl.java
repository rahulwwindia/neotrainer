package com.neo.trainer.serviceimp.onlinetest;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.model.onlinetest.Group1;
import com.neo.trainer.model.onlinetest.QuestionSet;
import com.neo.trainer.service.onlinetest.QuestionSetService;

// TODO: Auto-generated Javadoc
/**
 * The Class QuestionSetServiceImpl.
 */
@Service
public class QuestionSetServiceImpl implements QuestionSetService {
	
	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(QuestionSetServiceImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/* (non-Javadoc)
	 * @see com.neo.trainer.service.onlinetest.QuestionSetService#getQuestionSet()
	 */
	public HashMap<Integer, QuestionSet> getQuestionSet() {
		List<QuestionSet> listQuestSet = null;
		HashMap<Integer, QuestionSet> hmQuestSet = new HashMap<Integer, QuestionSet>();
		try {

					listQuestSet = (List<QuestionSet>) hibernateTemplate
					.find("from QuestionSet");
			log.info("listQuestSet: " + listQuestSet);
			for (int i = 0; i < listQuestSet.size(); i++) {
				hmQuestSet.put(listQuestSet.get(i).getSetId(),
						listQuestSet.get(i));
			}
			log.info("hmQuestSet: " + hmQuestSet);
			return hmQuestSet;
		} catch (Exception e) {
			log.error("Exception caught in getQuestionSet.");
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.neo.trainer.service.onlinetest.QuestionSetService#addQuestSet(java.lang.String)
	 */
	public boolean addQuestSet(String setName) {
		try {
			QuestionSet qs = new QuestionSet();
			qs.setSetName(setName);
			hibernateTemplate.save(qs);
			return true;
		} catch (Exception e) {
			log.info("Exception caught in assQuestSet..." + e);
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.neo.trainer.service.onlinetest.QuestionSetService#editQuestSet(int, java.lang.String)
	 */
	public boolean editQuestSet(int setId, String setName) {
		// List<QuestionSet> listQuestSet = null;
		try {
			QuestionSet qs = (QuestionSet) hibernateTemplate.get(
					QuestionSet.class, setId);
			log.info("qs: " + qs);
			qs.setSetName(setName);
			hibernateTemplate.saveOrUpdate(qs);
			return true;
		} catch (Exception e) {
			log.info("Exception caught in editQuestSet..." + e);
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.neo.trainer.service.onlinetest.QuestionSetService#deleteQuestSet(int)
	 */
	public boolean deleteQuestSet(int setId) {
		try {
			QuestionSet qs = (QuestionSet) hibernateTemplate.get(
					QuestionSet.class, setId);
			hibernateTemplate.delete(qs);
			return true;
		} catch (Exception e) {
			log.info("Exception caught in deleteQuestSet..." + e);
		}
		return false;
	}
}
