<%--
  Created by IntelliJ IDEA.
  User: warie
  Date: 19/04/2023
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<html>
<head>
    <title>creation</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<form action="${pageContext.request.contextPath}/secured/newCategory" method="post">

    <label>nom:</label>
    <input type="text" name="name"  />
    <button type="submit">Crée</button>
</form>
</body>
</html>
