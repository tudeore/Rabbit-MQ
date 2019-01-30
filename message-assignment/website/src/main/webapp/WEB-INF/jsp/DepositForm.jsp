<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${message}</h1>
	<form action="deposit" method="get">
		Enter Account Number: <input name="accountNumber" /><br /> Enter
		Amount : <input name="amount" /><br /> <input type="submit" />
	</form>

	<div>
		<a href="statements?offset=1&size=5">Get Statement</a>
	</div>
	
</body>
</html>