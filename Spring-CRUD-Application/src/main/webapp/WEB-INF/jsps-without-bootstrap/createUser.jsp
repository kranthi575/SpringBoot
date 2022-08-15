<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>create user</title>
</head>
<body>
<h1>Spring CRUD Application</h1>
<h2>Create User</h2>

<form action="saveUser" method="post">
Id:<input type="text" name="id" readonly="readonly"><br>
LoginId:<input type="text" name="loginid"><br>
Name:<input type="text" name="name"><br>
Status:Active<input type="radio" name="status" value="ACTIVE">
	   Inactive<input type="radio" name="status" value="INACTIVE"><br>
	   
<input type="submit" value="SAVE">
</form>

${msg}
</body>
<a href="viewAll">View All Users</a>
</html>