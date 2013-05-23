package com.neo.trainer.model.onlinetest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.neo.trainer.serviceimp.helper.Upload;

// TODO: Auto-generated Javadoc  
/**
 * The Class Candidate.
 */
@Entity
@Table(name = "Candidate")
public class Candidate implements Upload{

	/** The cand id. */
	@Id
	@GeneratedValue
	@Column(name = "CandId")
	private Integer candId;

	/** The cand name. */
	@Column(name = "CandName")
	private String candName;

	/** The password. */
	@Column(name = "Password")
	private String password;

	@Transient
	private String rePassword;

	/** The email. */
	@Column(name = "email")
	private String email;

	/** The authority. */
	@Column(name = "Authority")
	private String authority;

	@Transient
	private String groupName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/** The authority. */
	@Column(name = "Enabled")
	private int enabled;

	@Column(name = "Experience")
	private float experience;

	@Transient
	private String experienceYY;

	@Column(name = "CreatedDate")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date createdDate;

	@Transient
	private String experienceMM;

	public String getExperienceYY() {
		return experienceYY;
	}

	public void setExperienceYY(String experienceYY) {
		this.experienceYY = experienceYY;
	}

	public String getExperienceMM() {
		return experienceMM;
	}

	public void setExperienceMM(String experienceMM) {
		this.experienceMM = experienceMM;
	}

	@Column(name = "CurrentCTC")
	private float ctc;
	
	@Column(name = "ExpectedCTC")
	private float exctc;

	@Column(name = "Location")
	private String location;

	@Column(name = "Phone")
	private String phone;

	@Transient
	private CommonsMultipartFile fileData;

	@Column(name = "Resume")
	private String resume;
	
	@Transient
	private String questSet;

	/** The Cand group. */
	@ManyToOne
	// Many candidates to one Group
	@JoinColumn(name = "GroupId")
	private Group1 CandGroup;

	// One candidate to many results
	/** The result. */
	@OneToMany(mappedBy = "candidate")
	private Set<Results> result;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + candName;
	}

	/**
	 * Gets the cand id.
	 * 
	 * @return the cand id
	 */
	public Integer getCandId() {
		return candId;
	}

	/**
	 * Sets the cand id.
	 * 
	 * @param candId
	 *            the new cand id
	 */
	public void setCandId(Integer candId) {
		this.candId = candId;
	}

	/**
	 * Gets the cand name.
	 * 
	 * @return the cand name
	 */
	public String getCandName() {
		return candName;
	}

	/**
	 * Sets the cand name.
	 * 
	 * @param candName
	 *            the new cand name
	 */
	public void setCandName(String candName) {
		this.candName = candName;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the group id.
	 * 
	 * @return the group id
	 */
	public Group1 getGroupId() {
		return CandGroup;
	}

	/**
	 * Sets the group id.
	 * 
	 * @param groupId
	 *            the new group id
	 */
	public void setGroupId(Group1 groupId) {
		this.CandGroup = groupId;
	}

	/**
	 * Gets the cand group.
	 * 
	 * @return the cand group
	 */
	public Group1 getCandGroup() {
		return CandGroup;
	}

	/**
	 * Sets the cand group.
	 * 
	 * @param candGroup
	 *            the new cand group
	 */
	public void setCandGroup(Group1 candGroup) {
		CandGroup = candGroup;
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
	 * @param result
	 *            the new result
	 */
	public void setResult(Set<Results> result) {
		this.result = result;
	}

	/**
	 * Gets the authority.
	 * 
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * Sets the authority.
	 * 
	 * @param authority
	 *            the new authority
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public float getExperience() {
		
		return experience;
	}

	public void setExperience(float experience) {
		experience = Float.parseFloat(getExperienceYY() + "."
				+ getExperienceMM()); 
		this.experience = experience;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public float getCtc() {
		return ctc;
	}

	public void setCtc(float ctc) {
		this.ctc = ctc;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

	public String getQuestSet() {
		return questSet;
	}

	public void setQuestSet(String questSet) {
		this.questSet = questSet;
	}

	public float getExctc() {
		return exctc;
	}

	public void setExctc(float exctc) {
		this.exctc = exctc;
	}
	

	
	
	
}
