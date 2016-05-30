package server;

import java.io.*;

import javax.xml.bind.*;
import javax.xml.bind.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import bean.*;

// This class contains in instance of the classes so they can be accessed through out the application
public class ApplicationController {

	public static String WebPath = "WebContent/";

	public static String PFilePath = "WebContent/WEB-INF/polls.xml";
	public static FileController<PollsController> PFC;
	public static PollsController PC;

	public static String UFilePath = "WebContent/WEB-INF/users.xml";
	public static FileController<UsersController> UFC;
	public static UsersController UC;

	// Load the Controllers
	public static void load() {
		PFC = new FileController<PollsController>(PFilePath,
				PollsController.class);
		PC = PFC.load();

		UFC = new FileController<UsersController>(UFilePath,
				UsersController.class);
		UC = UFC.load();

	}

	// Save the controllers
	public static void save() {
		PFC.save(PC);
		UFC.save(UC);
	}

	// Functions for converting an object to html

	public static String getPollsHTML() {
		PollsController pc = new PollsController(PC.filterPolls("", true, 0));
		return xmlToHTML("/WEB-INF/PollsMainTransform.xsl", pc,
				PollsController.class);
	}

	public static String getPollsHTML(String username) {
		PollsController pc = new PollsController(PC.getPollsForUser(username));
		return xmlToHTML("/WEB-INF/PollsMainTransform.xsl", pc,
				PollsController.class);
	}

	public static String getPollDetailsHTML(int id) {
		Poll poll = PC.getPollByID(id);
		if (poll != null)
			return xmlToHTML("/WEB-INF/PollDetail.xsl", poll, Poll.class);
		else
			return "POLL NOT FOUN";
	}

	public static String getUserPollDetailsHTML(int id) {
		Poll poll = PC.getPollByID(id);
		if (poll != null)
			return xmlToHTML("/WEB-INF/CreatorPollDetail.xsl", poll, Poll.class);
		else
			return "POLL NOT FOUN";
	}

	public static String getPollSummeryHTML(int id) {
		Poll poll = PC.getPollByID(id);
		if (poll != null)
			return xmlToHTML("/WEB-INF/PollSummary.xsl", poll, Poll.class);
		else
			return "POLL NOT FOUN";
	}

	// function for converting an object to html via xml using xslt
	public static <T> String xmlToHTML(String xslFile, T obj, Class<T> type) {
		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer(new StreamSource(
					WebPath + xslFile));

			// Source
			JAXBContext jc = JAXBContext.newInstance(type);
			JAXBSource source;

			source = new JAXBSource(jc, obj);

			// Result
			StringWriter writer = new StringWriter();

			// Transform
			transformer.transform(source, new StreamResult(writer));

			return writer.toString();
		} catch (TransformerException e) {
			return "";
		} catch (JAXBException e) {
			return "";
		}
	}

}
