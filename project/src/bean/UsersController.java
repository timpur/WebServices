package bean;

import java.io.Serializable;
import java.util.*;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class UsersController implements Serializable {
	@XmlElement(name = "user")
	private ArrayList<User> users;

	public UsersController() {
		this.users = new ArrayList<User>();
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> list) {
		this.users = list;
	}

}