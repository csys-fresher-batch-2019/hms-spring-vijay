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
  background-color: BROWN;
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
<%
		String infoMessage = (String) request.getAttribute("infoMessage");
		String errorMessage = (String) request.getAttribute("errorMessage");
		if (infoMessage != null)
			out.println(infoMessage);
		if (errorMessage != null)
			out.println(errorMessage);
	%>
<form action="Registrationservlet">
<CENTER><h2>REGISTRATION FORM</h2>
<table>
<tr>
<td>
Enter Patient name:<td><input type="text" name="name" pattern="[a-z]{3,}" placeholder="enter name" 
required autofocus/>
</tr>
<tr>
<td>
Enter Adharcard Number:
<td><input type="number" name="adhar" placeholder="enter number" pattern="[0-9]{16}" >
</tr>
<tr>
<td>
Date of Birth:
<td><input type="date" name="dob">
</tr><tr><td>
gender:
<td>
 <input type="radio" name="gender" value="M">male
<input type ="radio" name="gender" value="F">female
</tr><tr><td>
Enter phone number:<td><input type="tel" name="mobile number" pattern="[0-9]{10}"
placeholder="enter your number">
</tr>
</table>
<button type="submit" name="submit" class="button">submit</button>
<a href="index.jsp" class="button">Main Menu</a>
</form>
</CENTER>
</body>
</html>