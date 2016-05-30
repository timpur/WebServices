<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="bean.*, server.*"%>

<jsp:useBean id="sc" class="server.SessionController" scope="session">
</jsp:useBean>

<%
	String s = request.getParameter("id");
	int ID = -1;
	if (s != null) {
		ID = Integer.parseInt(s);
		String close = request.getParameter("close");

		if (close != null)
			if (close.equals("true")) {
				ApplicationController.PC.closePoll(ID, sc.currentUser);
				response.sendRedirect("details.jsp?id=" + ID);
			}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Poll Details</title>
</head>
<body
	style="width: 80%; margin-left: auto; margin-right: auto; padding: 20px;">
	<div style="float: right;">
		<span style="margin-right: 50px;"> <a href="index.jsp">Home</a>
		</span> <span> <%
 	if (sc.loggedin()) {
 		out.println("User Name: " + sc.currentUser.getUsername());
 		out.println("<input type='button' value='Logout' onclick='location.href=\"logout.jsp\";'/>");
 	} else {
 		out.println("<input type='button' value='Login' onclick='location.href=\"login.jsp\";'/>");
 	}
 %>
		</span>
	</div>
	<%
		if (sc.loggedin()) {
			out.println(sc.GetUserPollDetailsHTML(ID));
		} else {
			out.println(ApplicationController.getPollDetailsHTML(ID));
		}
	%>
</body>
</html>