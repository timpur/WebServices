package server;

import bean.*;

public class SessionController {

	User currentUser;

	public SessionController() {
		// TODO Auto-generated constructor stub
	}

	public boolean login(String userName, String password) {
		currentUser = ApplicationController.UC.authenticate(userName, password);

		if (currentUser != null)
			return true;
		else
			return false;
	}

	public boolean createPoll(String username, String password, String title,
			String location, String description, String options[]) {
		// Verifiy poll data if not correct return false
		// Then add
		ApplicationController.PC.createPoll(username, password, title,
				location, description, options);
		
		return true;
	}

}
