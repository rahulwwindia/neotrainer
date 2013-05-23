package com.neo.trainer.model.onlinetest;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.OrderBy;

// TODO: Auto-generated Javadoc
/**
 * The Class Questions.
 */
@Entity
@Table(name = "Questions")
public class Questions implements Comparable<Questions>{

	/** The quest id. */
	@Id
	@GeneratedValue
	@Column(name = "QuestId")
	private Integer questId;

	/** The quest desc. */
	@Column(name = "QuestDesc")
	private String questDesc;

	/** The correct option. */
	@Column(name = "CorrectOption")
	private Integer correctOption;

	/** The quest desc. */
	@Column(name = "SetType")
	private String settype;
	
	@Column(name = "Level")
	private Integer level;

	/** The options. */
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
	@OrderBy(clause = "optionId")
	private Set<Options> options;

	/** The group. */
	/*@ManyToOne
	// Many Questions to one Group
	@JoinColumn(name = "GroupId")
	private Group1 group;*/

	/** The quest set. */
	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "Questions_QuestionSet", joinColumns = {
	 * 
	 * @JoinColumn(name = "QuestId") }, inverseJoinColumns = { @JoinColumn(name
	 * = "SetId") }) private Set<QuestionSet> questSet = new
	 * HashSet<QuestionSet>();
	 */

	@ManyToOne
	// Many options to one Question
	@JoinColumn(name = "SetId")
	private QuestionSet questSet;

	/**
	 * Gets the quest id.
	 * 
	 * @return the quest id
	 */
	public Integer getQuestId() {
		return questId;
	}

	/**
	 * Sets the quest id.
	 * 
	 * @param questId
	 *            the new quest id
	 */
	public void setQuestId(Integer questId) {
		this.questId = questId;
	}

	/**
	 * Gets the quest desc.
	 * 
	 * @return the quest desc
	 */
	public String getQuestDesc() {
		return questDesc;
	}

	/**
	 * Sets the quest desc.
	 * 
	 * @param questDesc
	 *            the new quest desc
	 */
	public void setQuestDesc(String questDesc) {
		this.questDesc = questDesc;
	}

	/**
	 * Gets the options.
	 * 
	 * @return the options
	 */
	public Set<Options> getOptions() {
		return options;
	}

	/**
	 * Sets the options.
	 * 
	 * @param options
	 *            the new options
	 */
	public void setOptions(Set<Options> options) {
		this.options = options;
	}

	/**
	 * Gets the group.
	 * 
	 * @return the group
	 */
/*	public Group1 getGroup() {
		return group;
	}

	*//**
	 * Sets the group.
	 * 
	 * @param group
	 *            the new group
	 *//*
	public void setGroup(Group1 group) {
		this.group = group;
	}*/

	/**
	 * Gets the correct option.
	 * 
	 * @return the correct option
	 */
	public Integer getCorrectOption() {
		return correctOption;
	}

	/**
	 * Sets the correct option.
	 * 
	 * @param correctOption
	 *            the new correct option
	 */
	public void setCorrectOption(Integer correctOption) {
		this.correctOption = correctOption;
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
	 * @param questSet
	 *            the new quest set
	 */
	public void setQuestSet(QuestionSet questSet) {
		this.questSet = questSet;
	}


	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getSettype() {
		return settype;
	}

	public void setSettype(String settype) {
		this.settype = settype;
	}

 
	public int compareTo(Questions o) {
		// TODO Auto-generated method stub
	 /*     final int BEFORE = -1;
	      final int AFTER = 1;

	      if (that == null) {
	         return BEFORE;
	      }

	      Comparable thisCertificate = this.getName();
	      Comparable thatCertificate = that.getName();

	      if(thisCertificate == null) {
	         return AFTER;
	      } else if(thatCertificate == null) {
	         return BEFORE;
	      } else {
	         return thisCertificate.compareTo(thatCertificate);
	      }*/
		int c=this.getQuestId()-o.getQuestId();
		return c;
	}
	

}
