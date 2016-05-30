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

		User user3 = new User();
		user3.setUsername("david");
		user3.setPassword("pass");

		User user4 = new User();
		user4.setUsername("makean");
		user4.setPassword("pass");

		ApplicationController.UC.addUser(user1);
		ApplicationController.UC.addUser(user2);
		ApplicationController.UC.addUser(user3);
		ApplicationController.UC.addUser(user4);
	}

	public static void generatePollsXml() {
		ApplicationController.PC.clearPolls();

		// Poll 1
		Poll poll = new Poll();
		poll.setId(1);
		poll.setAuthor("david");
		poll.setDescription("This is a test");
		poll.setLocation("sydney");
		poll.setTitle("First Poll");
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
		poll2.setDescription("UTS Web Services Demo Time.");
		poll2.setLocation("UTS");
		poll2.setTitle("Web Services Demo");
		poll2.setOptions(new Calendar[] {
				Option.paseDateTime("2016-06-01 2:00 PM"),
				Option.paseDateTime("2016-06-01 04:00 PM"),
				Option.paseDateTime("2016-06-01 06:00 PM") });

		Response r4 = new Response();
		r4.setName("visitor1");
		r4.setOptions(new int[] { 1, 2 });

		poll2.addResponse(r4);

		// poll 3
		Poll poll3 = new Poll();
		poll3.setId(3);
		poll3.setStatus(false);
		poll3.setAuthor("tim");
		poll3.setDescription("For The LOLS");
		poll3.setLocation("UTS");
		poll3.setTitle("Networking Assignment");
		poll3.setOptions(new Calendar[] {
				Option.paseDateTime("2016-06-01 2:00 PM"),
				Option.paseDateTime("2016-06-01 04:00 PM"),
				Option.paseDateTime("2016-06-01 06:00 PM") });
		

		// Add Polls
		ApplicationController.PC.addPoll(poll);
		ApplicationController.PC.addPoll(poll2);
		ApplicationController.PC.addPoll(poll3);


	}

}
