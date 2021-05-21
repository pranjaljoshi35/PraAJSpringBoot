<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Upload info Task Assignment Pranjal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	  <h2>Enter employee details </h2>
	  <form action="employee" method="post">
	    <div class="form-group">
	      <label for="name">Employee name :</label>
	      <input type="text" class="form-control" id="name" placeholder="Enter name " name="name" required>
	    </div>
	    <div class="form-group">
	      <label for="location">Employee location :</label>
	      <input type="text" class="form-control" id="location" placeholder="Enter location " name="location" required>
	    </div>
	    <div class="form-group">
	      <label for="email">Employee email :</label>
	      <input type="email" class="form-control" id="email" placeholder="Enter email " name="email" required>
	    </div>
	    <div class="form-group">
	      <label for="dob">Employee DOB :</label>
	      <input type="text" class="form-control" id="dob" placeholder="Enter DOB " name="dob" required>
	    </div>
	    
	    <input type="submit" class="btn btn-default">
	  </form>
	</div>

</body>
</html>