<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="bean.*, server.*"%>
	
<jsp:useBean id="sc" class="server.SessionController" scope="session">
</jsp:useBean>
	
<%
	String id = request.getParameter("id");
	int ID = -1;
	String name = request.getParameter("name");
	String[] options = request.getParameterValues("option");
	
	if(id != null){
		ID = Integer.parseInt(id);
	}
	
	if (ID != -1 && options != null) {
		
		ApplicationController.PC.getPollByID(ID).addResponse(name,
				options);

	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Poll Summary</title>
</head>
<body style="width: 80%; margin-left: auto; margin-right: auto; padding: 20px;">
	<div style="float: right;">
		<span style="margin-right: 50px;">
			<a href="index.jsp">Home</a>
		</span>
		<span>
			<%
				if (sc.loggedin()) {
					out.println("User Name: " + sc.currentUser.getUsername());
					out.println("<input type='button' value='Logout' onclick='location.href=\"logout.jsp\";'/>");
				} else {
					out.println("<input type='button' value='Login' onclick='location.href=\"login.jsp\";'/>");
				}
			%>
		</span>
	</div>
	<%=ApplicationController.getPollSummeryHTML(ID)%>
</body>
</html>