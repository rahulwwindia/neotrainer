package com.neo.trainer.model.login;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.neo.trainer.model.blog.Comments;
import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.model.onlinetest.Group1;
import com.neo.trainer.model.onlinetest.QuestionSet;
import com.neo.trainer.model.onlinetest.Questions;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name = "User")
public class User {

	/** The user id. */
	@Id
	@GeneratedValue
	@Column(name = "UserId")
	private Integer userId;

	/** The user name. */
	@Column(name = "UserName")
	private String userName;

	/** The password. */
	@Column(name = "Password")
	private String password;
	
	@Transient
	private String rePassword;
	
	/** The authority. */
	@Column(name = "Enabled")
	private int enabled;

	/** The email. */
	@Column(name = "email")
	private String email;
	
	@Column(name = "Phone")
	private String phone;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "CreatedDate")
	private Date crDate;

	/** The group user. */
	@ManyToOne
	// Many users to one group
	@JoinColumn(name = "GroupId")
	private Group1 groupUser;

	/** The posts. */
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<Posts> posts;

	/** The comments. */ 
	@OneToMany(mappedBy = "comUser", fetch = FetchType.EAGER)
	private Set<Comments> comments;
	
	/** The user roles. */
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "User_UserRoles", joinColumns = { @JoinColumn(name = "UserId") }, inverseJoinColumns = { @JoinColumn(name = "User_Role_Id") })
	private Set<UserRoles> userRoles = new HashSet<UserRoles>();

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + userName + "";
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
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

	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	public Set<Comments> getComments() {
		return comments;
	}

	/**
	 * Sets the comments.
	 *
	 * @param comments the new comments
	 */
	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}

	/**
	 * Gets the group user.
	 *
	 * @return the group user
	 */
	public Group1 getGroupUser() {
		return groupUser;
	}

	/**
	 * Sets the group user.
	 *
	 * @param groupUser the new group user
	 */
	public void setGroupUser(Group1 groupUser) {
		this.groupUser = groupUser;
	}

	/**
	 * Gets the user role.
	 *
	 * @return the user role
	 */
	public Set<UserRoles> getUserRole() {
		return userRoles;
	}

	/**
	 * Sets the user role.
	 *
	 * @param userRoles the new user role
	 */
	public void setUserRole(Set<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Set<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCrDate() {
		return crDate;
	}

	public void setCrDate(Date crDate) {
		this.crDate = crDate;
	}

}
