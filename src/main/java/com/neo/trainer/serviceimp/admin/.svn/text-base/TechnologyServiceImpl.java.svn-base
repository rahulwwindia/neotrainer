package com.neo.trainer.serviceimp.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.admin.TechTutorial;
import com.neo.trainer.model.admin.Technologies;
import com.neo.trainer.service.admin.TechnologyService;
import com.neo.trainer.serviceimp.blog.BlogCommentServiceImpl;

@Service("techSerImpl")
public class TechnologyServiceImpl implements TechnologyService

{
	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(TechnologyServiceImpl.class);
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private TechTutorialServiceImpl techTuteServImp;
	
	/** The hibernate template. */
	private HibernateTemplate hibernateTemplate = null;

	// private SessionFactory sessionFactory;
	public void addTechnology(Technologies techobj)
	{
		System.out.println("*********** IN ADD TECH ***************");
		log.info("In Technology SAVE ***************");
		
		hibernateTemplate.saveOrUpdate(techobj);

	}

	public List<Technologies> getTechnologies() {
		try {
			hibernateTemplate = new HibernateTemplate(sessionFactory);
			log.info("sessionFactory : " + sessionFactory);
			List<Technologies> listTech = (List<Technologies>)hibernateTemplate
					.find("from Technologies");
			log.info("IN THE GETTECHNOLOGIES !!!!!!!!! " + listTech);
			System.out.println("Technologies: "+listTech);
			return listTech;
		} catch (Exception e) {
			log.error("Exception caught in getTechnologies.." + e);
		}

		/*
		 * return
		 * sessionFactory.getCurrentSession().createQuery("from Technology")
		 * .list();
		 */

		return null;
	}

	public void addTechnology(String techName) {
		// TODO Auto-generated method stub
		
	}

	
	public HashMap<String, ArrayList<TechTutorial>> getTechNTuteMAp()
	{
		
	 ArrayList<Technologies> TechList=(ArrayList) getTechnologies();
	 log.info("The value of TechList"+ TechList);
		HashMap<String,ArrayList<TechTutorial>> map = new HashMap<String, ArrayList<TechTutorial>>();
		
		
		for(Technologies Tlogy:TechList)
		{
			String Tname = Tlogy.getTechnologyName();
			ArrayList<TechTutorial> TutList =(ArrayList) techTuteServImp.getTechTurorial(Tname);
			 
			map.put(Tname, TutList) ;
		}
		
		
		return map;
	}  
	
}
