<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Form</title>
</head>
<body>
	<form action="updateCustomer" method="post">

		customer ID: <input type="text" name="id" value="<c:out value="${ id }"/>"> <br>
		<br> Customer FirstName: <input type="text" name="firstName"  value="<c:out value="${ firstname }"/>" />
		<br>
		<br> Customer LastName: <input type="text" name="lastName"  value="<c:out value="${ lastname }"/>" />
		<br>
		<br> Wallet Balance: <input type="text" name="balance" > <br>
		<br> Wallet Type: <input type="text" name="type"> <br>
		<br> <input type="submit" value="Submit">

	</form>
</body>
</html>