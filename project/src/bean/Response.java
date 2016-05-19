package bean;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Response {
	@XmlElement
	private String name;

	@XmlElementWrapper(name = "options")
	@XmlElement(name = "option")
	private String[] options;

	public Response() {
	}

	public Response(String name, String[] options) {
		super();
		this.name = name;
		this.options = options;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

}
