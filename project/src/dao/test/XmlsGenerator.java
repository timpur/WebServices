package dao.test;

import java.util.*;
import server.*;
import bean.*;

public class XmlsGenerator {

	public static void main(String[] args) {
		generatePollsXml();
		generateUsersXml();
	}

	private static void generateUsersXml() {
		User user1 = new User();
		user1.setUsername("tim");
		user1.setPassword("pass");
		

		User user2 = new User();

		user2.setUsername("test");
		user2.setPassword("pass");

		ApplicationController.UC.addUser(user1);
		ApplicationController.UC.addUser(user2);
		ApplicationController.save();
	}

	public static void generatePollsXml() {
		Poll poll = new Poll();
		poll.setId(1);
		poll.setAuthor("bob");
		poll.setDescription("description");
		poll.setLocation("sydney");
		poll.setTitle("first poll");
		poll.setCreationDate(new Date());
		poll.setOptions(new String[] { "18pm", "19:00", "20:00" });

		Response r1 = new Response();
		r1.setName("visitor1");
		r1.setOptions(new String[] { "19:00", "20:00" });

		Response r2 = new Response();
		r2.setName("visitor2");
		r2.setOptions(new String[] { "19:00" });

		Response r3 = new Response();
		r3.setName("visitor3");
		r3.setOptions(new String[] { "18pm", "19:00" });

		List<Response> respsonses = new ArrayList<Response>();

		respsonses.add(r1);
		respsonses.add(r2);
		respsonses.add(r3);

		poll.setRespsonses(respsonses);

		Poll poll2 = new Poll();
		poll2.setId(2);
		poll2.setAuthor("tom");
		poll2.setDescription("description");
		poll2.setLocation("sydney");
		poll2.setTitle("first poll");
		poll2.setCreationDate(new Date());
		poll2.setOptions(new String[] { "18pm", "19:00", "20:00" });

		Response r4 = new Response();
		r4.setName("visitor1");
		r4.setOptions(new String[] { "19:00", "20:00" });

		Response r5 = new Response();
		r5.setName("visitor2");
		r5.setOptions(new String[] { "19:00" });

		Response r6 = new Response();
		r6.setName("visitor3");
		r6.setOptions(new String[] { "18pm", "19:00" });

		List<Response> respsonses2 = new ArrayList<Response>();

		respsonses2.add(r4);
		respsonses2.add(r5);
		respsonses2.add(r6);

		poll2.setRespsonses(respsonses2);

		
		
		ApplicationController.PC.addPoll(poll);
		ApplicationController.PC.addPoll(poll2);
		ApplicationController.save();

	}

}
