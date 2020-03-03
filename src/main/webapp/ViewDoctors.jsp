<%@page import="com.chainsys.hmsapplication.model.Doctorlist"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.hmsapplication.dao.impl.Impdoctor"%>
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
.buttons {
	background-color: brown;
	border: none;
	color: white;
	padding: 10px 20px;
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
Impdoctor doc=new Impdoctor();
ArrayList<Doctorlist> list=doc.viewdoctor();
%>
<form action="ViewDoctorServlet">
<table border="1">
<thead>
<tr>
<th>DOCTOR ID</th>
<th>DOCTOR NAME</th>
<th>SPECIALIZATION ID</th>
<th>CONSULTING FEE</th>
<%
for(Doctorlist rs :list){
%>
<tr>
<td><%=rs.getDoctorid()%></td>
<td><%=rs.getDoctorname()%></td>
<td><%=rs.getSplzationid()%></td>
<td><%=rs.getConsultingfee()%></td>
<%
}
%>
</table>
</form>
<a href="index.jsp" class="buttons">MAIN MENU</a>

</body>
</html>