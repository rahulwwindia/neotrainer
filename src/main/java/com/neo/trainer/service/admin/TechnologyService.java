package com.neo.trainer.service.admin;

import java.util.List;

import com.neo.trainer.model.admin.Technologies;

public interface TechnologyService {

	public void addTechnology(Technologies tech);

	public List<Technologies> getTechnologies();
	
	
}
