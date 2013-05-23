package com.neo.trainer.model.onlinetest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OrderBy;

// TODO: Auto-generated Javadoc
/**
 * The Class Options.
 */
@Entity
@Table(name = "Options")
public class Options {

	/** The option id. */
	@Id
	@GeneratedValue
	@Column(name = "OptionId")
	private Integer optionId;
	
	/** The option desc. */
	@Column(name = "OptionDesc")
	private String optionDesc;
	
	
	/** The question. */
	@ManyToOne
	// Many options to one Question
	@JoinColumn(name = "QuestionId")
	private Questions question;

	/**
	 * Gets the option id.
	 *
	 * @return the option id
	 */
	public Integer getOptionId() {
		return optionId;
	}

	/**
	 * Sets the option id.
	 *
	 * @param optionId the new option id
	 */
	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	/**
	 * Gets the option desc.
	 *
	 * @return the option desc
	 */
	public String getOptionDesc() {
		return optionDesc;
	}

	/**
	 * Sets the option desc.
	 *
	 * @param optionDesc the new option desc
	 */
	public void setOptionDesc(String optionDesc) {
		this.optionDesc = optionDesc;
	}

	/**
	 * Gets the question.
	 *
	 * @return the question
	 */
	public Questions getQuestion() {
		return question;
	}

	/**
	 * Sets the question.
	 *
	 * @param question the new question
	 */
	public void setQuestion(Questions question) {
		this.question = question;
	}
	
}
