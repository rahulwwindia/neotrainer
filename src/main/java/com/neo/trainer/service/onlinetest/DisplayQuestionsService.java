package com.neo.trainer.service.onlinetest;

import java.util.HashMap;

import com.neo.trainer.model.onlinetest.Options;
import com.neo.trainer.model.onlinetest.Questions;

// TODO: Auto-generated Javadoc
/**
 * The Interface DisplayQuestionsService.
 */
public interface DisplayQuestionsService {

	/**
	 * Gets the ques.
	 *
	 * @param questSetId the quest set id
	 * @return the ques
	 */
	public HashMap<Questions, HashMap<Integer, Options>> getQues(
			String questSetId);
	public HashMap<Questions, HashMap<Integer, Options>> getQuestions(
			String questSetId,String settype,int level);
}
