<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.*, server.*"%>

<jsp:useBean id="sc" class="server.SessionController" scope="session">
</jsp:useBean>

<%
	String userName = request.getParameter("username");
	String password = request.getParameter("password");

	if (userName != null && password != null)
		sc.login(userName, password);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body style="width: 80%; margin-left: auto; margin-right: auto">
	<h1 align="center">Open Polls</h1>
	<div style="float: right;">
		<span style="margin-right:50px;"> 
			<a href="index.jsp">Home</a>
		</span>
		<span>
			<%
				if (sc.loggedin()) {
					out.println("User Name: " + sc.currentUser.getUsername());
					out.println("<input type='button' value='Create Poll' onclick='location.href=\"createpoll.jsp\";'/>");
					out.println("<input type='button' value='Logout' onclick='location.href=\"logout.jsp\";'/>");
				} else {
					out.println("<input type='button' value='Login' onclick='location.href=\"login.jsp\";'/>");
				}
			%>
		</span>
	</div>
	<div style="margin-top: 50px;">
		<%
			if (sc.loggedin()) {
				out.println(sc.GetUserPollsHTML());
			} else {
				out.println(ApplicationController.getPollsHTML());
			}
		%>
	</div>


</body>
</html>
