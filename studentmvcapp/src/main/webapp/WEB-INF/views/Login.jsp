<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg = (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	/* margin: 15px 520px; */
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}
</style>
</head>
<body>
	<div align="center">
		<%if(msg != null){ %>
		<h4><%=msg %></h4>
		<%} %>
		<fieldset>
			<legend>Login Page</legend>
			<form action="./login" method="post">
				<table>
					<tr>
						<td><label for="username">Username</label></td>
						<td><input type="text" name="username" id="username">
					</tr>
					<tr>
						<td><label for="password">Password</label></td>
						<td><input type="password" name="password" id="password"></td>
					</tr>
				</table>
				<input type="submit" value="Login">
			</form>
		</fieldset>
		<a href="http://localhost:8080/studentmvcapp/createAccount">Create Account</a>
	</div>
</body>
</html>