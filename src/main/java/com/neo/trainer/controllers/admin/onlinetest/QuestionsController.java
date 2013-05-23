package com.neo.trainer.controllers.admin.onlinetest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neo.trainer.model.onlinetest.Candidate;
import com.neo.trainer.model.onlinetest.FileUpload;
import com.neo.trainer.model.onlinetest.Options;
import com.neo.trainer.model.onlinetest.QuestionSet;
import com.neo.trainer.model.onlinetest.Questions;
import com.neo.trainer.service.onlinetest.LoginCandidateService;
import com.neo.trainer.service.onlinetest.QuestionSetService;
import com.neo.trainer.service.onlinetest.QuestionsService;
import com.neo.trainer.serviceimp.helper.UploadFileHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class QuestionsController.
 */
@Controller
public class QuestionsController {

	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(QuestionsController.class);

	/** The quest serv. */
	@Autowired
	QuestionsService questServ;

	/** The quest set serv. */
	@Autowired
	QuestionSetService questSetServ;

	/** The register serv. */
	/*
	 * @Autowired RegisterCandidateService registerServ;
	 */
	/** The candlogin servadmin. */
	@Autowired
	LoginCandidateService candloginServ;

	/**
	 * Questions action.
	 * 
	 * @param submit
	 *            the submit
	 * @param setEntries
	 *            the set entries
	 * @param questId
	 *            the quest id
	 * @param model
	 *            the model
	 * @return the model and view
	 */
	@RequestMapping(value = "/questionAction", method = RequestMethod.POST)
	/*
	 * public ModelAndView questionsAction(@RequestParam String submit, String
	 * questSet, String settype, String level, Model model) {
	 */
	public ModelAndView questionsAction(@RequestParam String submit,
			String setEntries, String questId, Model model) {
		log.info("Inside questionsAction..." + submit + " setEntries"
				+ setEntries);
		ModelMap modelMap = new ModelMap();
		if ("Add Question".equals(submit)) {
			log.info("Add quesiton clicked...");
			model.addAttribute("fileUploadForm", new FileUpload());
			modelMap.addAttribute("setEntries", setEntries);
			return new ModelAndView("popupAddQuest", modelMap);
		} else if ("Edit Question".equals(submit)) {
			log.info("Update quesiton clicked...questId: " + questId);
			modelMap.addAttribute("setEntries", setEntries);
			modelMap.addAttribute("quest", questServ.getQuesiton(questId));
			modelMap.addAttribute("opt", questServ.getOptions(questId));
			return new ModelAndView("popupEditQuest", modelMap);

		} else if ("Delete Question".equals(submit)) {
			log.info("Delete quesiton clicked..." + submit + "questId: "
					+ questId);
			String[] questIdArr = questId.split(",");
			for (int i = 0; i < questIdArr.length; i++) {
				log.info("questIdArr[" + i + "]" + questIdArr[i]);
			}
			questServ.deleteQuestions(questIdArr);
			modelMap.addAttribute("questSetMap", questSetServ.getQuestionSet());
			return new ModelAndView("adminTest", modelMap);
		}
		return null;
	}

	/**
	 * Adds the questions.
	 * 
	 * @param setEntries
	 *            the set entries
	 * @param questDesc
	 *            the quest desc
	 * @param option
	 *            the option
	 * @param crop
	 *            the crop
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	public String addQuestions(@RequestParam String setEntries,
			String questDesc, String option1, String option2, String option3,
			String option4, String crop, Model model) {
		log.info("Inside save add questions..." + option1 + "questDesc: "
				+ questDesc + "setEntries: " + setEntries + " crop: " + crop);
		// String[] optionArr = option.split(",");
		String[] optionArr = { option1, option2, option3, option4 };
		String[] setEntriesArr = setEntries.split(",");
		for (int i = 0; i < optionArr.length; i++) {
			log.info("optionArr[" + i + "]" + optionArr[i]);
		}

		for (int i = 0; i < setEntriesArr.length; i++) {
			log.info("setEntriesArr[" + i + "]" + setEntriesArr[i]);
		}

		questServ.addQuestions(optionArr, setEntriesArr, questDesc, crop);

		return "redirect:testHome";

	}

	/**
	 * Saveedit questions.
	 * 
	 * @param questDesc
	 *            the quest desc
	 * @param option
	 *            the option
	 * @param questId
	 *            the quest id
	 * @param crop
	 *            the crop
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/editQuestion", method = RequestMethod.POST)
	public String saveeditQuestions(@RequestParam String questDesc,
			String option1, String option2, String option3, String option4,
			String questId, String crop, Model model) {
		log.info("Inside save edit questions..." + option1 + "questDesc: "
				+ questDesc + "setEntries: " + " crop: " + crop);
		String[] optionArr = { option1, option2, option3, option4 };
		// String[] optionArr = option.split(",");
		// String[] setEntriesArr = setEntries.split(",");
		/*
		 * for (int i = 0; i < optionArr.length; i++) { log.info("optionArr[" +
		 * i + "]" + optionArr[i]); }
		 */
		/*
		 * for (int i = 0; i < setEntriesArr.length; i++) {
		 * log.info("setEntriesArr[" + i + "]" + setEntriesArr[i]); }
		 */

		questServ.editQuestion(questServ.getQuesiton(questId), optionArr,
				questDesc, crop);

		return "redirect:testHome";
	}

	/**
	 * *******************************************************************.
	 * 
	 * @param qsetId
	 *            the qset id
	 * @param settype
	 *            the settype
	 * @param level
	 *            the level
	 * @param model
	 *            the model
	 * @return the string
	 */

	/**
	 * Gets the questions.
	 * 
	 * @param qsetId
	 *            the qset id
	 * @param setabcd
	 *            the setabcd
	 * @param model
	 *            the model
	 * @return the questions
	 */
	@RequestMapping(value = "/getQuestions", method = RequestMethod.GET)
	public String getQuestions(@RequestParam String qsetId, String settype,
			String level, Model model) {
		log.info("Inside controller getQuestions...qsetId: " + qsetId
				+ " settype : " + settype + " level : " + level);

		// model.addAttribute("questhm", dispQuestServ.getQues(qsetId));
		model.addAttribute("questhm", questServ.getQuestions(qsetId, settype,
				Integer.parseInt(level)));
		return "getQuestions";
	}

	/**
	 * Adds the quest set.
	 * 
	 * @param setName
	 *            the set name
	 * @return the string
	 */
	@RequestMapping(value = "/addQuestSet", method = RequestMethod.POST)
	public String addQuestSet(@RequestParam String setName) {
		log.info("Inside controller addQuestSet...");
		boolean flag = questSetServ.addQuestSet(setName);
		if (flag) {
			return "redirect:addSet?adminMsg="
					+ "Question set successfully added";
		} else {
			return "redirect:addSet?adminMsg="
					+ "Question set could not be added.";
		}
	}

	/**
	 * Edits the quest set.
	 * 
	 * @param setName
	 *            the set name
	 * @param setId
	 *            the set id
	 * @return the string
	 */
	@RequestMapping(value = "/editQuestSet", method = RequestMethod.POST)
	public String editQuestSet(@RequestParam String setName, int setId) {
		log.info("Inside controller editQuestSet..." + setId);

		boolean flag = questSetServ.editQuestSet(setId, setName);
		if (flag) {
			return "redirect:editSet?adminMsg="
					+ "1 Question set successfully edited";
		} else {
			return "redirect:editSet?adminMsg="
					+ "1 Question set could not be edited.";
		}

	}

	/**
	 * Delete quest set.
	 * 
	 * @param setId
	 *            the set id
	 * @return the string
	 */
	@RequestMapping(value = "/deleteQuestSet", method = RequestMethod.POST)
	public String deleteQuestSet(@RequestParam int setId) {
		log.info("Inside controller deleteQuestSet...");

		boolean flag = questSetServ.deleteQuestSet(setId);
		if (flag) {
			return "redirect:deleteSet?adminMsg="
					+ "1 Question set successfully edited";
		} else {
			return "redirect:deleteSet?adminMsg="
					+ "1 Question set could not be edited.";
		}

	}

	/**
	 * Adds the set.
	 * 
	 * @param request
	 *            the request
	 * @return the model and view
	 */
	@RequestMapping(value = "/addSet", method = RequestMethod.GET)
	public ModelAndView addSet(HttpServletRequest request) {
		log.info("Inside controller addSet...");

		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("questSetMap", questSetServ.getQuestionSet());
		modelMap.addAttribute("adminMsg", request.getParameter("adminMsg"));
		return new ModelAndView("addQuestSet", modelMap);
	}

	/**
	 * Edits the set.
	 * 
	 * @param request
	 *            the request
	 * @return the model and view
	 */
	@RequestMapping(value = "/editSet", method = RequestMethod.GET)
	public ModelAndView editSet(HttpServletRequest request) {
		log.info("Inside controller editSet...");

		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("questSetMap", questSetServ.getQuestionSet());
		modelMap.addAttribute("adminMsg", request.getParameter("adminMsg"));
		return new ModelAndView("editQuestSet", modelMap);
	}

	/**
	 * Delete set.
	 * 
	 * @param request
	 *            the request
	 * @return the model and view
	 */
	@RequestMapping(value = "/deleteSet", method = RequestMethod.GET)
	public ModelAndView deleteSet(HttpServletRequest request) {
		log.info("Inside controller deleteSet...");

		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("questSetMap", questSetServ.getQuestionSet());
		modelMap.addAttribute("adminMsg", request.getParameter("adminMsg"));
		return new ModelAndView("deleteQuestSet", modelMap);
	}

	/**
	 * Login.
	 * 
	 * @param model
	 *            the model
	 * @param request
	 *            the request
	 * @return the model and view
	 */
	@RequestMapping(value = "/testHome", method = RequestMethod.GET)
	public ModelAndView login(ModelMap model, HttpServletRequest request) {
		log.info("testHome called at controller.-----------");

		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("questSetMap", questSetServ.getQuestionSet());

		return new ModelAndView("adminTest", modelMap);

	}

	/**
	 * Register cand.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */
	/*
	 * @RequestMapping(value = "/RegisterCand", method = RequestMethod.GET)
	 * public String registerCand(Model model) {
	 * log.info("Inside controller registerCand...");
	 * model.addAttribute("newCand", new Candidate()); return "registerCand"; }
	 */

	/**
	 * Adds the cand.
	 * 
	 * @param newCand
	 *            the new cand
	 * @param result
	 *            the result
	 * @param model
	 *            the model
	 * @param CandGroup
	 *            the cand group
	 * @return the model and view
	 */
	/*
	 * @RequestMapping(value = "/addCand", method = RequestMethod.POST) public
	 * ModelAndView addCand(@Valid Candidate newCand, BindingResult result,
	 * Model model, @RequestParam String CandGroup) {
	 * log.info("Inside controller addCand..." + CandGroup); ModelMap modelMap =
	 * new ModelMap();
	 * 
	 * boolean success = candloginServ.addNewCand(newCand, CandGroup); if
	 * (success) { modelMap.addAttribute("success", "Registration successful");
	 * return new ModelAndView("candLogin", modelMap); } else { return new
	 * ModelAndView("registerCand", modelMap); } }
	 */

	/**
	 * File upload.
	 * 
	 * @param fileUploadForm
	 *            the file upload form
	 * @param model
	 *            the model
	 * @param request
	 *            the request
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/fileForm", method = RequestMethod.POST)
	public String fileUpload(@Valid FileUpload fileUploadForm, Model model,
			HttpServletRequest request) throws Exception {
		System.out.println("In File Uploload");

		/*
		 * ModelMap modelMap = new ModelMap(); CommonsMultipartFile
		 * multipartFile = fileUploadForm.getFile();
		 * 
		 * log.info("multipartFile: " + multipartFile); String fileName = "";
		 * 
		 * if (multipartFile != null) { fileName =
		 * multipartFile.getOriginalFilename(); System.out.println("getNam(): "
		 * + multipartFile.getName());
		 * System.out.println("getStorageDescription(): " +
		 * multipartFile.getStorageDescription());
		 * System.out.println("multipartFile.getFileItem(): " +
		 * multipartFile.getFileItem());
		 * 
		 * log.info("inside mulitipart controller");
		 * log.info("file uploaded is:" + fileName); log.info("multipartFile: "
		 * + multipartFile.getInputStream().toString()); InputStream ip =
		 * multipartFile.getInputStream();
		 * 
		 * OutputStream o = new FileOutputStream( new File(
		 * "/home/webwerks/Documents/WorkSpaceNeoTrainer/neotrainer/src/main/webapp/resources/uploadfile"
		 * , fileName));
		 * 
		 * IOUtils.copy(ip, o); o.close();
		 */
		String fileName = fileUploadForm.getFileData().getOriginalFilename();
		String path = "/resources/uploadfile/" + fileName;
		UploadFileHelper.uploadFile(fileUploadForm, path, request);
		System.out.println("=====" + request.getRealPath("") + path);
		questServ.addFileQuestions(request.getRealPath("") + path);

		/*
		 * BulkUploadController excel = new BulkUploadController();
		 * excel.readExcelSheet(
		 * "/home/webwerks/Documents/WorkSpaceNeoTrainer/neotrainer/src/main/webapp/resources/uploadfile/"
		 * + fileName);
		 */

		return "redirect:testHome";
	}

	@RequestMapping(value = "/showResults", method = RequestMethod.GET)
	public String showResults(Model model) {
		log.info("Inside controller showResults...");
		ModelMap modelMap = new ModelMap();
		return "showResults";

	}

}
