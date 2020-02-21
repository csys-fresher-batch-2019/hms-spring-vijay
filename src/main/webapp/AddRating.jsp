<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.button {
	background-color: brown;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
<body>
<center>
<h2>GIVE RATING</h2>
<form action="RatingsServlet">
<table>
<tr><td>Enter patient ID:<td><input type="number" name="patientid" placeholder="enter patient ID" >
</tr>
<tr><td>Enter Doctor ID:<td><input type="number" name="doctorid" placeholder="enter doctor ID" >
</tr>
<tr><td>Enter Rating:<td><input type="number" name="rating" placeholder="enter rating" max=10>
</tr>
</table>
<button type="submit" class="button" class="button">submit</button>
</form>
</center>
</body>
</html>