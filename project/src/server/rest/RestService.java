package server.rest;

import java.util.*;

import server.*;
import bean.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/service")
public class RestService {

	@Path("/polls/all")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Poll> getPollS() {
		return ApplicationController.PC.getPolls();
	}

	@Path("/polls")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Poll> getPollS(@QueryParam("author") String creator,
			@QueryParam("status") String status,
			@QueryParam("min") int minResponses) {

		if (status == null)
			status = "opean";
		if (creator == null)
			creator = "";

		boolean stat = true;
		if (status.equals("opean"))
			stat = true;
		else if (status.equals("closed"))
			stat = false;

		List<Poll> result = ApplicationController.PC.filterPolls(creator, stat,
				minResponses);
		return result;
	}

	@Path("/polls/by/{order}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Poll> getPollsBy(@PathParam("order") String orderBy,
			@QueryParam("author") String creator,
			@QueryParam("status") String status,
			@QueryParam("min") int minResponses) {
		List<Poll> result = getPollS(creator, status, minResponses);

		result.sort(new PollCompare(orderBy));

		return result;
	}

	@Path("/poll/{ID}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Poll getPollByID(@PathParam("ID") int ID) {
		return ApplicationController.PC.getPollByID(ID);
	}

}
