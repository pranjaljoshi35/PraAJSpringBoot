<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.nagarro.web.model.User"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="com.nagarro.web.model.Image" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pranjal Image Management Utility</title>
<style type="text/css">
body{
	width: inherit;
    border: 1px solid gray;
	padding: 10px;
	margin: 20px;
	background-color: #C8C8C8;
	border-radius: 5px;
	
}

</style>
</head>
<body >
	<%
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("index.jsp");
		}
	%>
	<h2 style="color:solid gray;text-align:center; width: inherit; border: 1px solid gray; border-radius: 3px; background-color: #D8D8D8">Welcome to Image Management Utility</h2>
	<div style="margin: 20px;">
	Select an Upload your Image file using Pranjal ImageUtility Tool (Image size should not be bigger than 1MB)
	<br><br>
	<form action="imageservlet">
		Please enter Image link to upload : <input type="text" name="imglink" placeholder = "Enter Image link here">
		<input type="submit" value="Upload">    <input type="reset" value="Cancel">
	
	</form>

	
	
</body>
</html>