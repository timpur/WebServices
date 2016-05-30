package bean;

import java.util.*;
import javax.xml.bind.annotation.adapters.*;
import javax.xml.bind.annotation.*;

//The poll class contains data and functions
//The functions are used to get, set, and change the data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "poll")
public class Poll {
	@XmlElement
	private int id;

	@XmlElement
	private String title;

	@XmlElement
	private String author;

	@XmlElement
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Calendar creationDate;

	@XmlElement
	private String location;

	@XmlElement
	private String description;

	@XmlElement
	@XmlJavaTypeAdapter(StatusAdapter.class)
	private Boolean status;

	@XmlElementWrapper(name = "options")
	@XmlElement(name = "option")
	private List<Option> options;

	@XmlElementWrapper(name = "responses")
	@XmlElement(name = "response")
	private List<Response> respsonses;

	public Poll() {
		this.creationDate = new GregorianCalendar();
		this.creationDate.set(Calendar.MILLISECOND, 0);
		this.status = true;
		this.respsonses = new ArrayList<Response>();
		this.options = new ArrayList<Option>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public List<Response> getRespsonses() {
		return respsonses;
	}

	public void setRespsonses(List<Response> respsonses) {
		this.respsonses = respsonses;
	}

	public void addOption(Option option) {
		this.options.add(option);
	}

	public void addResponse(Response response) {
		this.respsonses.add(response);
	}

	public void addResponse(String name, String[] options) {
		Response response = new Response(name, options);
		this.respsonses.add(response);
	}

	public void setOptions(Calendar options[]) {
		int ID = findNextOptionID();
		for (Calendar o : options) {
			if (o != null)
				addOption(ID, o);
			++ID;
		}
	}

	public void addOption(int ID, Calendar value) {
		Option option = new Option(ID, value);
		this.options.add(option);
	}

	private int findNextOptionID() {
		int lastid = -1;
		for (Option option : options) {
			if (option.getID() > lastid)
				lastid = option.getID();
		}
		return lastid + 1;
	}

	private Option getOptionByID(int ID) {
		for (Option o : options) {
			if (o.getID() == ID)
				return o;
		}
		return null;
	}

}


// used to conver that status boolean to a string like opean and closed for display
class StatusAdapter extends XmlAdapter<String, Boolean> {
	@Override
	public String marshal(Boolean v) throws Exception {
		return v ? "Open" : "Closed";
	}

	@Override
	public Boolean unmarshal(String v) throws Exception {
		if (v.equals("Opean"))
			return true;
		else if (v.equals("Closed"))
			return false;
		else
			throw new Exception("Status can not be converted to boolean");
	}

}
