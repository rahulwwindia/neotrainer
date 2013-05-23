package com.neo.trainer.serviceimp.generator;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

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

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.neo.trainer.service.generator.PomGenerator;

// TODO: Auto-generated Javadoc

/**
 * The Class PomGeneratorImp.
 */
@Service("pomgenerator")
public class PomGeneratorImp implements PomGenerator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neo.trainer.service.generator.PomGenerator#generatePom(javax.servlet
	 * .http.HttpServletRequest, java.lang.String,
	 * javax.servlet.http.HttpServletResponse)
	 */
	public boolean generatePom(HttpServletRequest request, String keys,
			HttpServletResponse response) {

		try {
			Properties properties = new Properties();
			java.net.URL url = Config.class.getClassLoader().getResource(
					"pom.properties");
			properties.load(url.openStream());
			String keyArr[] = keys.split(",");
			String filepath = request.getRealPath("resources/pom/pom.xml");
			System.out.println("filepath : " + filepath);
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the root element
			Node project = doc.getFirstChild();
			File newFile = null;
			for (int k = 0; k < keyArr.length; k++) {
				String key = properties.getProperty(keyArr[k]);
				System.out.println("key : " + key);
				// Get the dependencies element by tag name directly
				Node dependencies = doc.getElementsByTagName("dependencies")
						.item(0);

				// append a new nodes to dependencies

				String keyConfig[] = key.split("!");
				System.out.println("keyConfig : " + keyConfig);
				for (int i = 0; i < keyConfig.length; i++) {
					Element dependency = doc.createElement("dependency");
					dependencies.appendChild(dependency);
					String keyConfigStr[] = keyConfig[i].split("%");

					if (keyConfigStr.length > 0) {
						Element groupId = doc.createElement("groupId");
						groupId.appendChild(doc.createTextNode(keyConfigStr[0]));
						dependency.appendChild(groupId);
					}
					if (keyConfigStr.length > 1) {
						Element artifactId = doc.createElement("artifactId");
						artifactId.appendChild(doc
								.createTextNode(keyConfigStr[1]));
						dependency.appendChild(artifactId);
					}
					if (keyConfigStr.length > 2) {
						Element version = doc.createElement("version");
						version.appendChild(doc.createTextNode(keyConfigStr[2]));
						dependency.appendChild(version);
					}
					if (keyConfigStr.length > 3) {
						Element type = doc.createElement("type");
						type.appendChild(doc.createTextNode(keyConfigStr[3]));
						dependency.appendChild(type);
					}
					if (keyConfigStr.length > 4) {
						Element scope = doc.createElement("scope");
						scope.appendChild(doc.createTextNode(keyConfigStr[4]));
						dependency.appendChild(scope);
					}
				}

				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat(
						"yyyy_MMM_dd_hhMMss");
				String formattedDate = format.format(date);
				String newFilePath = request.getRealPath("/resources/pom/"
						+ formattedDate);
				File file = new File(newFilePath);
				file.mkdir();
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory
						.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				System.out.println("newFilePath :" + newFilePath);
				newFile = new File(newFilePath + "/pom.xml");
				StreamResult result = new StreamResult(newFile);
				transformer.transform(source, result);

				System.out.println("Done");
			}
			response.setContentType("application/xml");
			response.setHeader("Content-Disposition",
					"attachment; filename=pom.xml");
			FileCopyUtils.copy(
					new DataInputStream(new FileInputStream(newFile)),
					response.getOutputStream());

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}

		return false;
	}

}
