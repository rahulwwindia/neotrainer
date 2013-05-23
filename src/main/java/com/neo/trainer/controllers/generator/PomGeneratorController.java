package com.neo.trainer.controllers.generator;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.neo.trainer.service.generator.PomGenerator;

// TODO: Auto-generated Javadoc
/**
 * Handles requests for the application home page.
 */
@Controller
public class PomGeneratorController {

	/** The pomgenerator. */
	@Autowired
	PomGenerator pomgenerator;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(PomGeneratorController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @return the string
	 */

	@RequestMapping(value = "/showGenerator", method = RequestMethod.GET)
	public String showPosts() {
		logger.info("Generator controller called...");
		return "showGenerator";
	}

	/**
	 * Generate xml.
	 * 
	 * @param keys
	 *            the keys
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the string
	 */
	@RequestMapping(value = "/getPom.htm", method = RequestMethod.POST)
	public String generateXML(@RequestParam("result") String keys,
			HttpServletRequest request, HttpServletResponse response) {
		pomgenerator.generatePom(request, keys, response);
		return null;

	}
}
