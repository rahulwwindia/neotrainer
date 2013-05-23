package com.neo.trainer.serviceimp.onlinetest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.onlinetest.Candidate;
import com.neo.trainer.model.onlinetest.Options;
import com.neo.trainer.model.onlinetest.QuestionSet;
import com.neo.trainer.model.onlinetest.Questions;
import com.neo.trainer.model.onlinetest.Results;
import com.neo.trainer.service.onlinetest.TestService;

@Service
public class TestServiceImpl implements TestService {

	private static final Logger log = Logger.getLogger(TestServiceImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<Integer> getResult(String testAns, String questSet,int totalQuest,Candidate c) {
		List<QuestionSet> qsList;
		List<Integer> marks = new ArrayList<Integer>();
		int result = 0;
		int per=0;
		log.info("testAns b4: " + testAns);
		if (!"{}".equals(testAns)) {
			testAns = testAns.replace("{", "").replace("}", "")
					.replace("\"", "");
			log.info("testAns: " + testAns);

			String[] quest = testAns.split(",");
			String[] qOpt = null;
			
			for (int i = 0; i < quest.length; i++) {
				log.info("quest: " + quest[0]);

				qOpt = quest[i].split(":");
				log.info("question: " + qOpt[0] + "answer: " + qOpt[1]);

				Questions q = (Questions) hibernateTemplate.get(
						Questions.class, Integer.parseInt(qOpt[0]));
				if (q.getCorrectOption() == Integer.parseInt(qOpt[1])) {
					result++;
				}

			}
			log.info("result---------->"+result);
			log.info("totalQuest---------->"+totalQuest); 
			per=(result*100)/totalQuest;
			marks.add(per);//result in %
			marks.add(totalQuest);//total questions
			marks.add(quest.length);//answered
			marks.add(totalQuest-quest.length);//unanswered
			
		}
		else{
			marks.add(0);
			marks.add(0);
			marks.add(0);
			marks.add(0);
		}
		 
		
		qsList = (List<QuestionSet>) hibernateTemplate.find(
				"from QuestionSet qs where qs.setName=?", questSet);
		Results r = new Results();
		r.setCandidate(c);
		r.setExamDate(new Date());
		r.setQuestSet(qsList.get(0));
		r.setScore(per); 
		r.setGroupId(c.getCandGroup());    
		hibernateTemplate.save(r);
		return marks;

	}
}
