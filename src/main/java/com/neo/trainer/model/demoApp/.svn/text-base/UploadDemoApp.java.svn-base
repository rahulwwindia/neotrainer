package com.neo.trainer.model.demoApp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.neo.trainer.model.onlinetest.Questions;
import com.neo.trainer.serviceimp.helper.Upload;

// TODO: Auto-generated Javadoc 
/**
 * The Class UploadDemoApp.
 */ 
@Entity
@Table(name = "DemoApp")
public class UploadDemoApp implements Upload {
 
	/** The file name. */

	/** The comm id. */
	@Id 
	@GeneratedValue
	@Column(name = "DemoId")
	private Integer demoId;

	@NotEmpty
	@Column(name = "FileName")
	private String fileName;

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	} 

	public DemoTechnology getDemoTechnology() {
		return demoTechnology;
	}

	public void setDemoTechnology(DemoTechnology demoTechnology) {
		this.demoTechnology = demoTechnology;
	}

	
	/** The description. */
	@Transient
	private String techName;  
	
	@Column(name = "Description")
	private String description;
  
	@ManyToOne
	// Many options to one Question
	@JoinColumn(name = "DemoTechId")
	private DemoTechnology demoTechnology;
	

	public Integer getDemoId() {
		return demoId;
	}

	public void setDemoId(Integer demoId) {
		this.demoId = demoId;
	}

	
	/** The file data. */
	@Transient
	private CommonsMultipartFile fileData;

	/** 
	 * Gets the file name.
	 * 
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the file name.
	 * 
	 * @param fileName
	 *            the new file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
   
	/**
	 * Gets the file data.
	 * 
	 * @return the file data
	 */
	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	/**
	 * Sets the file data.
	 * 
	 * @param fileData
	 *            the new file data
	 */
	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

}
