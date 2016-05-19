package restservice;

import dao.PollDao;

public class RestServiceSample {

	public void showListOfPollsOnPage(){
		PollDao.setFilPath("WebContent/WEB-INF/polls.xml");
		PollDao.getPolls();
	}
}
