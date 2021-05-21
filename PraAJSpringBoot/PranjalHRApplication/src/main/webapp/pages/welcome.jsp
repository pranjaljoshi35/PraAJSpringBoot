<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <title>Pranjal Assignment</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>welcome ${name} to employee management</h1>	
	
	<form action="uploadEmployee">
		<b>Upload Employee : </b><button type="submit" class="btn btn-default">click here</button>
	</form>
	<br><br>
	<table class="table">
	    <tr>
	      <td><p><b>Code</b></p><td>
	      <td><p><b>Name</b></p><td>
	      <td><p><b>Location</b></p><td>
	      <td><p><b>Email</b></p><td>
	      <td><p><b>DOB</b></p><td>
	    </tr>
	  	<c:forEach items="${allEmployee}" var="emp">
		<tr>
	    	<td><p>${emp.code}</p><td>
	    	<td><p>${emp.name}</p><td>
	    	<td><p>${emp.location}</p><td>
	    	<td><p>${emp.email}</p><td>
	    	<td><p>${emp.dob}</p><td>
	    </tr>
		</c:forEach>
</table>

<!-- Footer -->
<footer class="page-footer font-small blue">

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2021 Copyright:
    <a href="https://www.nagarro.com/en"> Nagarro.com</a>
  </div>
  <!-- Copyright -->

</footer>
	
</body>
</html>