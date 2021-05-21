<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Pranjal Employee SignIn Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  </head>
<body>

<div class="container">
  <h2>Sign in to HR Management</h2>
  <form action="validate">
    <div class="form-group">
      <label for="userid">User ID :</label>
      <input type="text" class="form-control" id="userid" placeholder="Enter userId" name="userid" required>
    </div>
    <div class="form-group">
      <label for="password">Arrival location :</label>
      <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
    </div> 
    <button type="submit" class="btn btn-default">Login</button>
  </form>
  <h4>${message}</h4>
</div>

</body>
</html>