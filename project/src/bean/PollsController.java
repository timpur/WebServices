package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "polls")
public class PollsController implements Serializable {
	private static final long serialVersionUID = -6191921116745752062L;

	@XmlElement(name = "poll")
	private List<Poll> polls;

	public PollsController() {
		this.polls = new ArrayList<Poll>();
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

	public void createPoll(String username, String password, String title,
			String location, String description, String options[]) {
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
	}

	private boolean updatePool(Poll poll) {

		int index = getPollIndexByID(poll.getId());
		if (index != -1) {
			polls.set(index, poll);
			return true;
		} else
			return false;
	}

	public boolean closePoll(int pollID, User user) {
		Poll poll = getPollByID(pollID);

		if (poll == null)
			return false;

		if (!poll.getAuthor().equals(user.getUsername()))
			return false;

		poll.setClosed(true);

		return true;
	}

	public boolean vote(int pollID, User user, String options[]) {

		Poll poll = getPollByID(pollID);

		if (poll == null)
			return false;

		Response response = new Response(user.getUsername(), options);
		poll.addResponse(response);

		return true;
	}

	public String toString() {
		return String.format("{Poll Count: %d}", polls.size());
	}

}
