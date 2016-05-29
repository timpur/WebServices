<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="bean.*, server.*"%>
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
<title>Insert title here</title>
</head>
<body>
	<%=ApplicationController.getPollSummeryHTML(ID)%>
</body>
</html>