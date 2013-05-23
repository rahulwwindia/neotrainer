package com.neo.trainer.model.article;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

// TODO: Auto-generated Javadoc
/** 
 * Article model represents article posted. 
 * 
 * @author webwerks
 */
@Entity
@Table(name = "article")
public class Article implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	/** The name. */
	@Column(name = "name")
	private String name;

	/** The email id. */
	@Column(name = "emailId") 
	private String emailId;
  
	/** The editor text. */
	@Column(name = "editorText")
	@Lob  
	@NotEmpty(message = "enter some text") 
	private String editorText;

	/** The title. */
	@Column(name = "title", unique = true)
	@NotEmpty(message = "enter title")
	private String title;

	/** The article type. */
	@Column(name = "articleType")  
	private String articleType;
 
	/** The date. */
	@Column(name = "articleDate")
	@DateTimeFormat
	private Date date;

	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", emailId=" + emailId
				+ ", editorText=" + editorText + ", title=" + title
				+ ", articleType=" + articleType + ", date=" + date
				+ ", viewArticle=" + viewArticle + "]";
	}

	/** The view article. */

	@OneToMany(mappedBy = "fkArticle",fetch = FetchType.EAGER) 
	private Set<ViewArticle> viewArticle;

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
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the email id.
	 * 
	 * @return the email id
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Sets the email id.
	 * 
	 * @param emailId
	 *            the new email id
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Gets the editor text.
	 * 
	 * @return the editor text
	 */
	public String getEditorText() {
		return editorText;
	}

	/**
	 * Sets the editor text.
	 * 
	 * @param editorText
	 *            the new editor text
	 */
	public void setEditorText(String editorText) {
		this.editorText = editorText;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the article type.
	 * 
	 * @return the article type
	 */
	public String getArticleType() {
		return articleType;
	}

	/**
	 * Sets the article type.
	 * 
	 * @param articleType
	 *            the new article type
	 */
	public void setArticleType(String articleType) {
		this.articleType = articleType;
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
	 * @param date
	 *            the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the view article.
	 * 
	 * @return the view article
	 */
	public Set<ViewArticle> getViewArticle() {
		return viewArticle;
	}

	/**
	 * Sets the view article.
	 * 
	 * @param viewArticle
	 *            the new view article
	 */
	public void setViewArticle(Set<ViewArticle> viewArticle) {
		this.viewArticle = viewArticle;
	}

}
