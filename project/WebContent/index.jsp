<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.*, server.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebServices</title>
</head>
<body style="width: 80%; margin-left: auto; margin-right: auto">
	<h1 align="center">Open Polls</h1>
	<div>
		<%=ApplicationController.getPollsHTML()%>
	</div>


</body>
</html>
