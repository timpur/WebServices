package bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Option {

	@XmlAttribute
	private int ID;
	@XmlElement()
	private Date value;

	public Option() {
		// TODO Auto-generated constructor stub
	}

	public Option(int ID, Date value) {
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

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}

	public static Date paseDateTime(String s) {
		try {
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			return ft.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static Date paseDate(String s) {
		try {
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			return ft.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static Date paseTime(String s) {
		try {
			SimpleDateFormat ft = new SimpleDateFormat("HH:mm");
			return ft.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
