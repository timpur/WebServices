<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="bean.*, server.*"%>
<%
	int ID = Integer.parseInt(request.getParameter("id"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Poll Details</title>
</head>
<body style="width:80%;margin-left:auto;margin-right:auto;padding:20px;">
	<%=ApplicationController.getPollDetailsHTML(ID)%>
</body>
</html>