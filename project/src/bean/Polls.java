package bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "polls")
public class Polls implements Serializable {
	@XmlElement(name = "poll")
	private ArrayList<Poll> list;

	public Polls() {
		this.list = new ArrayList<Poll>();
	}

	public void addPoll(Poll poll) {
		this.list.add(poll);
	}

	public ArrayList<Poll> getList() {
		return list;
	}

	public void setList(ArrayList<Poll> list) {
		this.list = list;
	}

}
