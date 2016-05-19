package bean;

import java.io.Serializable;
import java.util.*;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class UsersController implements Serializable {
	private static final long serialVersionUID = 531979471679705125L;
	
	@XmlElement(name = "user")
	private ArrayList<User> users = new ArrayList<User>();
	
	

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> list) {
		this.users = list;
	}
	
	public static User login(String username, String password){
		return null;
	}

	public static User signup(String username, String password){
		return null;
	}

}