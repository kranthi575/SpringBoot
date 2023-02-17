<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./controller/editForm">
	<table>
			<tr>
				<td>Name</td>
				<td>${name}</td>
				<td><input type="text" name="sname" value=${name} ></input></td>
				
			</tr>
			<tr>
				<td>Age</td>
				<td>${age}</td>
				<td><input type="text" name="sage" value=${age} ></input></td>
				
			</tr>
			<tr>
				<td>Email</td>
				<td>${email}</td>
				<td><input type="email" name="semail" value=${email} ></input></td>
				
			</tr>
			<tr>
				<td>Country</td>
				<td>${country}</td>
				<td><input type="text" name="scountry" value=${country} ></input></td>
				
			</tr>
	
	</table>

	<button type="submit">Submit</button>
</form>

</body>
</html>