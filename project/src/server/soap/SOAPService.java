package server.soap;

import java.util.*;
import server.*;
import bean.*;

import javax.jws.WebService;
import javax.jws.WebMethod;


@WebService
public class SOAPService {

	//Get all Polls Open and Closed
	@WebMethod
	public List<Poll> getAllPolls() {
		return ApplicationController.PC.getPolls();
	}

	//Get Polls using a filter. Default only show open polls
	@WebMethod
	public List<Poll> getPolls(String author, boolean status, int minResponses) {
		if (author == null)
			author = "";

		List<Poll> result = ApplicationController.PC.filterPolls(author,
				status, minResponses);
		return result;
	}

	//Filter polls and then order the list of polls
	@WebMethod
	public List<Poll> getPollsBy(String orderBy, String author, boolean status,
			int minResponses) {
		List<Poll> result = getPolls(author, status, minResponses);

		Collections.sort(result, new PollComparator(orderBy));

		return result;
	}

	//Get a poll by its ID
	@WebMethod
	public Poll getPollByID(int ID) {
		return ApplicationController.PC.getPollByID(ID);
	}

	//Create a poll. Must authenticate when doing so
	@WebMethod
	public int CreatePoll(String username, String password, String title,
			String location, String description, Calendar[] dates) {
		if (ApplicationController.UC.authenticate(username, password) != null)
			return ApplicationController.PC.createPoll(username, title,
					location, description, dates);
		return -1;
	}
	
	//Close a poll. Must authenticate when doing so.
	@WebMethod
	public boolean cloasePoll(String username, String password, int ID) {
		if (ApplicationController.UC.authenticate(username, password) != null) {
			if (ApplicationController.PC.validatePoll(ID, username)) {
				ApplicationController.PC.getPollByID(ID).setStatus(false);
				return true;
			}
		}
		return false;
	}

}
