package com.neo.trainer.controllers.admin.onlinetest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neo.trainer.model.onlinetest.Candidate;
import com.neo.trainer.model.onlinetest.Results;
import com.neo.trainer.model.onlinetest.SearchResult;
import com.neo.trainer.service.onlinetest.ResultService;

@Controller
public class ResultController {
	
	@Autowired
	private ResultService resultService;
	
	@RequestMapping(value = "/viewResult.htm", method = RequestMethod.GET)
	public String viewResult(Model model)
	{  
		
		model.addAttribute("range", new SearchResult());
		return "viewResult"; 
	}   
	@RequestMapping(value = "/getResult.htm", method = RequestMethod.POST)
	public String getResult(@ModelAttribute("range") SearchResult range , Model model)
	{
		List<Results> results= resultService.getResult(range);
		System.out.println("result:"+results);  
		model.addAttribute("result",results);
	return "getResult";	 
	} 
  
 }
