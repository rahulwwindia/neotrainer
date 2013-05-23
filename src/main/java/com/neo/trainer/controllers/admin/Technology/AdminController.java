package com.neo.trainer.controllers.admin.Technology;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.neo.trainer.controllers.admin.onlinetest.QuestionsController;
import com.neo.trainer.model.admin.TechTutorial;
import com.neo.trainer.model.admin.Technologies;
import com.neo.trainer.model.admin.TutorialImages;
import com.neo.trainer.model.blog.Comments;
import com.neo.trainer.model.onlinetest.FileUpload;
import com.neo.trainer.serviceimp.admin.TechTutorialServiceImpl;
import com.neo.trainer.serviceimp.admin.TechnologyServiceImpl;
import com.neo.trainer.serviceimp.helper.RetrievePropertiesValue;
import com.neo.trainer.serviceimp.helper.UploadFileHelper;

@Controller
public class AdminController {
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(AdminController.class);

	@Autowired
	TechnologyServiceImpl techSerImpl;

	@Autowired
	TechTutorialServiceImpl techTuteSerImpl;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@RequestMapping(value = "/addNewTutorial.htm", method = RequestMethod.GET)
	public String addTutorial(Model model, HttpServletRequest request) {
		System.out.println("Entering Test");
		List<Technologies> techlist = techSerImpl.getTechnologies();
		System.out.println(techSerImpl.getTechnologies());
		System.out.println("Test");
		model.addAttribute("techlist", techlist);
		return "addNewPage";
	}

@RequestMapping(value = "/getTechTute.htm", method = RequestMethod.GET)
public String getTutorials(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String techname = request.getParameter("techname");
		List<TechTutorial> techTuteList = techTuteSerImpl
				.getTechTurorial(techname);
		// System.out.println(techTuteSerImpl.getTechTurorial());
		/* System.out.println("Test=="+techTuteList.get(0).getTutorialName()); */
		session.setAttribute("TechnoName", techname);
		model.addAttribute("techTuteList", techTuteList);
		model.addAttribute("techName", techname);

		return "getTechTute";
	}

	@RequestMapping(value = "/addTechnologyPopUp.htm", method = RequestMethod.GET)
	public String addTechPopup(Model model, HttpServletRequest request) {
		model.addAttribute("technologies", new Technologies());
		return "addTechPopup";
	}

	@RequestMapping(value = "/addTechTutePopup.htm", method = RequestMethod.GET)
	public String addTechTutePopup(Model model, HttpServletRequest request) {

		model.addAttribute("technTutorial", new TechTutorial());
		return "addTechTutePopup";
	}

	@RequestMapping(value = "/saveTechnology.htm", method = RequestMethod.POST)
	public String saveTechnology(@Valid Technologies technologies, Model model,
			HttpServletRequest request) {
		System.out.println("technologies: ------>" + technologies);
		techSerImpl.addTechnology(technologies);
		/*
		 * String technoName = request.getParameter("techname");
		 * System.out.println("Technology Name Entered Is : " +technoName);
		 */
		return "redirect:addNewTutorial.htm";
	}

	@RequestMapping(value = "/saveTechTute.htm", method = RequestMethod.POST)
	public String saveTechTute(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();

		List<Technologies> technologies = (List<Technologies>) hibernateTemplate
				.find("from Technologies where technologyName=?", request
						.getParameter("technologyName").trim());
		Technologies tech = technologies.get(0);
		log.info("Technology Name : " + tech.getTechnologyName());
		TechTutorial techTutorial = new TechTutorial();
		techTutorial.setTutorialName(request.getParameter("tutorialName"));
		String Tutorial = request.getParameter("tutorialName");
		log.info("The Tutorial Name Is : " + Tutorial);

		Set<TechTutorial> techSet = new HashSet<TechTutorial>();
		techSet.add(techTutorial);

		tech.setTechTutorials(techSet);
		techTutorial.setTechnologies(tech);
		hibernateTemplate.save(techTutorial);
		int parRow=0;
		int  pageNo=1;
     	model.addAttribute("parentRow", parRow);
    	model.addAttribute("pageNo", pageNo);
		model.addAttribute("tutorialImages", new TutorialImages());
		session.setAttribute("tutorialName", Tutorial);
		// techTuteSerImpl.addTechTutorial(techTute);
		/*
		 * String technoName = request.getParameter("techname");
		 * System.out.println("Technology Name Entered Is : " +technoName);
		 */
		return "saveTechTute";
	}

	@RequestMapping(value = "/saveTechPage.htm", method = RequestMethod.POST)
	public String saveTechPage(Model model, HttpServletRequest request) {

//		List<Technologies> technologies = (List<Technologies>) hibernateTemplate
//				.find("from Technologies where technologyName=?", request
//						.getParameter("technologyName").trim());
//		Technologies tech = technologies.get(0);
//		System.out.println("*******" + tech.getTechnologyName());
//		TechTutorial techTutorial = new TechTutorial();
//		techTutorial.setTutorialName(request.getParameter("tutorialName"));
//
//		Set<TechTutorial> techSet = new HashSet<TechTutorial>();
//		techSet.add(techTutorial);
//
//		tech.setTechTutorials(techSet);
//		techTutorial.setTechnologies(tech);
//		hibernateTemplate.save(techTutorial);

//
//		// techTuteSerImpl.addTechTutorial(techTute);
//		/*
//		 * String technoName = request.getParameter("techname");
//		 * System.out.println("Technology Name Entered Is : " +technoName);
//		 */
		return "saveTechTute";
	}

	@RequestMapping(value = "/saveImage.htm", method = RequestMethod.POST)
	public String fileUpload(@Valid TutorialImages fileUploadForm, Model model,
			HttpServletRequest request) throws Exception {
		System.out.println("In File Uploload");

		System.out.println("fileUploadForm :"+fileUploadForm.getImageDescription());
		
		ModelMap modelMap = new ModelMap();
		CommonsMultipartFile multipartFile = fileUploadForm.getFileData();
  

		log.info("multipartFile: " + multipartFile);
		String fileName = "";
		

		if (multipartFile != null) {

			fileName = multipartFile.getOriginalFilename();
		
			System.out.println("getNam(): " + multipartFile.getName());
			System.out.println("getStorageDescription(): "
					+ multipartFile.getStorageDescription());
			System.out.println("multipartFile.getFileItem(): "
					+ multipartFile.getFileItem());
				

			log.info("inside mulitipart controller");
			log.info("file uploaded is:" + fileName);
			log.info("multipartFile: "
					+ multipartFile.getInputStream().toString());

			InputStream ip=multipartFile.getInputStream();
			
			/*InputStream ip = new FileInputStream(
					"/home/webwerks/Documents/WorkSpaceNeoTrainer/neotrainer/src/main/webapp/resources/UploadedImage/"
						+ fileName);*/
			List<TechTutorial> techTutorials=hibernateTemplate.find("from TechTutorial where tutorialName='"+request.getParameter("tutoName")+"'");
			int tutorialId= techTutorials.get(0).getTutorialId();
			int page=Integer.parseInt(request.getParameter("pageNum"));
			String editedFileName ="image"+Integer.toString(tutorialId)+Integer.toString(page)+".jpg";
			String path ="/resources/UploadedImage/"+editedFileName;
			UploadFileHelper.uploadFile(fileUploadForm, path, request);
			    
			int nextPage=page+1;
			System.out.println(request.getParameter("pointer"));
			System.out.println(request.getParameter("tutoName"));
			System.out.println(request.getParameter("page"));
			System.out.println(request.getParameter("nextPage"));
		    
			
			
			
			
			System.out.println("THE TUTORIAL ID IS>>>>>>>>>>>>>>>> "+tutorialId);
			String rawFileName=fileUploadForm.getFileData().getOriginalFilename();
			System.out.println("______"+ rawFileName);
			
			System.out.println("+++++++++"+ editedFileName);
			fileUploadForm.setTechTutorial(techTutorials.get(0));
			fileUploadForm.setImageName(editedFileName);
			/*fileUploadForm.setImageName();*/
			hibernateTemplate.save(fileUploadForm); 
			
			List<TutorialImages> tutorials= hibernateTemplate.find("from TutorialImages where techTutorial='"+tutorialId+"' and pointer='"+fileUploadForm.getPointer()+"'");
			int parRow = tutorials.get(0).getDataId();
			System.out.println("THE NEXT PARENT ISSSSSSSSSSS ::::::"+parRow);
			
			
	 
		 
			
	//	List<TutorialImages> tutorialImages =	hibernateTemplate.find("from TutorialImages where tutorialId="+tutorialId +"and pointer="+parentRow );
			
//		   System.out.println(tutorialImages.get(0).getDataId()); 
	//	   int parentRow=tutorialImages.get(0).getDataId();
			
			
			model.addAttribute("parentRow", parRow);
			model.addAttribute("pageNo", nextPage);
			model.addAttribute("tutorialImages", new TutorialImages());
		
			 
			/*
			 * questServ .addFileQuestions(
			 * "/home/webwerks/Documents/WorkSpaceNeoTrainer/neotrainer/src/main/webapp/resources/UploadedImage/"
			 * + fileName);
			 */

		} else {
			log.info("no multipart data found.");
		}
 
	
		return "saveTechTute";

	}
	
	@RequestMapping(value = "/ExitSaveImage.htm", method = RequestMethod.GET)
	public String ExitSaveImage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		HashMap<String,ArrayList<TechTutorial>> map = techSerImpl.getTechNTuteMAp();
		log.info("THis is to test ");
		
		session.setAttribute("map", map);
		return "redirect:addNewTutorial.htm";
	}
	
	@RequestMapping(value = "/CheckTutorial.htm", method = RequestMethod.GET)
	public String CheckTutorial(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String technologyName = request.getParameter("TechnologyName");
		String tutorialName= request.getParameter("TutorialName");
		 boolean exists=techTuteSerImpl.getTurorialExist(tutorialName,technologyName);
	
		log.info("THis is to test the value of Exists Variable : "+ exists);
		model.addAttribute("Exists",exists);
		return "existResult";
	}
	
	

}
