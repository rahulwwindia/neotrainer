package com.neo.trainer.serviceimp.onlinetest;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.onlinetest.Options;
import com.neo.trainer.model.onlinetest.QuestionSet;
import com.neo.trainer.model.onlinetest.Questions;
import com.neo.trainer.service.onlinetest.QuestionsService;

// TODO: Auto-generated Javadoc
/**
 * The Class QuestionsServiceImpl.
 */
@Service
public class QuestionsServiceImpl implements QuestionsService {

	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(QuestionsServiceImpl.class);
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HashMap<Questions, List<Options>> getQuestions(
			String questSetId, String settype, int level) {
		//HashMap<Questions, HashMap<Integer, Options>> questOpthm = new HashMap<Questions, HashMap<Integer, Options>>();
		HashMap<Questions,List<Options>> questOpthm = new HashMap<Questions, List<Options>>();
		//HashMap<Integer, Options> optionhm = new HashMap<Integer, Options>();
		List<Options> optionList;
		Questions q = null;
		Options o = null;
		Set optionSet = null;
		Iterator optItr = null;

		try {
			Session session = hibernateTemplate.getSessionFactory()
					.openSession();

			// Criteria c = session.createCriteria(QuestionSet.class);
			Criteria c = session.createCriteria(QuestionSet.class, "qs").add(
					Restrictions.eq("qs.setId", Integer.parseInt(questSetId)));
			c.createAlias("questions", "q", CriteriaSpecification.LEFT_JOIN)
					.addOrder(Order.asc("q.questId"))
					.setFetchMode("q", FetchMode.JOIN)
					.add(Restrictions.eq("q.settype", settype));
			c.add(Restrictions.eq("q.level", level));

			c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

			if (!c.list().isEmpty()) {
				QuestionSet qs = (QuestionSet) c.list().get(0);
				log.info("qs: " + qs);

				//Set<Questions> questSet = new sorted<Questions>();
				Set questSet = qs.getQuestions();
				log.info("questSet size: " + questSet.size());

				if (!questSet.isEmpty()) {
					Iterator questItr = questSet.iterator();
					while (questItr.hasNext()) {
						q = (Questions) questItr.next();
						log.info("q: " + q);

						optionSet = q.getOptions();
						log.info("optionSet: " + optionSet);
						//optionhm = new HashMap<Integer, Options>();
						optionList=new ArrayList<Options>();
						//log.info("optionhm cleared: " + optionhm);
						log.info("optionhm cleared: " + optionList);
						if (!optionSet.isEmpty()) {
							/*
							 * optionhm = new HashMap<Integer, Options>();
							 * log.info("optionhm cleared: " + optionhm);
							 */
							optItr = optionSet.iterator();
							while (optItr.hasNext()) {
								o = (Options) optItr.next();
								log.info("o-----: " + o);
								/*optionhm.put(o.getOptionId(), o);
								log.info("optionhm new: " + optionhm);*/
								optionList.add(o);
								log.info("optionList new: " + optionList);
							}
							
							Options crOpt = (Options) hibernateTemplate.get(Options.class,
									q.getCorrectOption());
							log.info("crOpt: "+crOpt);
							//optionhm.put(crOpt.getOptionId(), crOpt);
							optionList.add(crOpt);
						}
						//questOpthm.put(q, optionhm);
						questOpthm.put(q, optionList);
						log.info("questOpthm-----------------: " + questOpthm);
					}
					log.info("questOpthm: " + questOpthm);
					return questOpthm;
				}
			}

		} catch (Exception e) {
			log.error("Exception caught in getQuestions." + e);
		}
		return null;

	}

	public QuestionSet getQuestionSet(String questId) {

		try {
			Questions q = (Questions) hibernateTemplate.get(Questions.class,
					Integer.parseInt(questId));
			log.info("q: " + q);
			log.info("Quesiton set: " + q.getQuestSet());
			return q.getQuestSet();
		} catch (Exception e) {
			log.error("Exception caught in getQuestionSet..." + e);
		}
		return null;
	}

	public Questions getQuesiton(String questId) {
		try {
			Questions q = (Questions) hibernateTemplate.get(Questions.class,
					Integer.parseInt(questId));
			return q;
		} catch (Exception e) {
			log.error("Exception caught in getQuesitons..." + e);
		}
		return null;
	}

	public List<Options> getOptions(String questId) {
		List<Options> listOpt = new ArrayList<Options>();
		try {
			Questions q = (Questions) hibernateTemplate.get(Questions.class,
					Integer.parseInt(questId));
			Set optSet = q.getOptions();
			if (!optSet.isEmpty()) {
				Iterator itOpt = optSet.iterator();
				while (itOpt.hasNext()) {
					listOpt.add((Options) itOpt.next());
				}
			}
			return listOpt;
		} catch (Exception e) {
			log.error("Exception caught in getOptions..." + e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neo.trainer.service.onlinetest.QuestionsService#editQuestions(java
	 * .lang.String, java.lang.String)
	 */
	public Questions editQuestions(Questions q) {
		// hibernateTemplate = new HibernateTemplate(sessionFactory);
		// log.info("sessionFactory : " + sessionFactory);
		Questions quest = (Questions) hibernateTemplate.get(Questions.class,
				q.getQuestId());
		quest.setQuestDesc(q.getQuestDesc());

		hibernateTemplate.saveOrUpdate(quest);
		return quest;

	}

	/*
	 * public Questions addQuestions(String questDesc, int questId) { //
	 * hibernateTemplate = new HibernateTemplate(sessionFactory); //
	 * log.info("sessionFactory : " + sessionFactory); Questions quest =
	 * (Questions) hibernateTemplate.get(Questions.class, questId); Questions q
	 * = new Questions(); q.setQuestDesc(questDesc);
	 * q.setLevel(quest.getLevel()); q.setQuestSet(quest.getQuestSet());
	 * q.setSettype(quest.getSettype()); hibernateTemplate.save(q); return q;
	 * 
	 * }
	 */
	public Questions addQuestions(String[] optionArr, String[] setEntriesArr,
			String questDesc, String crop) {
		Questions q = new Questions();
		String questSet = setEntriesArr[0];
		String settype = setEntriesArr[1];
		String level = setEntriesArr[2];
		String cr = optionArr[Integer.parseInt(crop) - 1];

		QuestionSet qs = hibernateTemplate.get(QuestionSet.class,
				Integer.parseInt(questSet));

		q.setQuestSet(qs);
		q.setSettype(settype);
		q.setLevel(Integer.parseInt(level));
		q.setQuestDesc(questDesc);
		hibernateTemplate.save(q);
		log.info("q saved: " + q);

		Options o;
		for (int i = 0; i < optionArr.length; i++) {
			o = new Options();
			log.info("optionArr[" + i + "]" + optionArr[i]);
			o.setOptionDesc(optionArr[i]);
			o.setQuestion(q);
			hibernateTemplate.save(o);
			log.info("o saved: " + o);
			if (optionArr[i] == cr) {
				log.info("option id: " + o.getOptionId());
				q.setCorrectOption(o.getOptionId());
				hibernateTemplate.saveOrUpdate(q);
			}
		}

		return q;
	}

	public Questions editQuestion(Questions q, String[] optionArr,
			String questDesc, String crop) {

		String cr = optionArr[Integer.parseInt(crop) - 1];

		q.setQuestDesc(questDesc);

		Set optSet = q.getOptions();
		Iterator itrOpt = optSet.iterator();
		int i = 0;
		Options o;

		while (itrOpt.hasNext()) {
			o = (Options) itrOpt.next();
			log.info("optionArr[" + i + "]" + optionArr[i]);
			o.setOptionDesc(optionArr[i]);
			hibernateTemplate.saveOrUpdate(o);
			System.out.println("o saved.---");

			if (optionArr[i] == cr) {
				log.info("option id: " + o.getOptionId());
				q.setCorrectOption(o.getOptionId());
				hibernateTemplate.saveOrUpdate(q);
				System.out.println("q saved.---");
			}
			i++;
		}

		return q;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neo.trainer.service.onlinetest.QuestionsService#deleteQuestions(java
	 * .lang.String)
	 */
	/*
	 * public boolean deleteQuestions(Questions q) { Questions quest =
	 * (Questions) hibernateTemplate.get(Questions.class, q.getQuestId());
	 * hibernateTemplate.delete(quest); return true;
	 * 
	 * }
	 */

	public boolean deleteQuestions(String[] questIdArr) {
		Questions quest;
		for (int i = 0; i < questIdArr.length; i++) {
			log.info("questIdArr[" + i + "]" + questIdArr[i]);
			quest = (Questions) hibernateTemplate.get(Questions.class,
					Integer.parseInt(questIdArr[i]));
			hibernateTemplate.delete(quest);
		}

		return true;

	}

	public Options editOptions(Options o) {
		Options opt = (Options) hibernateTemplate.get(Options.class,
				o.getOptionId());
		opt.setOptionDesc(o.getOptionDesc());

		hibernateTemplate.saveOrUpdate(opt);
		return opt;

	}

	public Options getOption(String optId) {
		Options o = (Options) hibernateTemplate.get(Options.class,
				Integer.parseInt(optId));
		return o;
	}

	public Questions addFileQuestions(String destFile) {

		System.out.println("destFile :"+destFile);      
		File excelSheet = null;  
		Workbook workbook = null;

		try {
			Workbook wb = Workbook.getWorkbook(new File(destFile));
			log.info("No of sheets: " + wb.getNumberOfSheets());

			for (int sheetNo = 0; sheetNo < wb.getNumberOfSheets(); sheetNo++) {

				Sheet sheet = wb.getSheet(sheetNo);
				int columns = sheet.getColumns();
				int rows = sheet.getRows();
				String data;
				String[] questArr;
				Questions q;
				Options o = new Options();
				List<QuestionSet> qsList;
				List<Options> listOpt;
				
				log.info("Sheet Name\t" + wb.getSheet(sheetNo).getName());

				for (int row = 1; row < rows; row++) {
					questArr = new String[9];
					q = new Questions();

					for (int col = 0; col < columns; col++) {
						data = sheet.getCell(col, row).getContents();
						log.info(data + " ");
						questArr[col] = data;
						log.info(questArr[col] + " ");
					}
					log.info("\n");
					q.setQuestDesc(questArr[0]);
					hibernateTemplate.saveOrUpdate(q);

					qsList = (List<QuestionSet>) hibernateTemplate.find(
							"from QuestionSet qs where qs.setName=?",
							questArr[5]);
					q.setQuestSet(qsList.get(0));
					q.setSettype(questArr[7]);
					q.setLevel(Integer.parseInt(questArr[8]));
					hibernateTemplate.saveOrUpdate(q);

					for (int i = 1; i < 5; i++) {
						o.setOptionDesc(questArr[i]);
						o.setQuestion(q);
						hibernateTemplate.save(o);
					}
					
					Session session = hibernateTemplate.getSessionFactory()
							.openSession();
					Criteria c = session.createCriteria(Options.class, "o");
					c.createAlias("question", "q", CriteriaSpecification.LEFT_JOIN).add(
							Restrictions.eq("q.questId", q.getQuestId()))
							.add(Restrictions.eq("o.optionDesc", questArr[6]));
					
			//c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
					/*listOpt = (List<Options>) hibernateTemplate.find(
							"from Options op where op.optionDesc=? and op.",
							questArr[6]);*/
					listOpt=c.list();
					log.info("listOpt: "+listOpt.get(0).getOptionDesc());
					q.setCorrectOption(listOpt.get(0).getOptionId());
					hibernateTemplate.saveOrUpdate(q);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
