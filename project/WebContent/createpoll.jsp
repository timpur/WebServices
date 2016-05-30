<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="bean.*, server.*"%>

<jsp:useBean id="sc" class="server.SessionController" scope="session">
</jsp:useBean>

<%
	if(!sc.loggedin()){
		response.sendRedirect("login.jsp");
	}

	boolean loadData = false;
	String create = request.getParameter("create");
	String title = "";
	String location = "";
	String description = "";
	String[] options = {""};
	if (create != null) {
		title = request.getParameter("title");
		location = request.getParameter("location");
		description = request.getParameter("description");
		options = request.getParameterValues("option");
		if(sc.verifyDates(options)){
	sc.createPoll(title, location, description, options);
	response.sendRedirect("index.jsp");
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function addOption() {
		var el = document.getElementById("option");
		document.getElementById("options").appendChild(el.cloneNode(false));
	}
</script>
</head>
<body style="width: 80%; margin-left: auto; margin-right: auto">
	<h1 align="center">Create Poll</h1>
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
	<div
		style="width: 300px; margin-left: auto; margin-right: auto; margin-top: 50px;">
		<form action="createpoll.jsp" method="post">
			<table>
				<tr>
					<td><label for="title">Title</label></td>
					<td><input name="title" type="text" value="<%=title%>" /></td>
				</tr>
				<tr>
					<td><label for="location">Location</label></td>
					<td><input name="location" type="text" value="<%=location%>" /></td>
				</tr>
				<tr>
					<td><label for="description">Description</label></td>
					<td><input name="description" type="text"
						value="<%=description%>" /></td>
				</tr>
				<tr>
					<td><br /></td>
				</tr>
				<tr>
					<td><label for="option">Options</label></td>
					<td id="options">
						<%
							for(String s : options){
																		out.println("<input id='option' name='option' type='text' value='" + s + "' />");
																	}
						%>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="button" value="Add Opption"
						onclick="addOption();" /></td>
				</tr>
				<tr>
					<td><input type="hidden" name="create" value="poll"></td>
					<td><input type="submit" value="Create Poll" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>