<%@page import="com.jspiders.studentmvcapp.pojo.StudentPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%List<StudentPojo> students = (List<StudentPojo>)request.getAttribute("students");
String msg = (String) request.getAttribute("msg");
%>
 <jsp:include page="NavBar.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Add Students Data</legend>
			<form action="./add" method="post">
				<table>
					<tr>
						<td><label for="name">Name</label></td>
						<td><input type="text" name="name" id="name"></td>
					</tr>
					<tr>
						<td><label for="email">Email</label></td>
						<td><input type="email" name="email" id="email"></td>
					</tr>
					<tr>
						<td><label for="contact">Contact</label></td>
						<td><input type="text" name="contact" id="contact"></td>
					</tr>
					<tr>
						<td><label for="address">Address</label> </td>
						<td><input type="text" name="address" id="address"></td>
					</tr>
				</table>
				<input type="submit" value="ADD STUDENT">
			</form>
		</fieldset>
		
		<%
		if(msg != null){
		%>
		<h3><%=msg %></h3>
		<%} %>
		<%
		if(students != null){
		%>
		<table id="data" border=1>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>CONTACT</th>
				<th>ADDRESS</th>
			</tr>
			<% for(StudentPojo pojo :students){ %>
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