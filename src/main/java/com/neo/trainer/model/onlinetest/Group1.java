package com.neo.trainer.model.onlinetest;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import org.springframework.transaction.annotation.Transactional;

import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.model.login.User;

// TODO: Auto-generated Javadoc
/**
 * The Class Group1. 
 */
@Entity
@Table(name = "Group1")
@Transactional 
public class Group1 {
	
	/** The group id. */ 
	@Id
	@GeneratedValue
	@Column(name = "GroupId")
	private Integer groupId;
	
	/** The group name. */
	@Column(name = "GroupName")
	private String groupName;

	//one group to many questions
	/** The questions. */
	/*@OneToMany(mappedBy = "group")
	private Set<Questions> questions;*/
	
	//one group to many candidates
	/** The candidate. */
	@OneToMany(mappedBy = "CandGroup")
	private Set<Candidate> candidate;
	
	//one group to many users
		/** The user. */
	@OneToMany(mappedBy = "groupUser")
		private Set<User> user;
	
	@OneToMany(mappedBy = "groupId") 
	private Set<Results> results;   
		 
		//one group to many posts
		/** The posts. */
		@OneToMany(mappedBy = "groupPost", fetch = FetchType.EAGER)
		private Set<Posts> posts;

	/**
	 * Gets the group id.
	 *
	 * @return the group id
	 */
	public Integer getGroupId() {
		return groupId;
	}

	/**
	 * Sets the group id.
	 *
	 * @param groupId the new group id
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	/**
	 * Gets the group name.
	 *
	 * @return the group name
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * Sets the group name.
	 *
	 * @param groupName the new group name
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * Gets the questions.
	 *
	 * @return the questions
	 */
/*	public Set<Questions> getQuestions() {
		return questions;
	}

	*//**
	 * Sets the questions.
	 *
	 * @param questions the new questions
	 *//*
	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}*/

	/**
	 * Gets the candidate.
	 *
	 * @return the candidate
	 */
	public Set<Candidate> getCandidate() {
		return candidate;
	}

	/**
	 * Sets the candidate.
	 *
	 * @param candidate the new candidate
	 */
	public void setCandidate(Set<Candidate> candidate) {
		this.candidate = candidate;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public Set<User> getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(Set<User> user) {
		this.user = user;
	}

	/**
	 * Gets the posts.
	 *
	 * @return the posts
	 */
	public Set<Posts> getPosts() {
		return posts;
	}

	/**
	 * Sets the posts.
	 *
	 * @param posts the new posts
	 */
	public void setPosts(Set<Posts> posts) {
		this.posts = posts;
	}
	
	
	
}
