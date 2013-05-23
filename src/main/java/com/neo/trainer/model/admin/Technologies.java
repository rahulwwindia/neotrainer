package com.neo.trainer.model.admin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Technologies")
public class Technologies {
	
	@Id
	@Column(name = "TechId")
	@GeneratedValue
	private int techId;

	@Column(name = "TechnologyName")
	private String technologyName;
	
	@OneToMany
	private Set<TechTutorial> techTutorials;
	
	  
	
	public Set<TechTutorial> getTechTutorials() {
		return techTutorials;
	}

	public void setTechTutorials(Set<TechTutorial> techTutorials) {
		this.techTutorials = techTutorials;
	}

	public int getTechId() {
		return techId;
	}

	public void setTechId(int techId) {
		this.techId = techId;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	@Override
	public String toString() {
		return "Technologies [techId=" + techId + ", technologyName="
				+ technologyName + ", getTechId()=" + getTechId()
				+ ", getTechnologyName()=" + getTechnologyName() + "]";
	}

}
