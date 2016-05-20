package bean;

import java.io.Serializable;
import java.util.*;

import javax.xml.bind.annotation.*;

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

	private User findUser(String username) {
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public boolean addUser(String userName, String password) {

		if (findUser(userName) != null)
			return false;

		// create a new user object
		User user = new User(userName, password);
		addUser(user);

		return true;
	}

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