package com.neo.trainer.model.admin;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TechTutorial")
public class TechTutorial {
	  
	@Id
	@GeneratedValue
	@Column(name = "TutorialId")
	private Integer tutorialId; 
	 
	@ManyToOne
    @JoinColumn(name="TechId")
	private Technologies technologies;
	
	 
	@Column(name = "TutorialName")
	private String tutorialName;
	
	
	@Column(name = "Disable")
	private int disable; 
 
	@OneToMany(mappedBy = "techTutorial", fetch = FetchType.EAGER)
	private Set<TutorialImages> tutorialImages;
	         
	
	public Set<TutorialImages> getTutorialImages() {
		return tutorialImages;
	}

	public void setTutorialImages(Set<TutorialImages> tutorialImages) {
		this.tutorialImages = tutorialImages;
	}

	public int getTutorialId() { 
		return tutorialId;
	}

	public void setTutorialId(int tutorialId) {
		this.tutorialId = tutorialId;
	}

	public String getTutorialName() {
		return tutorialName;
	}

	public void setTutorialName(String tutorialName) {
		this.tutorialName = tutorialName;
	}

	
	public int getDisable() {  
		return disable;
	}

	public void setDisable(int disable) {
		this.disable = disable;
	}
  
	public Technologies getTechnologies() {
		return technologies;
	}

	public void setTechnologies(Technologies technologies) {
		this.technologies = technologies;
	}

	

}
