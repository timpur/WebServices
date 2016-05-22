package bean;

import java.util.*;

import javax.xml.bind.annotation.*;

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
	private Date creationDate;
	
	@XmlElement
	private String location;
	
	@XmlElement
	private String description;
	
	@XmlElement
	private boolean isClosed;
	
	@XmlElementWrapper(name = "options")
	private List<Option> options;

	@XmlElementWrapper(name = "responses")
	private List<Response> respsonses;

	public Poll() {
		this.creationDate = new Date();
		this.isClosed = false;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
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

	public boolean isClosed() {
		return isClosed;
	}

	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
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
	
	public void addOption(Option option){
		this.options.add(option);
	}
	
	public void addResponse(Response response){
		this.respsonses.add(response);
	}
	
	public void setOptions(String options[]) {
		int ID = findNextOptionID();
		for(String o : options){
			addOption(ID, o);
			++ID;
		}
	}
	
	public void addOption(int ID, String value){
		Option option = new Option(ID, value);
		this.options.add(option);
	}
	
	private int findNextOptionID(){
		int lastid = -1;
		for(Option option : options){
			if(option.getID() > lastid)
				lastid = option.getID();
		}
		return lastid + 1;
	}
	
}
