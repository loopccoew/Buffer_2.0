<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Random"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<style>
.header {
	width =100%; 
	font-weight: bold;
	font-style: italic;
	text-align: center;
	color:black;
	line-height:5px;
	background-color:rgb(204, 255, 102);
	padding:15px;
}
h1{
	font-size: 75px;
	text-align: center;
	color:black;
	font-family:Algerian;
	text-decoration: Underline;
}
.content {
    width =100%;height =auto;
	margin: auto;
	padding: 75px;
}
table, th, td {
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
</style>
</head>
<script>  		
	function validateform() {
		var name = document.saveUserDetails.name.value;
		var mobileNumber = document.saveUserDetails.mobileNumber.value;
		var emailID = document.saveUserDetails.emailID.value;
		var address = document.saveUserDetails.address.value;
		var password = document.saveUserDetails.password.value;
		if (name == "" || mobileNumber == "" || emailID == "" || address == ""
				|| password == "") {
			alert("Please, enter all the Fields.");
			return false;
		} else if (password.length < 8) {
			alert("Password must be at least 8 characters long.");
			return false;
		} else if (!(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/
				.test(saveUserDetails.emailID.value))) {
			alert("You have entered an invalid email address!Please enter it again.")
			return false;
		}
		else
		{	<% 
			   Random random = new Random(); 
			   int customerID=random.nextInt(10000);
			   session.setAttribute("customerID", customerID);
			%>
			alert("You have successfully registered!! Your Customer Id is "+<%=session.getAttribute("customerID")%>)
			return true;
		}
	}
</script>
<body background="https://www.koolmaxgroup.com/blog/wp-content/uploads/2017/08/430afc50e8ad68594de9d1b020f99072.jpg" style="background-size:cover;margin: 0;">
	<div class="header">
		<h1>Cakes Delight</h1>
		<h2>Best at Price , Best at Taste</h2>
	</div>
	<form name="saveUserDetails" method="post">
		<div class="content">
			<table>
				<tr>
					<th colspan="2" style="font-size: 30px;">User Registration</th>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">Name :</td>
					<td><input class="textfield" type="text" name="name"
						maxlength="50"></td>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">Mobile Number :</td>
					<td><input class="textfield" type="text" name="mobileNumber"
						maxlength="10"></td>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">Password :</td>
					<td><input class="textfield" type="password" name="password"
						maxlength="15"></td>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">Address :</td>
					<td><textarea rows="3" cols="23" name="address"
							style="font-size: 14pt; padding: 2px; border-radius: 10px; resize:none;" ></textarea></td>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">Email ID :</td>
					<td><input type="text" class="textfield" name="emailID"
						maxlength="25"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="button"
						type="Reset" name="b2" value="Reset" size="30"><input
						class="button" type="Submit" name="b1" value="Register"
						 onclick="return validateform();" formAction="saveUserDetails">	
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="button"
						type="Submit" name="b3" value="Back" formAction="LoginPage.jsp">
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>