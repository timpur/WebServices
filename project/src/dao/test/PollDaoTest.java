package dao.test;

import dao.PollDao;
import bean.Poll;

public class PollDaoTest {

	public static void main(String[] args) {
		Poll poll = PollDao.getPoll(1);
//		System.out.println(poll.getRespsonses().size());

		// PollDao.vote(1, "lee", new String[]{"19:00", "20:00"});
		// poll = PollDao.getPoll(1);
		// System.out.println(poll.getRespsonses().size());
		//

		System.out.println(PollDao.closePoll("bob", "sdsd", 1));
		System.out.println(PollDao.closePoll("username", "password", 1));
		System.out.println(PollDao.closePoll("bob", "bob", 1));


	}
}
