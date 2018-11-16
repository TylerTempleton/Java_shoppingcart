<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" import="ca.sheridan.DAO.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Items to purchase</h1>
<c:forEach var="value" items="${list2}">
		<li><c:out value="${value.itemId}" /> <!-- Lists items--> <c:out
				value="${value.itemName}" /> <c:out value="${value.itemPrice}" />
			 DAO.x=${value.itemPrice}+
			 
			</li>
	</c:forEach>
	
	Total: 
	
	<Form method='post' action="Processing">
	Credit Card Number:<input type="text" name="Creditcard">
	<button type="button" name="purchase">Purcahse</button>
	</Form>
	
</body>
</html>