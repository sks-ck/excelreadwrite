<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script type="text/javascript" src="/resources/js/app.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>User Form</title>
</head>
<body>
<div class="container">
  <h2>Customer Form</h2>
  <form  id="form1" action="/formAdded" method="post" >
    <div class="form-group">
      <label for="userName">Customer Name : </label>
      <input type="text" class="form-control" id="userName" placeholder="Enter Name" name="userName" required>
    </div>
    <div class="form-group">
      <label for="mobileNumber">Mobile no. : </label>
      <input type="text" class="form-control" id="mobile" placeholder="Enter mobile Number" name="mobile" required>
    </div>
    
    
   
      <label for="status">Select Designation : </label>
  		<select name="designation">
    <option value="CAMPUS MIND">CAMPUS MIND</option>
    <option value="LEAD">LEAD</option>
  	</select>
   
    
  	
  	<div class="form-group">
  	 <label for="hobby">Gender : </label>
  	<label class="radio-inline"><input type="radio" name="gender" value="male" checked>Male</label>
	<label class="radio-inline"><input type="radio" name="gender" value="female">Female</label>
  	 </div>
  	 

    <div class="form-group">
      <label for="email">e-mail : </label>
      <input type="email" class="form-control" id="email" placeholder="Enter e-mail" name="email" required>
    </div>
     
   
    <button type="submit" class="btn btn-default">Submit</button>
     <button type="submit" class="btn btn-default" formaction="/readfromfile">Read from file</button>
   <button type="reset" class="btn btn-default">Reset</button>
  </form>
</div>
</body>
</html>