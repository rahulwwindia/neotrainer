package com.neo.trainer.model.blog;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.neo.trainer.model.login.User;

// TODO: Auto-generated Javadoc
/**
 * The Class Comments.
 */
@Entity
@Table(name = "Comments")
public class Comments{

	/** The comm id. */
	@Id
	@GeneratedValue
	@Column(name = "CommId")
	private Integer commId;
	
	/** The comm content. */
	@NotEmpty
	@Column(name = "CommContent")
	@Lob
	private String commContent;
	
	/** The comm date. */
	@Column(name = "CommDate")
	private Date commDate;
	
	/** The ip address. */
	@Column(name = "IpAddress")
	private String ipAddress;
	
	/** The post comm. */
	@ManyToOne
	// Many comments to one post
	@JoinColumn(name = "PostId")
	private Posts postComm;

	/** The com user. */
	@ManyToOne
	// Many comments to one User
	@JoinColumn(name = "UserId")
	private User comUser;

	/**
	 * Gets the comm id.
	 *
	 * @return the comm id
	 */
	public Integer getCommId() {
		return commId;
	}

	/**
	 * Sets the comm id.
	 *
	 * @param commId the new comm id
	 */
	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	/**
	 * Gets the comm content.
	 *
	 * @return the comm content
	 */
	public String getCommContent() {
		return commContent;
	}

	/**
	 * Sets the comm content.
	 *
	 * @param commContent the new comm content
	 */
	public void setCommContent(String commContent) {
		this.commContent = commContent;
	}

	/**
	 * Gets the comm date.
	 *
	 * @return the comm date
	 */
	public Date getCommDate() {
		return commDate;
	}

	/**
	 * Sets the comm date.
	 *
	 * @param commDate the new comm date
	 */
	public void setCommDate(Date commDate) {
		this.commDate = commDate;
	}

	/**
	 * Gets the ip address.
	 *
	 * @return the ip address
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Sets the ip address.
	 *
	 * @param ipAddress the new ip address
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Gets the post comm.
	 *
	 * @return the post comm
	 */
	public Posts getPostComm() {
		return postComm;
	}

	/**
	 * Sets the post comm.
	 *
	 * @param postComm the new post comm
	 */
	public void setPostComm(Posts postComm) {
		this.postComm = postComm;
	}

	/**
	 * Gets the com user.
	 *
	 * @return the com user
	 */
	public User getComUser() {
		return comUser;
	}

	/**
	 * Sets the com user.
	 *
	 * @param comUser the new com user
	 */
	public void setComUser(User comUser) {
		this.comUser = comUser;
	}

/*	@Override
	public int compareTo(Comments arg0) {
		// TODO Auto-generated method stub
		int a=this.getCommId()-arg0.getCommId();
		return a;
	}*/
	
	
}
