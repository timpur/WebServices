package bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "polls")
public class Polls implements Serializable {
	@XmlElement(name = "poll")
	private ArrayList<Poll> list = new ArrayList<Poll>();

	public ArrayList<Poll> getList() {
		return list;
	}

	public void setList(ArrayList<Poll> list) {
		this.list = list;
	}

}
