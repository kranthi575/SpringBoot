<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.center {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
  width:400px;
  height:400px;
}
</style>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body class="center">
<h1 style="color:Tomato;text-align:center;">Welcome to Login Page</h1>

<form action="./loginValidation" method="post">
	<table style="color:green">
		<tr>
			<td>User name</td>
			<td><input type="text" placeholder="enter username" name="uname"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" placeholder="enter password" name="pwd"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Login"></td>
		</tr>
	</table>
</form>
<p>${msg}</p>
</body>

<a href="/reg">Register</a>
</html>