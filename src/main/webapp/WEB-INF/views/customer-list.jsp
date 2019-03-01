<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<table>
		<tr>

			<th>Customer Id</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<c:forEach var="customer" items="${customers}">

			<c:url var="updateLink" value="update">
				<c:param name="id" value="${customer.id}"></c:param>
			</c:url>


			<c:url var="deleteLink" value="delete">
				<c:param name="id" value="${customer.id}"></c:param>
			</c:url>

			<tr>
				<td>${customer.id}</td>
				<td>${customer.getProfile().firstName}</td>
				<td>${customer.getProfile().lastName}</td>
			</tr>

			<td><a href="${updateLink}">Update</a> ! <a href="${deleteLink}">Delete</a>
			</td>

		</c:forEach>
	</table>
</body>
</html>