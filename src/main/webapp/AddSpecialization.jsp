<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<h2>Enter Specialization Details</h2>
<form action="SpecializationServlet">
<table>
<tr><td>Enter Specialization ID<td><input type="number" name="specialid" placeholder="enter specialization Id">
</tr>
<tr><td>Enter Specialization Name<td><input type="text" name="specialname" placeholder="enter specialization name">
</tr>
</table>
<button name="submit" class="button">submit</button>
</form>
</center>
</body>
</html>