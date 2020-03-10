<%@page import="com.chainsys.hmsapplication.service.ServiceSplzations"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.hmsapplication.dao.impl.Impspecialization"%>
<%@page import="com.chainsys.hmsapplication.model.Splzationlist"%>
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


	<%
		String infoMessage = (String) request.getAttribute("infoMessage");
		String errorMessage = (String) request.getAttribute("errorMessage");
		if (infoMessage != null)
			out.println(infoMessage);
		if (errorMessage != null)
			out.println(errorMessage);
	%>
	<form action="DoctorServlet">
		<table>
			<h2>Enter Doctor Details</h2>
			<tr>
				<td>Enter Doctor ID
				<td><input type="number" name="docid">
			</tr>
			<tr>
				<td>Enter Doctor Name
				<td><input type="text" name="docname">
			</tr>
		
			
				<%
				ArrayList<Integer> spl = (ArrayList) request.getAttribute("spl");
				%>
				
			  <c:set var="specializations" value="<%=spl%>"></c:set>
			<tr>
				<td>Enter Specialization ID
				<td><input type="number" name="splid" list="splid"> <datalist
						id="splid">
						<c:forEach items="${specializations}" var="s">
   						 
   						 <option value="${s}">${s}</option>
   						 </c:forEach>
						
						
					</datalist>
			</tr>
			<tr>
				<td>Enter Consulting Fee
				<td><input type="number" name="fee"
					placeholder="consulting fee">
		</table>
		<button type="submit" name="submit" class="button">submit</button>
		<a href="index.jsp" class="button">Main Menu</a>
	</form>
</body>
</html>