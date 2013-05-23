package com.neo.trainer.controllers.admin.demoapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neo.trainer.model.demoApp.DemoTechnology;
import com.neo.trainer.model.demoApp.UploadDemoApp;
import com.neo.trainer.service.admin.demoapp.DemoAppServiceAdmin;


@Controller
public class DemoAppController {
	
	@Autowired
	DemoAppServiceAdmin demoAppServiceAdmin; 
	@RequestMapping(value = "/uploadDemoAppForm.htm", method = RequestMethod.GET)
	public String uploadDemoAppForm(Model model) {
		  List<DemoTechnology> techList = demoAppServiceAdmin.getDemoAppTech();
		  model.addAttribute("techList", techList);
		return "demoAppForm";   
	}
	
	@RequestMapping(value = "/uploadDemoApp.htm", method = RequestMethod.POST)
	public String uploadDemoApp(@ModelAttribute("demoUpload") UploadDemoApp demoUpload,Model model,HttpServletRequest req, BindingResult result) {
	   
		demoAppServiceAdmin.uploadDemoApp(demoUpload,req);
		 List<DemoTechnology> techList = demoAppServiceAdmin.getDemoAppTech();
		  model.addAttribute("techList", techList); 
			return "demoAppForm";       
	}    
	  
	@RequestMapping(value = "/demoTech.htm", method = RequestMethod.GET)
	public String demoTech() {
	
  
			return "addDemoTech";         
	}       
	
	@RequestMapping(value = "/addDemoTech.htm", method = RequestMethod.POST)
	public String adddemoTech(@RequestParam String tech,Model model ) {
		  
		demoAppServiceAdmin.addDemoTech(tech);
		 List<DemoTechnology> techList = demoAppServiceAdmin.getDemoAppTech();
		  model.addAttribute("techList", techList); 
		return "demoAppForm";             
	}   
   
}
  