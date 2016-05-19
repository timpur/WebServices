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
	 * find a user object by username and password return null if not found
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static User login(String username, String password) {

		// load users from XML files
		UsersController users = load();

		// loop users
		for (User user : users.getUsers()) {
			// if any user match the given paramter, then login success
			if (user.getUsername().equals(username)
					&& user.getPassword().equals(password)) {
				return user;
			}
		}

		// if nothing found then return null
		return null;

	}

	/**
	 * sign up new user
	 * 
	 * if return 1, means sign up successful
	 * 
	 * if return 0, means existing username, and sign up fail
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static int signup(String username, String password) {

		User existingUser = findUser(username);
		if (existingUser != null) {
			// if there is any existing user, stop it
			return 0;
		}

		// create a new user object
		User user = new User(username, password);

		UsersController users = load();
		// add new user to existing users object
		users.addUser(user);

		// save the modified users into XML file
		save(users);
		return 1;
	}

	/**
	 * find existing user by username
	 * 
	 * return null if no user with such username
	 * 
	 * @param username
	 * @return
	 */
	private static User findUser(String username) {
		UsersController users = load();
		for (User user : users.getUsers()) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
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
