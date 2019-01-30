<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${message}</h1>
	<form action="fundTransfer" method="get">
		Enter Sender Account Number: <input name="senderAccountNumber" TYPE="number" /><br /><br/>
		Enter Receiver Account Number: <input name="receiverAccountNumber" TYPE="number"/><br /> <br/>
		Enter Amount : <input name="amount" TYPE="number" /><br /> <input type="submit" />
	</form>
	<a href="statements?offset=1&size=5">Get Statement</a>
</body>
</html>