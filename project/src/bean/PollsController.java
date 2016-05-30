package bean;

import java.io.Serializable;
import java.util.*;

import javax.xml.bind.annotation.*;

import server.ApplicationController;

//The poll controller is a class that contains a list of Polls
//This class contains complex functions to add and ged polls by diffrent data points
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "polls")
public class PollsController implements Serializable {
	private static final long serialVersionUID = -6191921116745752062L;

	@XmlElement(name = "poll")
	private List<Poll> polls;

	public PollsController() {
		this.polls = new ArrayList<Poll>();
	}

	public PollsController(List<Poll> list) {
		this.polls = list;
	}

	public void addPoll(Poll poll) {
		this.polls.add(poll);
	}

	public List<Poll> getPolls() {
		return polls;
	}

	public void setPolls(List<Poll> list) {
		this.polls = list;
	}

	public void clearPolls() {
		polls.clear();
	}

	public Poll getPollByID(int id) {
		// loop poll and find which has same id
		for (Poll poll : polls) {
			if (poll.getId() == id) {
				return poll;
			}
		}
		// if no poll found with given id
		return null;
	}

	public int getPollIndexByID(int ID) {
		for (int i = 0; i < polls.size(); ++i) {
			if (polls.get(i).getId() == ID)
				return i;
		}
		return -1;
	}

	private int nextPollId() {
		int largestId = 0;
		for (Poll poll : polls) {
			if (poll.getId() > largestId) {
				largestId = poll.getId();
			}
		}
		return largestId + 1;
	}
	
	// To create a poll
	public int createPoll(String username, String title, String location,
			String description, Calendar[] options) {
		Poll poll = new Poll();
		poll.setAuthor(username);
		poll.setTitle(title);
		poll.setDescription(description);
		poll.setLocation(location);
		poll.setOptions(options);
		// dynamic calculate next ID
		int id = nextPollId();
		poll.setId(id);
		// add new poll to current polls
		addPoll(poll);

		// save XML
		ApplicationController.save();
		
		return id;

	}

	private boolean updatePoll(Poll poll) {

		int index = getPollIndexByID(poll.getId());
		if (index != -1) {
			polls.set(index, poll);
			// save XML
			ApplicationController.save();
			return true;
		} else {
			return false;
		}
	}
	
	//used to close a poll
	public boolean closePoll(int pollID, User user) {
		Poll poll = getPollByID(pollID);

		if (poll == null)
			return false;

		if (!poll.getAuthor().equals(user.getUsername()))
			return false;

		poll.setStatus(false);
		return true;
	}
	
	//Used to vote on a poll
	public boolean vote(int pollID, String visitorName, List<Option> options) {

		Poll poll = getPollByID(pollID);

		if (poll == null)
			return false;

		Response response = new Response(visitorName, options);
		poll.addResponse(response);

		// save XML
		updatePoll(poll);
		return true;
	}

	
	//Used to filter the polls to a username
	public List<Poll> getPollsForUser(String username) {
		List<Poll> resultList = new ArrayList<Poll>();
		for (Poll poll : this.getPolls()) {
			if (poll.getAuthor().equals(username)) {
				resultList.add(poll);
			}
		}
		return resultList;
	}
	
	//Checks that a user created the poll
	public boolean validatePoll(int ID, String Username) {
		Poll poll = getPollByID(ID);
		if (poll != null)
			if (poll.getAuthor().equals(Username))
				return true;
		return false;
	}
	
	//Filters a poll based of author, status, and min responses
	public List<Poll> filterPolls(String author, boolean status, int minResponse) {
		List<Poll> result = new ArrayList<Poll>();

		for (Poll poll : polls) {
			if (author.isEmpty() || poll.getAuthor().equalsIgnoreCase(author))
				if (poll.getStatus() == status)
					if (poll.getRespsonses().size() >= minResponse)
						result.add(poll);
		}

		return result;
	}

	public String toString() {
		return String.format("{Poll Count: %d}", polls.size());
	}

}
