<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="sc" class="server.SessionController" scope="session">
</jsp:useBean>

<%
	sc.logout();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logout</title>
</head>
<body style="width: 80%; margin-left: auto; margin-right: auto">
	<h1 align="center">Logout Successful</h1>
	<h2>Go to <a href="login.jsp">Login</a></h2>
	<h2>Go to <a href="index.jsp">Main Page</a></h2>
</body>
</html>