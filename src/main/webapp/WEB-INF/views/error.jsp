<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
</head>
<body>
	<table>
		<tr>

			<th>Error Code</th>
			<th>Error Description</th>
		</tr>
		<c:forEach var="error" items="${errors}">
			<tr>
				<td>${error.getErrorDescription()}</td>
				<td>${error.getErrorCode()}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>