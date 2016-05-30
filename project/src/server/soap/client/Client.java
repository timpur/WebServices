package server.soap.client;

import java.rmi.RemoteException;
import java.util.Calendar;

import javax.xml.rpc.ServiceException;

import static java.lang.System.out;

import java.io.*;

//SOAP Client that consumed that SOAP Service
public class Client {

	public static void main(String[] args) throws ServiceException,
			RemoteException {
		// TODO Auto-generated method stub
		SOAPServiceServiceLocator locator = new SOAPServiceServiceLocator();
		SOAPService service = locator.getSOAPServicePort();

		String line = "";

		int id = -1;
		do {
			line = readLine("Enter In Command: ");

			if (line.equals("create")) {
				Calendar c = Calendar.getInstance();
				c.set(Calendar.YEAR, 2016);
				c.set(Calendar.MONTH, 9);
				c.set(Calendar.DAY_OF_MONTH, 01);
				c.set(Calendar.HOUR, 14);

				Calendar[] dates = { c };
				id = service.createPoll("tim", "pass", "SOAP", "UTS",
						"SOAP Created This", dates);
			}
			else if(line.equals("close")){
				service.cloasePoll("tim", "pass", id);
			}

		} while (!line.equalsIgnoreCase("exit"));

		out.println("Finished");
	}

	private static String readLine(String prompt) {
		String line = null;
		Console c = System.console();
		if (c != null) {
			line = c.readLine(prompt);
		} else {
			System.out.print(prompt);
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(System.in));
			try {
				line = bufferedReader.readLine();
			} catch (IOException e) {
				// Ignore
			}
		}
		return line;
	}

}
