<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	padding: 15px;
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
	function validatePaymentDetails() {
		var name_on_card = document.makePayment.name_on_card.value;
		var debit_card_number = document.makePayment.debit_card_number.value;
		var exp_month = document.makePayment.exp_month.value;
		var exp_year = document.makePayment.exp_year.value;
		var cvv = document.makePayment.cvv.value;
		if(name_on_card=="" || debit_card_number=="" || exp_month=="" || exp_year=="" || cvv=="")
		{
			alert("Please, enter all the Fields.");
			return false;
		}
		else if(exp_month>12 || exp_month<0 )
		{
			alert("Please, enter valid expiry month.");
			return false;
		}
		else if(exp_year<2022 && exp_year.length!=2)
		{
			alert("Please, enter valid expiry year.");
			return false;
		}
		else if(cvv.length!=3)
		{
			alert("Please, enter valid CVV.");
			return false;
		}
		else
		{
			alert("Payment is Successfull!!!");
			return true;
		}
	}
</script>
<body background="https://www.koolmaxgroup.com/blog/wp-content/uploads/2017/08/430afc50e8ad68594de9d1b020f99072.jpg" style="background-size:cover;margin:0;">
	<div class="header">
		<h1>Payment Gateway</h1>
	</div>
	<div class="content">
	    <form name="makePayment" method="post">
			<table>
				<tr>
					<td rowspan="7"><img src="https://s3-ap-southeast-1.amazonaws.com/biztory-wordpress-img/wp-content/uploads/2020/02/12165308/onebill-payment-banner.png">
					<td align="right" style="font-weight: bold">Name on Card :</td>
					<td><input class="textfield" type="text" name="name_on_card"
						maxlength="100"></td>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">Debit Card Number :</td>
					<td><input class="textfield" type="text" name="debit_card_number"
						maxlength="100"></td>
				</tr>
				<tr>
					<td align="right" style="font-weight:bold">Exp Month :</td>
					<td><input class="textfield" type="text" name="exp_month"
						maxlength="2"></td>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">Exp Year :</td>
					<td><input class="textfield" type="text" name="exp_year"
						maxlength="4"></td>
				</tr>
				<tr>
					<td align="right" style="font-weight: bold">CVV:</td>
					<td><input class="textfield" type="password" name="cvv"
						maxlength="3"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="button"
						type="Reset" name="b1" value="Reset" size="30">
						 <input class="button" type="Submit" name="b3" value="Pay" onClick="return validatePaymentDetails();" formAction="makePayment">
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="button"
							type="Submit" name="b3" value="Back" formAction="<%=request.getContextPath()%>/displayOrderedCakes">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
