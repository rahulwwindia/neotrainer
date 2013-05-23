package com.neo.trainer.model.deshboard;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Dashboard")
public class Dashboard {
	 
	@Id
	@GeneratedValue
	@Column(name = "DashId")
	private Integer dashId; 

	public Integer getDashId() {
		return dashId;
	}

	public void setDashId(Integer dashId) {
		this.dashId = dashId;
	}

	public String getDashOption() {
		return dashOption;
	}

	public void setDashOption(String dashOption) {
		this.dashOption = dashOption;
	}
  
	@NotEmpty
	@Column(name = "DashOption")
	private String dashOption;
	
}
 