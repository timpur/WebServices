package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import bean.Poll;
import bean.Polls;
import bean.Response;

public class PollDao {
	public static String FILEPATH = "WebContent/WEB-INF/polls.xml";

	public static void setFilPath(String filePath) {
		FILEPATH = filePath;
	}

	public static Polls getPolls() {
		Polls polls = load();
		return polls;
	}

	public static Poll getPoll(int id) {
		return null;
	}

	public static void createPoll(Poll poll) {

	}

	public static void vote(int id, Response resp) {

	}

	/**
	 * convert XML file into java objects using unmarshall
	 * 
	 * @return
	 */
	private static Polls load() {

		Polls polls = null;
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Polls.class);
			Unmarshaller u = jc.createUnmarshaller();
			FileInputStream fin = new FileInputStream(FILEPATH);
			polls = (Polls) u.unmarshal(fin);
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
	public static void save(Polls polls) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Polls.class);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(polls, new File(FILEPATH));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
