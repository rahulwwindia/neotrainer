package com.neo.trainer.serviceimp.admin;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.admin.TechTutorial;
import com.neo.trainer.model.admin.Technologies;
import com.neo.trainer.service.admin.TechTutorialService;

@Service("techTuteSerImpl")
public class TechTutorialServiceImpl implements TechTutorialService {

	/**
	 * @param args
	 * 
	 */

	private static final Logger log = Logger
			.getLogger(TechnologyServiceImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired 
	private HibernateTemplate hibernateTemplate;
	public void addTechTutorial(TechTutorial techTute)
	{
		System.out.println("*********** IN ADD TECH_TUTE ***************");
		log.info("In Technology SAVE ***************");
		
		hibernateTemplate.saveOrUpdate(techTute);
		
		
	}

	

	public List<TechTutorial> getTechTurorial(String techName) {
		List<TechTutorial> listTechTut=null;
		try{
		  
			System.out.println("TechName: "+techName); 
			log.info("sessionFactory : " + sessionFactory);
			
			List<Technologies> technologies=(List<Technologies>) hibernateTemplate
			.find("from Technologies where technologyName=?",techName );
			if(technologies!=null)
			{   
				listTechTut = (List<TechTutorial>)hibernateTemplate
					.find("from TechTutorial where TechId=?",technologies.get(0).getTechId() );
			System.out.println("#########Technologies: "+listTechTut.get(0));
			 
			}  
	     	}
		catch(Exception e)
		{
			log.error(e);
		}
		return listTechTut;
	}
	
	
	public boolean getTurorialExist (String tutorialName, String technologyName) {
		boolean exists=false;
		try{
		  
			System.out.println("tutorialName: "+tutorialName); 
			System.out.println("technologyName: "+technologyName); 
			log.info("sessionFactory : " + sessionFactory);
			
			List<Technologies> technologies=(List<Technologies>) hibernateTemplate
					.find("from Technologies where technologyName='"+technologyName+"'" );
			
			
			 System.out.println("TechId By Tech = "+technologies.get(0).getTechId());
			List<TechTutorial>	listTechTut = (List<TechTutorial>)hibernateTemplate
					.find("from TechTutorial where tutorialName='"+tutorialName+"' and techId='"+technologies.get(0).getTechId()+"'" );
			
			if(listTechTut.isEmpty())
			
			{
				exists= false;
				
			}
			else
			{
				
				exists=true;
			}
		
	     	}
		catch(Exception e)
		{
			log.error(e);
		}
		System.out.println("The Value alread exist ? " +exists);
	return exists;
	}
	

}
