package bean;

import java.io.Serializable;
import java.util.*;

import javax.xml.bind.annotation.*;

import server.ApplicationController;

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

	public void createPoll(String username, String title, String location,
			String description, Calendar options[]) {
		Poll poll = new Poll();
		poll.setAuthor(username);
		poll.setTitle(title);
		poll.setDescription(description);
		poll.setLocation(location);
		poll.setOptions(options);
		// dynamic calculate next ID
		poll.setId(nextPollId());
		// add new poll to current polls
		addPoll(poll);

		// save XML
		ApplicationController.save();

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

	public boolean closePoll(int pollID, User user) {
		Poll poll = getPollByID(pollID);

		if (poll == null)
			return false;

		if (!poll.getAuthor().equals(user.getUsername()))
			return false;

		poll.setStatus(false);
		// save to XML
		updatePoll(poll);
		return true;
	}

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

	/**
	 * After user login, fetch all polls created by them
	 */
	public List<Poll> getPollsForUser(String username) {
		List<Poll> resultList = new ArrayList<Poll>();
		for (Poll poll : this.getPolls()) {
			if (poll.getAuthor().equals(username)) {
				resultList.add(poll);
			}
		}
		return resultList;
	}

	public List<Poll> filterPolls(String author, boolean status, int minResponse) {
		List<Poll> result = new ArrayList<Poll>();

		for (Poll poll : polls) {
			boolean match = false;

			if (author.isEmpty() || poll.getAuthor().equalsIgnoreCase(author))
				if (poll.getStatus() == status)
					if (poll.getRespsonses().size() >= minResponse)
						match = true;

			if (match)
				result.add(poll);
		}

		return result;
	}

	public String toString() {
		return String.format("{Poll Count: %d}", polls.size());
	}

}
