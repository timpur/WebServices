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
	
	
	

	

	/**
	 * convert XML file into java objects
	 * 
	 * @return
	 */
	public static UsersController load() {

		UsersController users = null;
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(UsersController.class);
			Unmarshaller u = jc.createUnmarshaller();
			FileInputStream fin = new FileInputStream(FILEPATH);
			users = (UsersController) u.unmarshal(fin);
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
	public static void save(UsersController users) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(UsersController.class);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(users, new File(FILEPATH));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
