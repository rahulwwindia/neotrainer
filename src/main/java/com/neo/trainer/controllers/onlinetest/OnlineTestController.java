package com.neo.trainer.controllers.onlinetest;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.neo.trainer.model.onlinetest.Candidate;
import com.neo.trainer.service.onlinetest.LoginCandidateService;
import com.neo.trainer.service.onlinetest.QuestionsService;
import com.neo.trainer.service.onlinetest.TestService;

@Controller
@RequestMapping("exam")
public class OnlineTestController {

	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(OnlineTestController.class);

	@Autowired
	QuestionsService questServ;

	@Autowired
	TestService testServ;

	@Autowired
	LoginCandidateService candloginServ;

	@RequestMapping(value = "/onlineTest.htm", method = RequestMethod.POST)
	public String onlineTest(Candidate newCand, Model model,
			HttpServletRequest request,HttpSession session) {
		log.info("Inside controller onlineTest...");

		boolean success = candloginServ.addNewCand(newCand, request);

		if (success) {  

			   System.out.println("newCand ID :"+newCand.getCandGroup().getGroupId());
			session.setAttribute("newCand", newCand);
			return "onlineTest";
  
		} else {
			model.addAttribute("newCand", new Candidate());
			model.addAttribute("message",
					"Registration failed. Please provide other email address.");
			return "facade";

		}
	}

	@RequestMapping(value = "/startTest.htm", method = RequestMethod.GET)
	public String startTest(Model model, HttpServletRequest request,HttpSession session) {

		log.info("Inside controller start test...");   
		/*
		 * HttpSession httpSession = request.getSession(false); Candidate
		 * c=(Candidate)httpSession.getAttribute("candSessionName"); Group1
		 * g=c.getCandGroup(); g.getGroupName();
		 */
		Candidate candidate =(Candidate) session.getAttribute("newCand");
		String qsetId = candidate.getCandGroup().getGroupId().toString(); 
		String settype = "A";     
		String level = "1";      

		model.addAttribute("questhm", questServ.getQuestions(qsetId, settype,
				Integer.parseInt(level)));
		return "startTest";
  
	}

	@RequestMapping(value = "/submitTest.htm", method = RequestMethod.POST)
	public String submitTest(@RequestParam Map testMap, String total,
			Model model,HttpSession session ) {

		log.info("Map Received: " + testMap + "  total questions: " + total);

		String testAns = testMap.get("testMap").toString();
		log.info("testAns: " + testAns);
		Candidate candidate =(Candidate) session.getAttribute("newCand");
		List<Integer> i = testServ.getResult(testAns, "Java",
				Integer.parseInt(total),candidate);
		model.addAttribute("marks", i.get(0));
		model.addAttribute("totQuest", i.get(1));
		model.addAttribute("ans", i.get(2));
		model.addAttribute("unans", i.get(3));
		return "showTestResult";

	}

}
