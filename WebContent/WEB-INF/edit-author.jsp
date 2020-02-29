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
<title>Edit Author</title>
</head>
<h1>Edit an Author</h1>
<body>
<form action ="editAuthorServlet" method="post">
Author: <input type ="text" name ="authorName" value="${authorToEdit.authorName}">
<input type ="hidden" name ="id" value="${authorToEdit.id}">
<input type = "submit" value= "Save Edited Author">
</form>
</body>
</html>