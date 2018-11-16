<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" import="ca.sheridan.DAO.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Items</title>
</head>
<body>

	<c:forEach var="value" items="${list}">
		<li><c:out value="${value.itemId}" /> <!-- Lists items--> <c:out
				value="${value.itemName}" /> <c:out value="${value.itemPrice}" />
			<form method="POST" action="AddToCart">
				<button type="submit" value="${value.itemId}" name="courseId">Add To Cart!</button>
				<!-- Submits CourseId value to VerifyUser.java-->
			</form></li>
	</c:forEach>
<form method="post" action="Checkout">
<button type="submit" name="Checkout">Checkout Now!</button>
</form>

</body>
</html>