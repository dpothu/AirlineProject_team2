<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlightBooking</title>
</head>
<h1>***Welcome to Flight Booking***</h1>
<h2>To continue booking your Flight please login here</h2>
<body>
<div>
<form action="validateLogin" method="post">
<!-- <form th:action="@{/login}" method="post" style="max-width: 400px; margin: 0 auto;">
 -->    <p>
       UserName: <input type="text" name="adminName" required />  
    </p>
    <p>Email ID: <input type="text" name="adminEmail" required> 
    <p>
        Password: <input type="password" name="adminPass" required />
    </p>
    <p>
        <input type="submit" value="Login" />
    </p>
</form>
</div>
</body>
</html>