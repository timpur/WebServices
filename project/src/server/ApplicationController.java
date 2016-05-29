package server;

import java.io.*;
import javax.xml.bind.*;
import javax.xml.bind.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import bean.*;

public class ApplicationController {
	
	public static String WebPath = "WebContent/";

	public static String PFilePath = "WebContent/WEB-INF/polls.xml";
	public static FileController<PollsController> PFC;
	public static PollsController PC;

	public static String UFilePath = "WebContent/WEB-INF/users.xml";
	public static FileController<UsersController> UFC;
	public static UsersController UC;

	public static void load() {
		PFC = new FileController<PollsController>(PFilePath,
				PollsController.class);
		PC = PFC.load();

		UFC = new FileController<UsersController>(UFilePath,
				UsersController.class);
		UC = UFC.load();

	}

	public static void save() {
		PFC.save(PC);
		UFC.save(UC);
	}

	public static String getPollsHTML() throws Exception {
		PollsController pc = new PollsController(PC.filterPolls("", true, 0));
		
		// Transformer
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer(new StreamSource(
				WebPath + "/WEB-INF/PollsMainTransform.xsl"));

		// Source
		JAXBContext jc = JAXBContext.newInstance(PollsController.class);
		JAXBSource source = new JAXBSource(jc, pc);

		// Result
		StringWriter writer = new StringWriter();

		// Transform
		transformer.transform(source, new StreamResult(writer));

		return writer.toString();
	}
	
	public static String getPollHTML(int id) throws Exception {		
		// Transformer
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer(new StreamSource(
				WebPath + "/WEB-INF/viewPoll.xsl"));

		// Source
		JAXBContext jc = JAXBContext.newInstance(Poll.class);
		JAXBSource source = new JAXBSource(jc, PC.getPollByID(id));

		// Result
		StringWriter writer = new StringWriter();

		// Transform
		transformer.transform(source, new StreamResult(writer));

		return writer.toString();
	}
	
}
