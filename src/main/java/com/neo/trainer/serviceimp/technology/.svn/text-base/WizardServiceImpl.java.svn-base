package com.neo.trainer.serviceimp.technology;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.admin.TechTutorial;
import com.neo.trainer.model.admin.Technologies;
import com.neo.trainer.model.admin.TutorialImages;
import com.neo.trainer.service.technology.WizardService;

@Service
public class WizardServiceImpl implements WizardService {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<TutorialImages> getWizardData(String TechName,
			String TutName) {
		
//		List qry = hibernateTemplate.find("SELECT a.imageName,a.imageDescription" +
//				" FROM TutorialImages a , TechTutorial" +
//				"  b, Technologies c where a.techTutorial=b.tutorialId " +
//				"and b.technologies=c.techId and c.technologyName='Hadoop' and b.tutorialName='Limo'");
//	              
		List<Technologies> techlogies=hibernateTemplate.find("from Technologies where technologyName='"+TechName+"'");  
		 int techID= techlogies.get(0).getTechId();
		 System.out.println("The TechId Is  : " +techID);
		List<TechTutorial> techTutorials=hibernateTemplate.find("from TechTutorial where tutorialName='"+TutName+"' and techId='"+techID+"'");
		 int tutoId= techTutorials.get(0).getTutorialId();
		 System.out.println("THE TUTO ID IS " +tutoId);
		List<TutorialImages> tuteImages= hibernateTemplate
				.find("from TutorialImages where techTutorial="+tutoId);
		
		  
		     
//		   Iterator it = qry.iterator();
//		while(it.hasNext())
//		{    
//		
//			
//		   System.out.println("--11--"+it.next().toString());
//	         
//		}   
		return tuteImages;   
	}        
}
 