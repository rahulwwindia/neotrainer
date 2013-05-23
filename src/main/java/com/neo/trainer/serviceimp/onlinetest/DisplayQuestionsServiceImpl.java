/*package com.neo.trainer.serviceimp.onlinetest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.JoinType;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import com.neo.trainer.model.onlinetest.Candidate;
import com.neo.trainer.model.onlinetest.Options;
import com.neo.trainer.model.onlinetest.QuestionSet;
import com.neo.trainer.model.onlinetest.Questions;
import com.neo.trainer.service.onlinetest.DisplayQuestionsService;
import com.neo.trainer.serviceimp.login.LoginServiceImpl;

// TODO: Auto-generated Javadoc
*//**
 * The Class DisplayQuestionsServiceImpl.
 *//*
@Service
public class DisplayQuestionsServiceImpl implements DisplayQuestionsService {

	*//** The Constant log. *//*
	private static final Logger log = Logger
			.getLogger(DisplayQuestionsServiceImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neo.trainer.service.onlinetest.DisplayQuestionsService#getQues(java
	 * .lang.String)
	 
	public HashMap<Questions, HashMap<Integer, Options>> getQues(
			String questSetId) {
		HashMap<Questions, HashMap<Integer, Options>> questOpthm = new HashMap<Questions, HashMap<Integer, Options>>();
		HashMap<Integer, Options> optionhm = new HashMap<Integer, Options>();
		Questions q = null;
		Options o = null;
		Set optionSet = null;
		Iterator optItr = null;
		try {
			List<QuestionSet> listQuestSet = null;
			QuestionSet qs = (QuestionSet) hibernateTemplate.get(
					QuestionSet.class, Integer.parseInt(questSetId));
			log.info("qs: " + qs);
			Set questSet = qs.getQuestions();
			log.info("questSet size: " + questSet.size());

			if (!questSet.isEmpty()) {
				Iterator questItr = questSet.iterator();
				while (questItr.hasNext()) {
					q = (Questions) questItr.next();
					log.info("q: " + q);
					optionSet = q.getOptions();
					log.info("optionSet: " + optionSet);
					if (!optionSet.isEmpty()) {
						// optionhm.clear();
						optionhm = new HashMap<Integer, Options>();
						log.info("optionhm cleared: " + optionhm);
						optItr = optionSet.iterator();
						while (optItr.hasNext()) {
							o = (Options) optItr.next();
							log.info("o-----: " + o);
							optionhm.put(o.getOptionId(), o);
							log.info("optionhm new: " + optionhm);
						}

					}
					questOpthm.put(q, optionhm);
					log.info("questOpthm-----------------: " + questOpthm);
				}
				log.info("questOpthm: " + questOpthm);
				return questOpthm;
			}
		} catch (Exception e) {
			log.error("Exception caught in getQuestions." + e);
		}
		return null;

	}

	public HashMap<Questions, HashMap<Integer, Options>> getQuestions(
			String questSetId, String settype, int level) {
		HashMap<Questions, HashMap<Integer, Options>> questOpthm = new HashMap<Questions, HashMap<Integer, Options>>();
		HashMap<Integer, Options> optionhm = new HashMap<Integer, Options>();
		Questions q = null;
		Options o = null;
		Set optionSet = null;
		Iterator optItr = null;

		try {

			Session session = hibernateTemplate.getSessionFactory()
					.openSession();

			Criteria c = session.createCriteria(QuestionSet.class);

			c.createAlias("questions", "q", CriteriaSpecification.LEFT_JOIN)
					.setFetchMode("c", FetchMode.JOIN)
					.add(Restrictions.eq("q.settype", settype));
			c.add(Restrictions.eq("q.level", level));
			c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

			QuestionSet qs = (QuestionSet) c.list().get(0);
			log.info("qs: " + qs);

			Set questSet = qs.getQuestions();
			log.info("questSet size: " + questSet.size());

			if (!questSet.isEmpty()) {
				Iterator questItr = questSet.iterator();
				while (questItr.hasNext()) {
					q = (Questions) questItr.next();
					log.info("q: " + q);
					optionSet = q.getOptions();
					log.info("optionSet: " + optionSet);
					if (!optionSet.isEmpty()) {
						optionhm = new HashMap<Integer, Options>();
						log.info("optionhm cleared: " + optionhm);
						optItr = optionSet.iterator();
						while (optItr.hasNext()) {
							o = (Options) optItr.next();
							log.info("o-----: " + o);
							optionhm.put(o.getOptionId(), o);
							log.info("optionhm new: " + optionhm);
						}

					}
					questOpthm.put(q, optionhm);
					log.info("questOpthm-----------------: " + questOpthm);
				}
				log.info("questOpthm: " + questOpthm);
				return questOpthm;
			}

		} catch (Exception e) {
			log.error("Exception caught in getQuestions." + e);
		}
		return null;

	}
}
*/