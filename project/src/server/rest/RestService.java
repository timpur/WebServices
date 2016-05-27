package server.rest;

import java.util.*;
import server.*;
import bean.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/service")
public class RestService {

	@Path("/polls")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Poll> getPollS(@QueryParam("creator") String creator,
			@QueryParam("status") String status,
			@QueryParam("minResponses") Integer minResponses) {
		List<Poll> polls = ApplicationController.PC.getPolls();

		// clone the original list, don't modify the original list
		List<Poll> resultList = new ArrayList<Poll>();
		for (Poll poll : polls) {
			resultList.add(poll);
		}

		Iterator<Poll> it = resultList.iterator();
		while (it.hasNext()) {
			Poll poll = it.next();

			// if need to filter by creator,
			if (creator != null && !creator.isEmpty()) {
				// remove polls created by other user
				if (!creator.equalsIgnoreCase(poll.getAuthor())) {
					it.remove();
					continue;
				}
			}

			// if need to filter by status,
			if (status != null && !status.isEmpty()) {
				// if status is closed
				if (status.equals("closed")) {
					// remove all opened poll
					if (!poll.isClosed()) {
						it.remove();
						continue;
					}
				}
				// if status is open
				else if (status.equals("open")) {
					// remove all closed poll
					if (poll.isClosed()) {
						it.remove();
						continue;
					}

				}
			}

			// filter by minResponses
			if (minResponses != null && minResponses > 0) {
				if (poll.getRespsonses().size() < minResponses) {
					it.remove();
					continue;
				}
			}

		}

		return resultList;
	}

	@Path("/polls/{ID}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Poll getPollByID(@PathParam("ID") int ID) {
		return ApplicationController.PC.getPollByID(ID);
	}

}
