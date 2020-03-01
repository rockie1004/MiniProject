<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="style.css">
		<title>Edit Book</title>
	</head>
<body>
<h1>Edit a Book</h1>
<a href = "viewAllBooksServlet">Go Back to Book List</a><br />
<form action ="editBookServlet" method="post">
Author:<br />
<input type ="text" name ="author" value="${bookToEdit.author}"><br />
Book Title:<br />
<input type ="text" name ="title" value="${bookToEdit.title}"><br />
Last Read Date:<br />
<input type ="text" name = "month" placeholder="mm" size="4">
<input type ="text" name = "day" placeholder="dd" size="4">
<input type ="text" name = "year" placeholder="yyyy" size="4"><br />
<input type ="hidden" name ="id" value="${bookToEdit.id}">
<input type = "submit" value= "Save Edited Book" class="button">
</form>
</body>
</html>