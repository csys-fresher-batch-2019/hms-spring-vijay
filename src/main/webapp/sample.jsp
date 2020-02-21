<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<h2>WEB APPLICATION</h2>
<br>
<form action="final.jsp">
enter name: <input type="text" name="name" placeholder="enter name" required autofocus/>
<br>
enter email: <input type="email" name="email" placeholder="enter emailid" required >
<br>
enter dob:<input type="date" name="dob" min="1998-01-01" max="2020-01-01">
<br>
<ul type ="disc">  
<li>Give the necessary details</li>
</ul>
gender
<input type="radio" name="gender" value="M">male
<input type ="radio" name="gender" value="F">female
<br>
hobbies
<input type="checkbox" name="hobbies" value="cricket"> cricket
<input type="checkbox" name="hobbies" value="football"> football
<br>
select movie
<select name="movie">
<option value="darbar" >darbar</option>
<option value= "mersal">mersal</option>
</select>
<br>
<table border="1" bordercolor=" blue">
<tr>
<th>number</th>
<th>name</th>
</tr>
<tr>
<td>1</td>
<td>darbar</td>
</tr>
<tr>
<td>2</td><td>mersal</td>
</tr>
</table>
<img src="images/download.jpg"
 width="500" height="500"
  alt="imac">
  
<br>

Select Source Station:
 <input list="source_station_list" > 
<datalist id="source_station_list">
  <option value="MGR Chennai Central - MAS">
  <option value="Bangalore">
  <option value="Madurai">
  <option value ="coimbatore">
  <option value ="newzland">
</datalist>
<br>
<br>
<br>
Country code: <input type="text" name="country_code"
pattern="[A-Za-z]{3}" title="Three letter country code">
<br>
<br>
<br>
enter pnr number:<input type="text" name="mobile number" maxlength="10" 
placeholder="enter your number">
<br>
<button>submit</button>

</form>
</body>
</html>