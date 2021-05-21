<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pranjal Employee App</title>
</head>
<body>
	<form action="addEmployee">
		Employee Name : <input type="text" name="name">
		Location : <input type="text" name="location">
		Email : <input type="email" name="email">
		DOB : <input type="text" name="dob">
	<input type="submit">
	</form>
	
	<form action="getEmployee">
		Employee ID : <input type="text" name="code">
	<input type="submit">
	</form>
	
</body>
</html>