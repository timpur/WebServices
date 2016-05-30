package bean;

import java.io.Serializable;
import java.util.*;

import javax.xml.bind.annotation.*;

import server.ApplicationController;

// This class contains a list of users and is used to authenticate
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class UsersController implements Serializable {
	private static final long serialVersionUID = 6206162451231640694L;

	@XmlElement(name = "user")
	private List<User> users;

	public UsersController() {
		this.users = new ArrayList<User>();
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> list) {
		this.users = list;
	}
	
	public void clearUsers(){
		users.clear();
	}
	
	//Find user by its username
	private User findUser(String username) {
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	
	//To create a user
	public boolean createUser(String userName, String password) {

		if (findUser(userName) != null)
			return false;

		// create a new user object
		User user = new User(userName, password);
		addUser(user);
		
		// Save XML
		ApplicationController.save();
		return true;
	}
	
	// To authenticate a user and return the user object
	public User authenticate(String username, String password) {
		// loop users
		for (User user : users) {
			// if any user match the given paramter, then login success
			if (user.getUsername().equals(username))
				if(user.getPassword().equals(password))
					return user;
		}

		// if nothing found then return null
		return null;

	}

}