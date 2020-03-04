<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="style.css">
		<title>Edit Author</title>
	</head>
<body>
<h1>Edit an Author</h1>
<a href = "viewAllAuthorsServlet">Go Back to Author List</a><br />
<form action ="editAuthorServlet" method="post">
Author:<br />
<input type ="text" name ="authorName" value="${authorToEdit.authorName}"><br />
<input type ="hidden" name ="id" value="${authorToEdit.id}">
<input type = "submit" value= "Save Edited Author" class="button">
</form>
</body>
</html>