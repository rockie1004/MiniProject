<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
	<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="style.css">
		<title>Author List</title>
	</head>
<body>
<h1>Author List</h1>
<a href = "viewAllBooksServlet">Go to Book List</a><br />

<form method ="post" action ="authorNavigationServlet">
<table class="center">
	<c:forEach items="${requestScope.allAuthors}" var="currentitem">
		<tr>
			<td><input type="radio" name ="id" value="${currentitem.id}"></td>
			<td>${currentitem.authorName}</td>
		</tr>
	</c:forEach>
</table>
<br />
<input type="submit" value ="Edit" name="doThisToItem" class="button">
<input type="submit" value="Delete" name="doThisToItem" class="button">
</form>

</body>
</html>