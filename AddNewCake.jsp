<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Entry</title>
<style type="text/css">
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
.content {width =100%;height =auto;
	margin: auto;
	padding: 15px;
}
.navbar {
  overflow: hidden;
  background-color: white;
  font-weight: bold;
}
/* Style the navigation bar links */
.navbar a {
  float: left;
  display: block;
  text-align: center;
  padding: 14px 20px;
  color: black;
  font-size: 20px;
  text-decoration: none;
}

/* Right-aligned link */
.navbar a.right {
  float: right;
}

/* Change color on hover */
.navbar a:hover {
  background-color: #ddd;
  color: black;
}

/* Active/current link */
.navbar a.active {
  background-color: #666;
  color: white;
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
	background-color:white ;
	border: none;
	color: rgb(204, 0, 0);
	float: right;
	text-align: center;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	font-weight: bold;
	padding: 15px 32px;
}
.button:hover {
	background-color: #ddd;
}
.normalbutton{
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
	function validateCakeDetails() {
		var cake_id = document.AddNewCake.cake_id.value;
		var cake_type = document.AddNewCake.cake_type.value;
		var cake_flavour = document.AddNewCake.cake_flavour.value;
		var cake_shape = document.AddNewCake.cake_shape.value;
		var cake_price = document.AddNewCake.cake_price.value;
		var cake_weight = document.AddNewCake.cake_weight.value;
		if(cake_id=="" || cake_type=="" || cake_flavour=="" || cake_shape=="" || cake_price=="" || cake_weight=="")
		{
			alert("Please, enter all the Fields.");
			return false;
		}
		else
		{
			alert("Cake is added Successfully!!!");
			return true;
		}
	}
</script>
<body background="https://www.koolmaxgroup.com/blog/wp-content/uploads/2017/08/430afc50e8ad68594de9d1b020f99072.jpg" style="background-size:cover;margin: 0;">
	<div class="header">
		<h1>Cakes Delight</h1>
		<h2>Best at Price , Best at Taste</h2>
	</div>
	<div class="navbar">
		<nav>
			<a href="AdminDashboard.jsp">View Todays Orders</a>
			<a href="EditCakesList.jsp">Edit List of Cakes</a>
			<a href="#">Product Entry</a>
		</nav>
		<form action="back" method="post">
			<input class="button" type="submit" name="b1" value="Logout"
				formAction="back">
		</form>
	</div>
	<form name="AddNewCake" method="post">
		<div class="content">
			<table>
				<tr>
					<th colspan="2" style="font-size: 30px;">Product Entry</th>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">Cake ID :</td>
					<td><input class="textfield" type="text" name="cake_id"
						maxlength="50"></td>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">Type :</td>
					<td><input class="textfield" type="text" name="cake_type"
						maxlength="50"></td>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">Flavour :</td>
					<td><input class="textfield" type="text" name="cake_flavour"
						maxlength="50"></td>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">Shape :</td>
					<td><input class="textfield" type="text" name="cake_shape"
						maxlength="50"></td>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">Price :</td>
					<td><input class="textfield" type="text" name="cake_price"
						maxlength="10"></td>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">Weight(Kg) :</td>
					<td><input class="textfield" type="text" name="cake_weight"
						maxlength="10"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="normalbutton"
						type="Reset" name="b1" value="Reset" size="30">
						 <input class="normalbutton" type="Submit" name="b3" value="Save" onClick="return validateCakeDetails();" formAction="AddNewCake">
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="normalbutton"
							type="Submit" name="b3" value="Back" formAction="<%=request.getContextPath()%>/editListOfCakes">
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>