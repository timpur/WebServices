package bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "polls")
public class PollsController implements Serializable {
	private static final long serialVersionUID = -6191921116745752062L;
	
	@XmlElement(name = "poll")
	private ArrayList<Poll> polls;

	public PollsController() {
		this.polls = new ArrayList<Poll>();
	}

	public void addPoll(Poll poll) {
		this.polls.add(poll);
	}

	public ArrayList<Poll> getPolls() {
		return polls;
	}

	public void setPolls(ArrayList<Poll> list) {
		this.polls = list;
	}
	
	
	public Poll getPoll(int id) {
		// loop poll and find which has same id
		for (Poll poll : polls) {
			if (poll.getId() == id) {
				return poll;
			}
		}
		// if no poll found with given id
		return null;
	}

}
