package dao.test;

import java.util.*;
import server.*;
import bean.*;

public class XmlsGenerator {

	public static void main(String[] args) {
		ApplicationController.load();
		generateUsersXml();
		generatePollsXml();
	}

	private static void generateUsersXml() {
		ApplicationController.UC.clearUsers();

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
		ApplicationController.PC.clearPolls();

		// Poll 1
		Poll poll = new Poll();
		poll.setId(1);
		poll.setAuthor("bob");
		poll.setDescription("description");
		poll.setLocation("sydney");
		poll.setTitle("first poll");
		poll.setCreationDate(new Date());
		poll.setOptions(new Date[] { 
				Option.paseDateTime("2016-06-01 14:00"),
				Option.paseDateTime("2016-06-01 16:00"), 
				Option.paseDateTime("2016-06-01 18:00") 
				});

		Response r1 = new Response();
		r1.setName("visitor1");
		r1.setOptions(new int[] { 2, 3 });

		Response r2 = new Response();
		r2.setName("visitor2");
		r2.setOptions(new int[] { 2 });

		Response r3 = new Response();
		r3.setName("visitor3");
		r3.setOptions(new int[] { 1, 2 });

		poll.addResponse(r1);
		poll.addResponse(r2);
		poll.addResponse(r3);

		// Poll 2
		Poll poll2 = new Poll();
		poll2.setId(2);
		poll2.setAuthor("tom");
		poll2.setDescription("description");
		poll2.setLocation("sydney");
		poll2.setTitle("first poll");
		poll2.setCreationDate(new Date());
		poll2.setOptions(new Date[] { 
				Option.paseDateTime("2016-06-01 14:00"),
				Option.paseDateTime("2016-06-01 16:00"), 
				Option.paseDateTime("2016-06-01 18:00") 
				});

		Response r4 = new Response();
		r4.setName("visitor1");
		r4.setOptions(new int[] { 1, 2 });

		Response r5 = new Response();
		r5.setName("visitor2");
		r5.setOptions(new int[] { 3 });

		Response r6 = new Response();
		r6.setName("visitor3");
		r6.setOptions(new int[] { 1, 3 });

		poll2.addResponse(r4);
		poll2.addResponse(r5);
		poll2.addResponse(r6);

		// Add Polls
		ApplicationController.PC.addPoll(poll);
		ApplicationController.PC.addPoll(poll2);
		ApplicationController.save();

	}

}
