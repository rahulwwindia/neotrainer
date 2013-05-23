package com.neo.trainer.model.blog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

// TODO: Auto-generated Javadoc
/**
 * The Class Editor.
 */
@Entity
@Table(name = "editor")
public class Editor implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = "id")	
	@GeneratedValue
	private Integer id;
		
	/** The name. */
	@Column(name = "name")		
	@Size(min=3,max=20,message="size must be between 3 and 20")	
	private String name;
		
	/** The email id. */
	@Column(name = "emailId")	
	@NotEmpty(message="may not be empty")
	@Email(message="must be valid EmailId")	
	private String emailId;
	
	/** The editor text. */
	@Column(name = "editorText")
	@Lob
	@NotEmpty(message="enter some text")
	@Size(min=30,message="body must be atleast 30 characters")
	private String editorText;		
	
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
	 * @param name the new name
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
	 * @param emailId the new email id
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
	 * @param editorText the new editor text
	 */
	public void setEditorText(String editorText) {
		this.editorText = editorText;
	}

}