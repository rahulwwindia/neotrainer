package com.neo.trainer.service.onlinetest;

import javax.servlet.http.HttpServletRequest;

import com.neo.trainer.model.onlinetest.Candidate;

// TODO: Auto-generated Javadoc
/**
 * The Interface LoginCandidateService.
 */
public interface LoginCandidateService {

	/**
	 * Gets the cand.
	 *
	 * @param candName the cand name
	 * @return the cand
	 */
	public Candidate getCand(String candName);
	
	/**
	 * Adds the new cand.
	 *
	 * @param c the c
	 * @param CandGroup the cand group
	 * @return true, if successful
	 */
	public boolean addNewCand(Candidate candidate,HttpServletRequest request);
}
