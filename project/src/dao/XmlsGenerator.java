package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import bean.*;

public class XmlsGenerator {

	public static void main(String[] args) {
		generatePollsXml();
		generateUsersXml();
	}

	private static void generateUsersXml() {
		User user1 = new User();
		user1.setPassword("password");
		user1.setUsername("username");

		User user2 = new User();
		user2.setPassword("password1");
		user2.setUsername("username1");

		UsersController users = new UsersController();

		ArrayList<User> userList = new ArrayList<User>();

		userList.add(user1);
		userList.add(user2);

		users.setUsers(userList);

		UserDao.save(users);
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

		PollsController polls = new PollsController();
		ArrayList<Poll> pollList = new ArrayList<Poll>();
		pollList.add(poll);
		pollList.add(poll2);
		polls.setPolls(pollList);

		// Boilerplate code to convert objects to XML...
		PollDao.save(polls);

	}

}
