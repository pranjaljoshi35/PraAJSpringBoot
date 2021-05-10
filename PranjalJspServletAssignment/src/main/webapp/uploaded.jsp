<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.nagarro.web.model.User"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="com.nagarro.web.model.Image" %>
<%@page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pranjal Assignment</title>
<style type="text/css">
body{
	width: 100%;
    border: 1px solid gray;
	padding: 10px;
	margin: 20px;
	border-radius: 7px;
	background-color: #C8C8C8;
	height: 100%;
	
}
td {
	margin-left: auto;
  	margin-right: auto;
	text-align: center;
	border: 1px solid gray;
	width: inherit;
	position:center;
	color: black;
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
	<h2 style="color:solid gray;text-align:center; width: inherit; border: 1px solid gray;">Welcome to Image Management Utility</h2>
	<div style="margin: 20px;">
	Please select an image file to upload (max. size 1MB can be uploaded)
	<br><br>
	<form action="imageservlet">
		Please Enter image link To Upload : <input type="text" name="imglink" required>
		<input type="submit" value="Upload">   
		<input type="reset" value="Cancel">
	</form>
	
	<h5><b>Uploaded Images</b></h5>
	
	<%ArrayList<Image> data =(ArrayList<Image>)session.getAttribute("images");%>
	<table>
	<% for(int i = 0; i < data.size(); i+=1){ %>
		<tr>
		    <td><span>S.NO.</span></td>
			<td><%=data.get(i).getName() %></td>
            <td><img alt="Preview" src=<%=data.get(i).getPreview()%> width=80" height="120"></td>
          
		</tr>
	<%} %>
	
	</table>
	
	</div>
	
	
	
	
</body>
</html>