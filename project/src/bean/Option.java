package bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

//This class contains infor for each option
//An option has an id and a date
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Option {

	@XmlAttribute
	private int ID;
	@XmlElement()
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Calendar value;

	public Option() {
		// TODO Auto-generated constructor stub
	}

	public Option(int ID, Calendar value) {
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

	public Calendar getValue() {
		return value;
	}

	public void setValue(Calendar value) {
		this.value = value;
	}
	
	//Functions used to convert text to date format
	public static Calendar paseDateTime(String s) {
		try {
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm aa");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(ft.parse(s));
			return calendar;
		} catch (ParseException e) {
			return null;
		}
	}

	public static Calendar paseDate(String s) {
		try {
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(ft.parse(s));
			return calendar;
		} catch (ParseException e) {
			return null;
		}
	}

	public static Calendar paseTime(String s) {
		try {
			SimpleDateFormat ft = new SimpleDateFormat("HH:mm");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(ft.parse(s));
			return calendar;
		} catch (ParseException e) {
			return null;
		}
	}

}
