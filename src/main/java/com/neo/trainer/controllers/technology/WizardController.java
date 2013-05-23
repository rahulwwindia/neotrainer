package com.neo.trainer.controllers.technology;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neo.trainer.model.admin.TutorialImages;
import com.neo.trainer.serviceimp.technology.WizardServiceImpl;

@Controller
public class WizardController 
{
	
	@Autowired 
	private WizardServiceImpl WizSerImpl;
	
	
	
	@RequestMapping(value = "/DisplayWizard.htm", method = RequestMethod.GET)
	public String app(Model model, HttpServletRequest request) {
		
		String tutoName=request.getParameter("tutoName");
		String techName=request.getParameter("techName");

	System.out.println("TUTO NAME IS "+ tutoName );

	System.out.println("TECHNO NAME IS "+ techName );
		
List<TutorialImages> tutImgList=WizSerImpl.getWizardData(techName, tutoName);
		int size=tutImgList.size();
		System.out.println("The Size of The Tutorial List Is  tutImgList ::: "+tutImgList.size() );
	  model.addAttribute("size", size);
	  model.addAttribute("ImgList", tutImgList);
	  
		return "wizard";
	}
		
	
}
