package server;

import bean.*;
import java.util.*;

public class SessionController {

	public User currentUser;

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

	public void logout() {
		currentUser = null;
	}

	public boolean loggedin() {
		return currentUser != null ? true : false;
	}

	public boolean verifyDates(String dates[]) {
		boolean okay = true;
		for (int i = 0; i < dates.length; ++i) {
			Calendar date = Option.paseDateTime(dates[i]);
			if (date == null) {
				dates[i] = "";
				okay = false;
			}
		}
		return okay;
	}

	public boolean verifyPoll(int ID) {
		if (loggedin())
			if (ApplicationController.PC.validatePoll(ID,
					currentUser.getUsername()))
				return true;
		
		return false;
	}

	public boolean createPoll(String title, String location,
			String description, String dates[]) {
		// Verifiy poll data if not correct return false
		// Then add
		Calendar[] options = new Calendar[dates.length];

		for (int i = 0; i < dates.length; ++i) {
			Calendar date = Option.paseDateTime(dates[i]);
			if (date != null) {
				options[i] = date;
			}
		}

		ApplicationController.PC.createPoll(currentUser.getUsername(), title,
				location, description, options);

		return true;
	}

	public String GetUserPollsHTML() {
		if (loggedin())
			return ApplicationController
					.getPollsHTML(currentUser.getUsername());
		else
			return "";
	}

	public String GetUserPollDetailsHTML(int ID) {
		if (verifyPoll(ID))
			return ApplicationController.getUserPollDetailsHTML(ID);

		return "POLL DOES NOT EXIST OR YOU DONT HAVE PERMISSIONS TO EDIT THIS POLL";
	}

}
