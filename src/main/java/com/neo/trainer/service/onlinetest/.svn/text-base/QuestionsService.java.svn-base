package com.neo.trainer.service.onlinetest;

import java.util.HashMap;
import java.util.List;

import com.neo.trainer.model.onlinetest.Options;
import com.neo.trainer.model.onlinetest.QuestionSet;
import com.neo.trainer.model.onlinetest.Questions;

// TODO: Auto-generated Javadoc
/**
 * The Interface QuestionsService.
 */
public interface QuestionsService {

	/**
	 * Edits the questions.
	 * 
	 * @param questId
	 *            the quest id
	 * @param questDesc
	 *            the quest desc
	 * @return the questions
	 */
	public Questions editQuestions(Questions question);

	/**
	 * Delete questions.
	 * 
	 * @param questId
	 *            the quest id
	 * @return true, if successful
	 */
	//public boolean deleteQuestions(Questions q);
	public boolean deleteQuestions(String[] questIdArr);

	public HashMap<Questions, List<Options>> getQuestions(
			String questSetId, String settype, int level);

	public QuestionSet getQuestionSet(String questId);

	public Questions getQuesiton(String questId);

	public List<Options> getOptions(String questId);

	// public Questions addQuestions(String questDesc,int questId) ;
	public Questions addQuestions(String[] optionArr,String[] setEntriesArr, String questDesc,String crop);

	public Options editOptions(Options o);

	public Options getOption(String optId);
	public Questions editQuestion(Questions q,String[] optionArr,
			String questDesc,String crop) ;
	public Questions addFileQuestions(String destFile);
}
