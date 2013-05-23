package com.neo.trainer.model.onlinetest;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OrderBy;

// TODO: Auto-generated Javadoc
/**
 * The Class QuestionSet.
 */
@Entity
@Table(name = "QuestionSet")
public class QuestionSet {
	
	/** The set id. */
	@Id
	@GeneratedValue
	@Column(name = "SetId")
	private Integer setId;
	
	
	/** The set name. */
	@Column(name = "SetName")
	private String setName;
	
	/** The result. */
	@OneToMany(mappedBy = "questSet")
	private Set<Results> result;
	
	/** The questions. */
/*	@ManyToMany(mappedBy="questSet", fetch = FetchType.EAGER)
    private Set<Questions> questions = new HashSet<Questions>();*/
	
	@OneToMany(mappedBy = "questSet", fetch = FetchType.EAGER)
	//@OrderBy(clause = "questId")
	private Set<Questions> questions;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+setName;
	}
	 
	/**
	 * Gets the sets the id.
	 *
	 * @return the sets the id
	 */
	public Integer getSetId() {
		return setId;
	}

	/**
	 * Sets the sets the id.
	 *
	 * @param setId the new sets the id
	 */
	public void setSetId(Integer setId) {
		this.setId = setId;
	}

	/**
	 * Gets the sets the name.
	 *
	 * @return the sets the name
	 */
	public String getSetName() {
		return setName;
	}

	/**
	 * Sets the sets the name.
	 *
	 * @param setName the new sets the name
	 */
	public void setSetName(String setName) {
		this.setName = setName;
	}

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public Set<Results> getResult() {
		return result;
	}

	/**
	 * Sets the result.
	 *
	 * @param result the new result
	 */
	public void setResult(Set<Results> result) {
		this.result = result;
	}

	/**
	 * Gets the questions.
	 *
	 * @return the questions
	 */
	public Set<Questions> getQuestions() {
		return questions;
	}

	/**
	 * Sets the questions.
	 *
	 * @param questions the new questions
	 */
	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}

	/**
	 * Gets the questions.
	 *
	 * @return the questions
	 */
	/*public Set<Questions> getQuestions() {
		return questions;
	}*/

	/**
	 * Sets the questions.
	 *
	 * @param questions the new questions
	 */
	/*public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}*/
	
}
