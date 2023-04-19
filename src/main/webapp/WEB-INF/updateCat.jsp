
<%--
  Created by IntelliJ IDEA.
  User: warie
  Date: 19/04/2023
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<html>
<head>
    <title>Edit catégorie</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<h1>Edit post</h1>
<form action="${pageContext.request.contextPath}/secured/editCategory" method="post">
    <input type="hidden" name="id" value="${category.id}">
    <input type="text" name="name" value="${category.name}" /><br>
    <button type="submit">modifier</button>
</form>
</body>
</html>
