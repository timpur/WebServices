package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import bean.Poll;
import bean.Polls;
import bean.Response;
import bean.User;

public class PollDao {
	public static String FILEPATH = "WebContent/WEB-INF/polls.xml";

	public static void setFilPath(String filePath) {
		FILEPATH = filePath;
	}

	/**
	 * Returns all polls in the XML files
	 * 
	 * @return
	 */
	public static Polls getPolls() {
		Polls polls = load();
		return polls;
	}

	/**
	 * return Poll with same Id
	 * 
	 * @param id
	 * @return
	 */
	public static Poll getPoll(int id) {

		Polls polls = load();
		// loop poll and find which has same id
		for (Poll poll : polls.getList()) {
			if (poll.getId() == id) {
				return poll;
			}
		}

		// if no poll found with given id
		return null;
	}

	/**
	 * when return 0, means login fail when return 1, means create poll success
	 * 
	 * @param username
	 * @param password
	 * @param title
	 * @param location
	 * @param description
	 * @param options
	 * @return
	 */
	public static int createPoll(String username, String password,
			String title, String location, String description, String options[]) {

		// before create Poll
		// verify authentication
		User user = UserDao.login(username, password);
		if (user == null) {
			// when invalid username and passwrod
			return 0;
		}

		Poll poll = new Poll();
		poll.setAuthor(username);
		poll.setTitle(title);
		poll.setDescription(description);
		poll.setLocation(location);
		poll.setOptions(options);
		// dynamic calculate next ID
		poll.setId(nextId());

		// add new poll to current polls
		Polls polls = load();
		polls.addPoll(poll);
		// save current polls back to XML file
		save(polls);
		return 1;
	}

	/**
	 * when return 0, means pollId is invalid
	 * 
	 * 
	 * @param pollId
	 * @param name
	 * @param options
	 * @return
	 */
	public static int vote(int pollId, String name, String options[]) {

		// validate pollId is valid
		Poll poll = getPoll(pollId);
		if (poll == null) {
			return 0;
		}

		Response response = new Response(name, options);
		poll.addResponse(response);
		update(poll);

		return 1;
	}

	/**
	 * close a poll
	 * 
	 * when return 0, means login fail
	 * 
	 * when return -1, means login user is not author of poll
	 * 
	 * when return 1, means closed success
	 * 
	 * @param username
	 * @param password
	 * @param pollId
	 * @return
	 */
	public static int closePoll(String username, String password, int pollId) {
		// before create Poll
		// verify authentication
		User user = UserDao.login(username, password);
		if (user == null) {
			// when invalid username and passwrod
			return 0;
		}

		Poll poll = getPoll(pollId);
		// check whether the login user is the owner
		if (!poll.getAuthor().equals(username)) {
			return -1;
		}

		poll.setClosed(true);
		update(poll);
		return 1;

	}

	/**
	 * replace current poll by new poll, and then override in XML file
	 * 
	 * so we can update a poll in the xml
	 * 
	 * @param poll
	 */
	private static void update(Poll poll) {
		Polls polls = load();
		ArrayList<Poll> pollList = polls.getList();
		for (int i = 0; i < pollList.size(); i++) {
			if (poll.getId() == pollList.get(i).getId()) {
				// remove old one
				pollList.remove(i);
				// add new one to replace it
				pollList.add(i, poll);
				break;
			}
		}
		// write to XML
		save(polls);
	}

	/**
	 * this is used when creating poll. we need collect the largest ID in the
	 * system so far, and plus 1
	 * 
	 * @return
	 */
	private static int nextId() {
		Polls polls = load();
		int largestId = 0;
		for (Poll poll : polls.getList()) {
			if (poll.getId() > largestId) {
				largestId = poll.getId();
			}
		}
		return largestId + 1;
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
