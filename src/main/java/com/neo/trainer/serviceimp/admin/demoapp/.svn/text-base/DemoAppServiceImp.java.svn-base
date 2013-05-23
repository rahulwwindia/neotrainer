package com.neo.trainer.serviceimp.admin.demoapp;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.demoApp.DemoTechnology;
import com.neo.trainer.model.demoApp.UploadDemoApp;
import com.neo.trainer.service.admin.demoapp.DemoAppServiceAdmin;
import com.neo.trainer.serviceimp.helper.UploadFileHelper;

@Service("demoAppServiceAdmin")
public class DemoAppServiceImp implements DemoAppServiceAdmin {

	@Autowired
	private HibernateTemplate hibernateTemplate;
  
	public void uploadDemoApp(UploadDemoApp uploadDemoApp,
			HttpServletRequest request) {   
	         
		File f=new File(request.getRealPath(".")+"/resources/demoapp/"+uploadDemoApp.getTechName().toLowerCase()+"demoapp");  
 		if (!f.isDirectory())
  			f.mkdir();  
	String path = "/resources/demoapp/"+uploadDemoApp.getTechName().toLowerCase()+"demoapp/"+uploadDemoApp.getFileData().getOriginalFilename(); 
	System.out.println("Demo app:"+path);          	
	UploadFileHelper.uploadFile(uploadDemoApp, path,request); 
	List<DemoTechnology> demoList= hibernateTemplate.find("from DemoTechnology where demoTechName='"+uploadDemoApp.getTechName()+"'");
		uploadDemoApp.setFileName(uploadDemoApp.getFileData().getOriginalFilename());      
		uploadDemoApp.setDemoTechnology(demoList.get(0));    
	
		hibernateTemplate.save(uploadDemoApp);    
                       
	} 
 
	public void addDemoTech(String demoTech) {
		// TODO Auto-generated method stub
		DemoTechnology tech = new DemoTechnology();
		tech.setDemoTechName(demoTech);
		hibernateTemplate.save(tech);
	}

	public List<DemoTechnology> getDemoAppTech() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from DemoTechnology");   
	}    
	
	
}
  