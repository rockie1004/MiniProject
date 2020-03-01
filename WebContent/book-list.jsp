<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="style.css">
	<title>Book List</title>
	</head>
<body>
<h1>Book List</h1>

<a href = "viewAllAuthorsServlet">Go to author list</a><br />

<form method ="post" action ="bookNavigationServlet">
	<table>
	<c:forEach items="${requestScope.allBooks}" var="currentitem">
		<tr>
			<td><input type="radio" name ="id" value="${currentitem.id}"></td>
			<td>${currentitem.title}</td>
			<td>Written by: ${currentitem.author}</td>
		<tr>
			<td colspan="3">Last Read Date: ${currentitem.lastRead}
		</td>
		
		</tr>
	</c:forEach>
	</table>
<br />
<input type="submit" value ="Edit" name="doThisToItem" class="button">
<input type="submit" value="Delete" name="doThisToItem" class="button">
<input type="submit" value ="Add" name="doThisToItem" class="button">
</form>

</body>
</html>