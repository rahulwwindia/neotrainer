package com.neo.trainer.service.onlinetest;

import java.util.HashMap;

import com.neo.trainer.model.onlinetest.QuestionSet;

// TODO: Auto-generated Javadoc
/**
 * The Interface QuestionSetService.
 */
public interface QuestionSetService {
	
	/**
	 * Gets the question set.
	 *
	 * @return the question set
	 */
	public HashMap<Integer, QuestionSet> getQuestionSet();

	/**
	 * Adds the quest set.
	 *
	 * @param setName the set name
	 * @return true, if successful
	 */
	public boolean addQuestSet(String setName);

	/**
	 * Edits the quest set.
	 *
	 * @param setId the set id
	 * @param setName the set name
	 * @return true, if successful
	 */
	public boolean editQuestSet(int setId, String setName);

	/**
	 * Delete quest set.
	 *
	 * @param setName the set name
	 * @return true, if successful
	 */
	public boolean deleteQuestSet(int setName);
}
