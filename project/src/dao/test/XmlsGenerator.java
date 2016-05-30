package dao.test;

import java.util.*;
import server.*;
import bean.*;

public class XmlsGenerator {

	public static void main(String[] args) {
		ApplicationController.load();
		generateUsersXml();
		generatePollsXml();
		ApplicationController.save();
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
		poll.setOptions(new Calendar[] {
				Option.paseDateTime("2016-06-01 2:00 PM"),
				Option.paseDateTime("2016-06-01 04:00 PM"),
				Option.paseDateTime("2016-06-01 06:00 PM") });

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
		poll2.setStatus(true);
		poll2.setAuthor("tim");
		poll2.setDescription("description");
		poll2.setLocation("sydney");
		poll2.setTitle("first poll");
		poll2.setOptions(new Calendar[] {
				Option.paseDateTime("2016-06-01 2:00 PM"),
				Option.paseDateTime("2016-06-01 04:00 PM"),
				Option.paseDateTime("2016-06-01 06:00 PM") });

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

		// poll 3
		Poll poll3 = new Poll();
		poll3.setId(3);
		poll3.setStatus(false);
		poll3.setAuthor("tim");
		poll3.setDescription("description");
		poll3.setLocation("sydney");
		poll3.setTitle("first poll");
		poll3.setOptions(new Calendar[] {
				Option.paseDateTime("2016-06-01 2:00 PM"),
				Option.paseDateTime("2016-06-01 04:00 PM"),
				Option.paseDateTime("2016-06-01 06:00 PM") });

		// Add Polls
		ApplicationController.PC.addPoll(poll);
		ApplicationController.PC.addPoll(poll2);
		ApplicationController.PC.addPoll(poll3);

		// test create poll function works
		ApplicationController.PC.createPoll(
				"author",
				"a title",
				"location",
				"description",
				new Calendar[] { Option.paseDateTime("2016-06-01 2:00 PM"),
						Option.paseDateTime("2016-06-01 04:00 PM"),
						Option.paseDateTime("2016-06-01 06:00 PM") });

	}

}
