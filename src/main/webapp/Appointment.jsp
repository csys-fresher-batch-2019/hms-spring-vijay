<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.hmsapplication.service.ServiceDoctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<STYLE>
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
<form action="Appointmentservlet">
<CENTER><h2>APPOINTMENT FORM</h2>
<table>
<tr>
<td>Enter Patient id:
<td><input type="number" name="patientid" placeholder="enter patient id" >
</tr>
<tr>
<td>Enter purpose:
<td><input type="text" name="purpose" placeholder="enter purpose" >
</tr>

<%
				ArrayList<Integer> doctorid = (ArrayList)request.getAttribute("docid");
				%>

<tr><td>Enter doctor id:
<td><select id="doctorlist" name="doctorid" > 
<%
for(int id : doctorid){
%>
<option value="<%=id %>"><%=id %></option>
<%
}
%>
</select>
</tr>
<tr>
<td>Appointment date:
<td><input type="date" name="app">
</tr>
<tr><td>Appointment time:
<td><input type="time" name="time">
</tr>
<tr>
<td>Enter Patient Email:
<td><input type "email" name="email">
</tr>
</table>
<button type="submit" name="submit" class="button">submit</button>
<button formaction="index.jsp" class="button">MAIN MENU</button>
</form>
</CENTER>
</body>
</html>