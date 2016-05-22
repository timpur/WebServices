package server.rest;

import java.util.*;
import server.*;
import bean.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/service")
public class RestService {
	
	@Path("polls")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Poll> getPoll(){
		return ApplicationController.PC.getPolls();
	}
	
	

}
