package com.neo.trainer.model.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.serviceimp.helper.Upload;

// TODO: Auto-generated Javadoc
/**
 * The Class TutorialImages.
 */
@Entity
@Table(name = "TutorialImages")
public class TutorialImages implements Upload {
	
	/** The data id. */
	@Id
	@GeneratedValue
	@Column(name = "DataId")
	private int dataId;
	@Override
	public String toString() {
		return "TutorialImages [dataId=" + dataId + ", imageName=" + imageName
				+ ", imageDescription=" + imageDescription + ", techTutorial="
				+ techTutorial + ", pointer=" + pointer + ", fileData="
				+ fileData + "]";
	}

	/** The comm content. */  
  
	
	@Column(name = "ImageName")
	private String imageName;

	
	    
	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

	/** The image description. */
	@NotEmpty
	@Column(name = "ImageDescription")
	private String imageDescription;

	/** The tutorial id. */
	@ManyToOne
	@JoinColumn(name = "TutorialId")
	private TechTutorial techTutorial;
  

	/** The pointer. */
	@Column(name = "Pointer") 
	private int pointer;

	@Transient
	private CommonsMultipartFile fileData;

	 
	/**
	 * Gets the data id.
	 *
	 * @return the data id
	 */
	public int getDataId() {
		return dataId;
	}
 
	/**
	 * Sets the data id.
	 *
	 * @param dataId the new data id
	 */
	public void setDataId(int dataId) {
		this.dataId = dataId;
	}

	/**
	 * Gets the image name.
	 *
	 * @return the image name
	 */
	public String getImageName() {
		return imageName;
	}

	/**
	 * Sets the image name.
	 *
	 * @param imageName the new image name
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	/**
	 * Gets the image description.
	 *
	 * @return the image description
	 */
	public String getImageDescription() {
		return imageDescription;
	}

	/**
	 * Sets the image description.
	 *
	 * @param imageDescription the new image description
	 */
	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}

	

	
	

	
	public TechTutorial getTechTutorial() {
		return techTutorial;
	}

	public void setTechTutorial(TechTutorial techTutorial) {
		this.techTutorial = techTutorial;
	}

	/**
	 * Gets the pointer.
	 *
	 * @return the pointer
	 */
	public int getPointer() {
		return pointer;
	}

	/**
	 * Sets the pointer.
	 *
	 * @param pointer the new pointer
	 */
	public void setPointer(int pointer) {
		this.pointer = pointer;
	}

}
