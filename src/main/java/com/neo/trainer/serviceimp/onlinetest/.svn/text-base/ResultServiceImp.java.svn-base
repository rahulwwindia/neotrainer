package com.neo.trainer.serviceimp.onlinetest;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.onlinetest.Candidate;
import com.neo.trainer.model.onlinetest.Group1;
import com.neo.trainer.model.onlinetest.Results;
import com.neo.trainer.model.onlinetest.SearchResult;
import com.neo.trainer.service.onlinetest.ResultService;

@Service
public class ResultServiceImp implements ResultService{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	public List<Results> getResult( SearchResult range) {
		DateFormat formatter ; 
		 Format format;
		 List<Results> results=null;
		 Date date1,date2 ; 
		 String fromDate=null,toDate=null;
		  formatter = new SimpleDateFormat("MM/dd/yyyy");
		  try {
			  
			date1 = (Date)formatter.parse(range.getFromDate());
			date2 = (Date)formatter.parse(range.getToDate());
		  
			  // 01/09/02
			format = new SimpleDateFormat("yyyy-MM-dd");
			fromDate = format.format(date1);
			  toDate = format.format(date2);
			  System.out.println("fromDate :"+fromDate); 
			  System.out.println("toDate :"+toDate); 
			     
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	
		List<Group1> group1s= hibernateTemplate.find("from Group1 where groupName='"+range.getGroup()+"'");
		if(fromDate!=null) 
		{  
			results = hibernateTemplate.find("from Results rs where rs.examDate >'"+fromDate+"' and rs.examDate <'"+toDate+"' and groupId="+group1s.get(0).getGroupId());
		}
		else
			results = hibernateTemplate.find("from Results rs where groupId="+group1s.get(0).getGroupId());
		return results;  
	} 
	
	
 
}
  