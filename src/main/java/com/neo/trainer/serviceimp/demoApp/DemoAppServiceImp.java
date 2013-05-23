package com.neo.trainer.serviceimp.demoApp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.demoApp.DemoTechnology;
import com.neo.trainer.model.demoApp.UploadDemoApp;

import com.neo.trainer.service.demoApp.DemoAppService;
@Service("demoAppService")
public class DemoAppServiceImp implements DemoAppService{
	 
	@Autowired
	HibernateTemplate hibernateTemplate;

	public List<UploadDemoApp> getDemoApp(String app) {
		  
		List<DemoTechnology> techId = hibernateTemplate.find("from DemoTechnology where DemoTechName='"+app+"'");
		List<UploadDemoApp> demoApps = hibernateTemplate.find("from UploadDemoApp where DemoTechId="+techId.get(0).getDemoTechId()); 
		return demoApps; 
	}      

	
	  
}
 