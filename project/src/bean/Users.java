package bean;

import java.io.Serializable;
import java.util.*;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class Users implements Serializable {
	@XmlElement(name = "user")
	private ArrayList<User> list;

	public Users() {
		this.list = new ArrayList<User>();
	}

	public void addUser(User user) {
		this.list.add(user);
	}

	public ArrayList<User> getList() {
		return list;
	}

	public void setList(ArrayList<User> list) {
		this.list = list;
	}

}