package com.neo.trainer.model.onlinetest;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Results.
 */
@Entity
@Table(name = "Results")
public class Results {

	/** The results id. */
	@Id
	@GeneratedValue
	@Column(name = "ResultsId")
	private Integer resultsId;
	
	/** The score. */
	@Column(name = "Score")
	private Integer score;
	
	/** The exam date. */
	@Column(name = "ExamDate")
	private Date examDate;
	 
	@Override
	public String toString() {
		return "Results [resultsId=" + resultsId + ", score=" + score
				+ ", examDate=" + examDate + ", questSet=" + questSet
				+ ", candidate=" + candidate + ", groupId=" + groupId + "]";
	}

	public Group1 getGroupId() {
		return groupId;
	}

	public void setGroupId(Group1 groupId) {
		this.groupId = groupId;
	}

	/** The quest set. */
	@ManyToOne
	// Many results to one Question Set
	@JoinColumn(name = "SetId")
	private QuestionSet questSet;
	
	/** The candidate. */
	@ManyToOne
	// Many results to one Candidate
	@JoinColumn(name = "CandId")
	private Candidate candidate;
	
	
	/** The candidate. */
	@ManyToOne
	// Many results to one Candidate
	@JoinColumn(name = "GroupId")
	private Group1 groupId;
	  

	/**
	 * Gets the results id.
	 *
	 * @return the results id
	 */
	public Integer getResultsId() {
		return resultsId;
	}

	/**
	 * Sets the results id.
	 *
	 * @param resultsId the new results id
	 */
	public void setResultsId(Integer resultsId) {
		this.resultsId = resultsId;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

	/**
	 * Gets the exam date.
	 *
	 * @return the exam date
	 */
	public Date getExamDate() {
		return examDate;
	}

	/**
	 * Sets the exam date.
	 *
	 * @param examDate the new exam date
	 */
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	/**
	 * Gets the quest set.
	 *
	 * @return the quest set
	 */
	public QuestionSet getQuestSet() {
		return questSet;
	}

	/**
	 * Sets the quest set.
	 *
	 * @param questSet the new quest set
	 */
	public void setQuestSet(QuestionSet questSet) {
		this.questSet = questSet;
	}

	/**
	 * Gets the candidate.
	 *
	 * @return the candidate
	 */
	public Candidate getCandidate() {
		return candidate;
	}

	/**
	 * Sets the candidate.
	 *
	 * @param candidate the new candidate
	 */
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	
}
