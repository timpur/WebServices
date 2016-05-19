package dao;

import bean.*;

public class PollDao {
	public static String FilePath = "WebContent/WEB-INF/polls.xml";
	
	public static FileController<PollsController> fc = new FileController<PollsController>(FilePath,PollsController.class);

	public static PollsController pc;
	
	public static void load() {
		pc = fc.load();
	}
	
	public static void save(){
		fc.save(pc);
	}

	
}
