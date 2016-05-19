package bean;

import java.util.*;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
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
	@XmlElement(name = "option")
	private String[] options;

	@XmlElementWrapper(name = "responses")
	@XmlElement(name = "response")
	private List<Response> respsonses;

	public Poll() {
		this.creationDate = new Date();
		this.isClosed = false;
		this.respsonses = new ArrayList<Response>();
	}

	public void addResponse(Response response) {
		this.respsonses.add(response);
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

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public List<Response> getRespsonses() {
		return respsonses;
	}

	public void setRespsonses(List<Response> respsonses) {
		this.respsonses = respsonses;
	}
}
