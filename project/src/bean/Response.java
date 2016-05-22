package bean;

import java.util.*;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response")
public class Response {
	@XmlElement(name = "name")
	private String name;

	@XmlElementWrapper(name = "options")
	private List<Option> options;

	public Response() {
		options = new ArrayList<Option>();
	}

	public Response(String name, List<Option> options) {
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

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}
		
	public void addOption(Option option){
		this.options.add(option);
	}
	
	public void setOptions(String options[]) {
		int ID = findNextOptionID();
		for(String o : options){
			addOption(ID, o);
			++ID;
		}
	}
	
	public void setOptions(int options[]) {
		for(int ID : options){
			addOption(ID, null);
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
