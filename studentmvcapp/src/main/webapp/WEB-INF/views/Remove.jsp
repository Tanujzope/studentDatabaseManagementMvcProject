<%@page import="com.jspiders.studentmvcapp.pojo.StudentPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="NavBar.jsp"></jsp:include>
    <%List<StudentPojo> students = (List<StudentPojo>) request.getAttribute("students");
    String msg = (String)request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Remove Student</legend>
			<form action="./remove" method="post">
				<table>
					<tr>
						<td><label for="id">Enter Id</label></td>
						<td><input type="text" name="id" id="id"></td>
					</tr>
				</table>
				<input type="submit" value="Remove Student">
			</form>
		</fieldset>
		<%if(msg != null){ %>
		<h3><%=msg %></h3>
		<%}
		if(students != null){%>
		<table id="data">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>CONTACT</th>
				<th>ADDRESS</th>
			</tr>
			<%
			for(StudentPojo pojo:students){
			%>
			<tr>
				<td><%=pojo.getId() %></td>
				<td><%=pojo.getName() %></td>
				<td><%=pojo.getEmail() %></td>
				<td><%=pojo.getContact() %></td>
				<td><%=pojo.getAddress() %></td>
			</tr>
			<%} %>
		</table>
		<%} %>
		
	</div>
</body>
</html>