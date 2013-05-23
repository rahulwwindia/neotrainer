package com.neo.trainer.model.demoApp;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DemoTechnology")
public class DemoTechnology {
	   
	/** The post id. */
	@Id
	@GeneratedValue  
	@Column(name = "DemoTechId")
	private Integer demoTechId;
	
	@Column(name = "DemoTechName")
	private String demoTechName; 
	
	public Integer getDemoTechId() {
		return demoTechId;
	}  

	public void setDemoTechId(Integer demoTechId) {
		this.demoTechId = demoTechId;
	}

	public String getDemoTechName() {
		return demoTechName;
	}

	public void setDemoTechName(String demoTechName) {
		this.demoTechName = demoTechName; 
	}

	public Set<UploadDemoApp> getUploadDemoApps() {
		return uploadDemoApps;
	}

	public void setUploadDemoApps(Set<UploadDemoApp> uploadDemoApps) {
		this.uploadDemoApps = uploadDemoApps;
	}
 
	/** The comment. */ 
	@OneToMany(mappedBy = "demoTechnology")
	private Set<UploadDemoApp> uploadDemoApps;
	

}
