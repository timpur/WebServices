package bean;

import java.util.List;

import javax.xml.bind.annotation.*;

//User object for containing information on a user
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class User {
	@XmlElement
	private String username;
	@XmlElement
	private String password;

	public User() {
		super();
	}
	public User(String username, String password) {	
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
