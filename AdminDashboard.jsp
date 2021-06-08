<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="Package1.Cake"%>
<%@ page import="Package1.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
p{
	font-size: 40px;
	text-align: center;
	color:white;
	background-color:black;
	
}
.content {width =100%;height =auto;
	padding: 20px;
	font-size: 15px; 
	line-height: 50px;
	height: 475px;
	font-weight: bold;
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
table,th,td {
	margin: auto;
	padding: 10px;
	font-size: 20px;
	background-color: white;
	borer-collapse: colapse;
	border-radius: 10px;
	text-decoration: Underline;
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
</style>
</head>
<body background="https://www.koolmaxgroup.com/blog/wp-content/uploads/2017/08/430afc50e8ad68594de9d1b020f99072.jpg" style="background-size:cover;margin: 0;">
	<div class="header">
		<h1>Cakes Delight</h1>
		<h2>Best at Price , Best at Taste</h2>
	</div>
	<div class="navbar">
		<nav>
			<a href="#">View Todays Orders</a>
			<a href="<%=request.getContextPath()%>/editListOfCakes">Edit List of Cakes</a>
			<a href="AddNewCake.jsp">Product Entry</a>
		</nav>
		<form action="back" method="post">
			<input class="button" type="submit" name="b1" value="Logout"
				formAction="back">
		</form>
	</div>
	<div class="content">
	<form action="viewTodaysOrders" method="post">
		<%
		List list = (List) session.getAttribute("orderList");
		if(list!=null && list.head!=null)
		{
		%>
		<table border="1">
			<tr>
					<th colspan="7" style="font-size: 30px;">Today's Orders</th>
			</tr>
			<tr>
				<td>Cake ID
				<td>Cake Type
				<td>Cake Flavour
				<td>Cake Shape
				<td>Cake Weight
				<td>Cake Price
			</tr>
			<%
			for (Cake temp = list.head; temp != null; temp = temp.next) {
			%>
			<tr>
				<td><%=((Cake) temp).getCakeID()%></td>
				<td><%=((Cake) temp).getCake_type()%></td>
				<td><%=((Cake) temp).getCake_flavour()%></td>
				<td><%=((Cake) temp).getCake_shape()%></td>
				<td><%=((Cake) temp).getCake_weight()%>&nbsp;Kg</td>
				<td><%=((Cake) temp).getCake_price()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		else
		{
		%>
		<p>	No Orders Yet!!Thank you!</p>
		<%
		}
		%>
	</form>
	</div>
</body>
</html>