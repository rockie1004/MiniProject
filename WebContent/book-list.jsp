<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<style type="text/css">
td
{
    padding:0 15px;
}
</style>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
</head>
<h1>Book List</h1>
<body>
<a href = "viewAllAuthorsServlet">Go to author list</a><br />


<form method ="post" action ="bookNavigationServlet">
<table>
<c:forEach items="${requestScope.allBooks}" var="currentitem">
<tr>
<td><input type="radio" name ="id" value="${currentitem.id}"></td>

<td>${currentitem.title}</td>
<td>${currentitem.author}</td>
<tr><td colspan="3">Last Read Date: ${currentitem.lastRead}</td>

</tr>
</c:forEach>
</table>
<input type="submit" value ="edit" name="doThisToItem">
<input type="submit" value="delete" name="doThisToItem">
<input type="submit" value ="add" name="doThisToItem">
</form>

</body>
</html>