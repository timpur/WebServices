package server.rest;

import java.util.*;

import server.*;
import bean.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/service")
public class RestService {

	//Get all Polls Open and Closed
	@Path("/polls/all")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Poll> getAllPolls() {
		return ApplicationController.PC.getPolls();
	}

	//Get Polls using a filter. Default only show open polls
	@Path("/polls")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Poll> getPolls(@QueryParam("author") String author,
			@QueryParam("status") String status,
			@QueryParam("min") int minResponses) {

		if (status == null)
			status = "open";
		if (author == null)
			author = "";

		boolean stat = true;
		if (status.equals("open"))
			stat = true;
		else if (status.equals("closed"))
			stat = false;

		List<Poll> result = ApplicationController.PC.filterPolls(author, stat,
				minResponses);
		return result;
	}
	
	//Filter polls and then order the list of polls
	@Path("/polls/by/{order}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Poll> getPollsBy(@PathParam("order") String orderBy,
			@QueryParam("author") String author,
			@QueryParam("status") String status,
			@QueryParam("min") int minResponses) {
		List<Poll> result = getPolls(author, status, minResponses);
		
		Collections.sort(result, new PollComparator(orderBy));

		return result;
	}
	
	//Get a poll by its ID
	@Path("/poll/{ID}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Poll getPollByID(@PathParam("ID") int ID) {
		return ApplicationController.PC.getPollByID(ID);
	}

}
