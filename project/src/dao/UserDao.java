package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import bean.*;

public class UserDao {

	public static String FILEPATH = "WebContent/WEB-INF/users.xml";

	public static void setFilPath(String filePath) {
		FILEPATH = filePath;
	}
	
	
	public static User login(String username, String password){
		return null;
	}

	public static User signup(String username, String password){
		return null;
	}

	

	/**
	 * convert XML file into java objects
	 * 
	 * @return
	 */
	public static Users load() {

		Users users = null;
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Users.class);
			Unmarshaller u = jc.createUnmarshaller();
			FileInputStream fin = new FileInputStream(FILEPATH);
			users = (Users) u.unmarshal(fin);
			fin.close();
			return users;
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * convert java objects into XML file
	 * 
	 * @param users
	 */
	public static void save(Users users) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Users.class);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(users, new File(FILEPATH));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
