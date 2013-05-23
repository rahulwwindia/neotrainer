package com.neo.trainer.service.admin.demoapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neo.trainer.model.demoApp.DemoTechnology;
import com.neo.trainer.model.demoApp.UploadDemoApp;

public interface DemoAppServiceAdmin {
	
	public void uploadDemoApp(UploadDemoApp uploadDemoApp,HttpServletRequest request);
	public void addDemoTech(String demoTech);
	public List<DemoTechnology> getDemoAppTech();
	
}
