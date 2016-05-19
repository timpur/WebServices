package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import bean.Poll;
import bean.PollsController;
import bean.Response;

public class PollDao {
	public static String FILEPATH = "WebContent/WEB-INF/polls.xml";

	public static void setFilPath(String filePath) {
		FILEPATH = filePath;
	}

	public static PollsController getPolls() {
		PollsController polls = load();
		return polls;
	}

	

	/**
	 * convert XML file into java objects using unmarshall
	 * 
	 * @return
	 */
	private static PollsController load() {

		PollsController polls = null;
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(PollsController.class);
			Unmarshaller u = jc.createUnmarshaller();
			FileInputStream fin = new FileInputStream(FILEPATH);
			polls = (PollsController) u.unmarshal(fin);
			fin.close();
			return polls;
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return polls;
	}

	/**
	 * convert java objects into XML file using marshall
	 * 
	 * @param polls
	 */
	public static void save(PollsController polls) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(PollsController.class);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(polls, new File(FILEPATH));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
