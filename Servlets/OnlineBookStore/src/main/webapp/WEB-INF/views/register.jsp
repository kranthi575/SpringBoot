<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
.center {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
  width:600px;
  height:600px;
}

</style>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body class="center">
<h1 style="color:Tomato;text-align:center;">Registration Page</h1>
<form action="./register" method="post">
<table>
	<tr>
		<th>UserName</th>
		<td><input type="text" placeholder="enter user name" name="uname"></td>	
	</tr>
	<tr>
		<th>Name</th>
		<td><input type="text" placeholder="enter name" name="name"></td>	
	</tr>
	<tr>
		<th>Phone Number</th>
		<td><input type="text" placeholder="enter phone number:" name="phnno"></td>	
	</tr>
	<tr>
		<th>Email</th>
		<td><input type="mail" placeholder="enter email" name="email" ></td>
	</tr>
	<tr>
		<th>City</th>
		<td><input type="text" placeholder="enter your city" name="city" ></td>
	</tr>
	<tr>
		<th>Password</th>
		<td><input type="password" placeholder="enter password" name="pwd" ></td>
	</tr>
	
		<td><input type="submit" value="Register"></td>
	</tr>
</table>
</form>
<p>${msg}</p>
</body>
</html>