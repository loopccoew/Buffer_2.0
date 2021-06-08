<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Package1.User" %>
<%@ page import="Package1.UserDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<style type="text/css">
.header {
	width =100%; 
	font-weight: bold;
	font-style: italic;
	text-align: center;
	color:black;
	background-color:rgb(204, 255, 102);
	padding:15px;
	line-height:5px;
}
h1{
	font-size: 75px;
	text-align: center;
	color:black;
	font-family:Algerian;
	text-decoration: Underline;
}
.content {width =100%;height =auto;
	margin: auto;
	padding: 75px;
}

table, td {
	margin: auto;
	padding: 10px;
	font-size: 20px;
	background-color: white;
	borer-collapse: colapse;
	border-radius: 10px;
	text-decoration: Underline;
}

.textfield {
	height: 25px;
	font-size: 14pt;
	width: 250px;
	border-radius: 10px;
	padding: 2px;
}

.button {
	background-color: #990033;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 25px;
}
.alert {
  padding: 20px;
  background-color: #f44336;
  color: white;
}

.closebtn {
  margin-left: 15px;
  color: white;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
  transition: 0.3s;
}

.closebtn:hover {
  color: black;
}
</style>
</head>
<script>  		
	function validateLoginDetails() 
	{
		var customerID = document.login.customerID.value;
		var password = document.login.password.value;
		if(customerID=="" || password=="")
		{
			alert("Please, enter all the Fields.");
			return false;
		}
		else
		{	
			alert("YOU HAVE LOGGED IN SUCCESSFULLY!!!");
			return true;
		}
	}
</script>
<body background="https://www.koolmaxgroup.com/blog/wp-content/uploads/2017/08/430afc50e8ad68594de9d1b020f99072.jpg" style="background-size:cover;margin:0;">
	<div class="header"><h1>Cakes Delight</h1>
		<h2>Best at Price , Best at Taste</h2>
	</div>
	<form name="login" method="post">
		<div class="content">
			<table>
				<tr>
					<th colspan="2" style="font-size: 30px;">Login</th>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">Customer ID :</td>
					<td><input class="textfield" type="text" name="customerID"
						maxlength="15"></td>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">Password :</td>
					<td><input class="textfield" type="password" name="password"
						maxlength="15"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="button"
						type="Reset" name="b1" value="Reset" size="30"><input class="button" type="Submit" name="b3" value="Login" onClick="return validateLoginDetails();" formAction="login" >
				</tr>
				<tr>
					<td colspan="2" align="center" style="font-weight: bold">Are
						you visiting for first time ? then... 
						<a href="new">Register here</a>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>