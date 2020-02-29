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
<title>Author List</title>
</head>
<h1>Author List</h1>
<body>
<a href = "viewAllBooksServlet">Go to book list</a><br />

<form method ="post" action ="authorNavigationServlet">
<table>
<c:forEach items="${requestScope.allAuthors}" var="currentitem">
<tr>
<td><input type="radio" name ="id" value="${currentitem.id}"></td>
<td>${currentitem.authorName}</td>
</tr>
</c:forEach>
</table>
<input type="submit" value ="edit" name="doThisToItem">
<input type="submit" value="delete" name="doThisToItem">
</form>

</body>
</html>