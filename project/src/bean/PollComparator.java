package bean;

import java.util.Comparator;

//used to compare one poll controller to another to order the list based off 3 orderbys
//by author, title and creation date
public class PollComparator implements Comparator<Poll> {
	String orderBy = "";

	public PollComparator(String orderby) {
		this.orderBy = orderby;
	}

	@Override
	public int compare(Poll p1, Poll p2) {
		// TODO Auto-generated method stub

		if (orderBy.equals("author"))
			return p1.getAuthor().compareToIgnoreCase(p2.getAuthor());
		else if (orderBy.equals("title"))
			return p1.getTitle().compareToIgnoreCase(p2.getTitle());
		else if (orderBy.equals("date"))
			return p1.getCreationDate().compareTo(p2.getCreationDate());
		else
			return 0;
	}

}
