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
	public List<Poll> getPollS() {
		return ApplicationController.PC.getPolls();
	}

	@Path("/poll/{index}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Poll getPollByIndex(@PathParam("index") int index) {
		return ApplicationController.PC.getPollByIndex(index);
	}

	@Path("/poll/id/{ID}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Poll getPollByID(@PathParam("ID") int ID) {
		return ApplicationController.PC.getPollByID(ID);
	}

}
