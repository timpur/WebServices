package bean;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Option {
	
	@XmlAttribute
	private int ID;
	@XmlElement()
	private String value;
	
	public Option() {
		// TODO Auto-generated constructor stub
	}
	
	public Option(int ID, String value) {
		// TODO Auto-generated constructor stub
		this.ID = ID;
		this.value = value;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
