package bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "polls")
public class PollsController implements Serializable {
	private static final long serialVersionUID = -375877679858815559L;
	
	@XmlElement(name = "poll")
	private ArrayList<Poll> polls = new ArrayList<Poll>();

	public ArrayList<Poll> getPolls() {
		return polls;
	}

	public void setPolls(ArrayList<Poll> list) {
		this.polls = list;
	}
	
	public static Poll getPoll(int id) {
		return null;
	}

	public static void createPoll(Poll poll) {

	}

	public static void vote(int id, Response resp) {

	}

}
