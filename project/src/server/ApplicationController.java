package server;

import bean.*;

public class ApplicationController {
	
	public static String PFilePath = "WebContent/WEB-INF/polls.xml";
	public static FileController<PollsController> PFC;
	public static PollsController PC;
	
	public static String UFilePath = "WebContent/WEB-INF/users.xml";
	public static FileController<UsersController> UFC;
	public static UsersController UC;
	
	
	public static void load(){
		PFC = new FileController<PollsController>(PFilePath,PollsController.class);
		PC = PFC.load();
		
		UFC = new FileController<UsersController>(UFilePath,UsersController.class);
		UC = UFC.load();
		
	}
	public static void save(){
		PFC.save(PC);
		UFC.save(UC);
	}

}
