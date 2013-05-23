package com.neo.trainer.model.article;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

// TODO: Auto-generated Javadoc
/**
 * ViewArticle model represents comments on an article which can be viewed.
 *
 * @author webwerks
 */

@Entity
@Table(name = "viewArticle")
public class ViewArticle implements Serializable {

	/** class for an article consists comments on the article. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	/** The comment by. */
	@Column(name = "commentBy")
	@Size(min = 3, max = 20, message = "size must be between 3 and 20")
	private String commentBy;

	/** The comment by email id. */
	@Column(name = "commentByEmailId")
	@NotEmpty(message = "may not be empty")
	@Email(message = "must be valid EmailId")
	private String commentByEmailId;

	/** The post comment. */
	@Column(name = "postComment")
	@Lob
	@NotEmpty(message = "enter some text")
	private String postComment;

	/** The date. */
	@Column(name = "commentDate")
	@DateTimeFormat
	private Date date;

	/** The fk article. */
	@ManyToOne()
	@JoinColumn(name = "articleId")
	private Article fkArticle;
 
	/** 
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the comment by.
	 *
	 * @return the comment by
	 */
	public String getCommentBy() {
		return commentBy;
	}

	/**
	 * Sets the comment by.
	 *
	 * @param commentBy the new comment by
	 */
	public void setCommentBy(String commentBy) {
		this.commentBy = commentBy;
	}

	/**
	 * Gets the comment by email id.
	 *
	 * @return the comment by email id
	 */
	public String getCommentByEmailId() {
		return commentByEmailId;
	}

	/**
	 * Sets the comment by email id.
	 *
	 * @param commentByEmailId the new comment by email id
	 */
	public void setCommentByEmailId(String commentByEmailId) {
		this.commentByEmailId = commentByEmailId;
	}

	/**
	 * Gets the post comment.
	 *
	 * @return the post comment
	 */
	public String getPostComment() {
		return postComment;
	}

	/**
	 * Sets the post comment.
	 *
	 * @param postComment the new post comment
	 */
	public void setPostComment(String postComment) {
		this.postComment = postComment;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the fk article.
	 *
	 * @return the fk article
	 */
	public Article getFkArticle() {
		return fkArticle;
	}

	/**
	 * Sets the fk article.
	 *
	 * @param fkArticle the new fk article
	 */
	public void setFkArticle(Article fkArticle) {
		this.fkArticle = fkArticle;
	}

}
