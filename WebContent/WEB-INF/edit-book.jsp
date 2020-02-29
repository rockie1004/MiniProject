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
<title>Edit Book</title>
</head>
<h1>Edit a Book</h1>
<body>
<form action ="editBookServlet" method="post">
Author: <input type ="text" name ="author" value="${bookToEdit.author}">
Book Title: <input type ="text" name ="title" value="${bookToEdit.title}">
<input type ="hidden" name ="id" value="${bookToEdit.id}">
<input type = "submit" value= "Save Edited Book">
</form>
</body>
</html>