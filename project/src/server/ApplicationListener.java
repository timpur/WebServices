package server;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// Used to load paths of the current web server since locations change during deployment
// Also used to load and save the xml data
public class ApplicationListener implements ServletContextListener {

	ServletContext server;

	public void contextInitialized(ServletContextEvent contextEvent) {
		System.out.println("Context Created");
		server = contextEvent.getServletContext();
		
		ApplicationController.WebPath = server.getRealPath("/");
		ApplicationController.PFilePath = server.getRealPath("/WEB-INF/polls.xml");
		ApplicationController.UFilePath = server.getRealPath("/WEB-INF/users.xml");
		ApplicationController.load();

	}

	public void contextDestroyed(ServletContextEvent contextEvent) {
		server = contextEvent.getServletContext();
		System.out.println("Context Destroyed");
		ApplicationController.save();
	}

}
