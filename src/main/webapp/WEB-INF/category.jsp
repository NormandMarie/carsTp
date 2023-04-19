<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: warie
  Date: 19/04/2023
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<html>
<head>
    <title>catégories</title>
</head>
<body>

<%@ include file="navbar.jsp" %>

<c:if test="${empty categorys}">
    <p>Aucune voiture trouvé.</p>
</c:if>
<h1 style="text-align: center; margin-top: 10px";>Liste des catégories</h1>
<div class=" container " style="display: grid;grid-template-columns: repeat(3, 1fr);
grid-column-gap: 20px;
grid-row-gap: 20px; margin-top: 20px">
    <c:forEach items="${categorys}" var="category">
    <div class="card" style="width: 16rem;">
        <div class="card-body category-card">
            <h3 class="card-title">${category.name}</h3>
        </div>
    </div>
    </c:forEach>
</body>
</html>
