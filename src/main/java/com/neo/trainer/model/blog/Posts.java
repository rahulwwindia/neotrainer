package com.neo.trainer.model.blog;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.neo.trainer.model.login.User;
import com.neo.trainer.model.onlinetest.Group1;

// TODO: Auto-generated Javadoc
/**
 * The Class Posts.
 */
@Entity
@Table(name = "Posts")
public class Posts {

	/** The post id. */
	@Id
	@GeneratedValue
	@Column(name = "PostId")
	private Integer postId;

	/** The post title. */
	@Column(name = "PostTitle")
	private String postTitle;

	/** The post content. */
	@NotEmpty
	@Column(name = "PostContent")
	@Lob
	private String postContent;

	/** The post date. */
	@Column(name = "PostDate")
	private Date postDate;

	/** The ip address. */
	@Column(name = "IpAddress")
	private String ipAddress;

	/** The user. */
	@ManyToOne
	// Many posts to one User
	@JoinColumn(name = "UserId")
	private User user;

	/** The comment. */
	@OneToMany(mappedBy = "postComm", fetch = FetchType.EAGER)
	private Set<Comments> comment;
	
	/** The group post. */
	@ManyToOne
	// Many posts to one Group
	@JoinColumn(name = "GroupId")
	private Group1 groupPost;

	/**
	 * Gets the post id.
	 *
	 * @return the post id
	 */
	public Integer getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the new post id
	 */
	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	/**
	 * Gets the post content.
	 *
	 * @return the post content
	 */
	public String getPostContent() {
		return postContent;
	}

	/**
	 * Sets the post content.
	 *
	 * @param postContent the new post content
	 */
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	/**
	 * Gets the post date.
	 *
	 * @return the post date
	 */
	public Date getPostDate() {
		return postDate;
	}

	/**
	 * Sets the post date.
	 *
	 * @param postDate the new post date
	 */
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
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
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public Set<Comments> getComment() {
		return comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(Set<Comments> comment) {
		this.comment = comment;
	}

	/**
	 * Gets the post title.
	 *
	 * @return the post title
	 */
	public String getPostTitle() {
		return postTitle;
	}

	/**
	 * Sets the post title.
	 *
	 * @param postTitle the new post title
	 */
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	/**
	 * Gets the group post.
	 *
	 * @return the group post
	 */
	public Group1 getGroupPost() {
		return groupPost;
	}

	/**
	 * Sets the group post.
	 *
	 * @param groupPost the new group post
	 */
	public void setGroupPost(Group1 groupPost) {
		this.groupPost = groupPost;
	}
	
}
