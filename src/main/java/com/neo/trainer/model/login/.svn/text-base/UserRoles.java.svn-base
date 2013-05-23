package com.neo.trainer.model.login;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The Class UserRoles.
 */
@Entity
@Table(name = "UserRoles")
public class UserRoles {

	/** The user role id. */
	@Id
	@GeneratedValue
	@Column(name = "User_Role_Id")
	private Integer userRoleId;

	/** The authority. */
	@Column(name = "Authority")
	private String authority;
	
	/** The user. */
	@ManyToMany(mappedBy="userRoles", fetch = FetchType.EAGER)
    private Set<User> user = new HashSet<User>();

	/**
	 * Gets the user role id.
	 *
	 * @return the user role id
	 */
	public Integer getUserRoleId() {
		return userRoleId;
	}

	/**
	 * Sets the user role id.
	 *
	 * @param userRoleId the new user role id
	 */
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
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
	 * @param authority the new authority
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
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
	
	
}
