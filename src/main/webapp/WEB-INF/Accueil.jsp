<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: warie
  Date: 19/04/2023
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

<html>
<head>
    <title>Accueil</title>
</head>
<body>
<%@ include file="navbar.jsp" %>

<c:if test="${empty cars}">
    <p>Aucune voiture trouvé.</p>
</c:if>
<% if(request.getSession().getAttribute("username") != null) { %>
<a href="secured/create" class="btn btn-success">nouvelle voiture</a>
<% } %>
<h1 style="text-align: center; margin-top: 10px";>Liste des voitures</h1>
<div class=" container " style="display: grid;grid-template-columns: repeat(3, 1fr);
grid-column-gap: 20px;
grid-row-gap: 20px; ">
    <c:forEach items="${cars}" var="car">
    <div class="card" style="width: 18rem;">
        <img class="card-img-top" src="${pageContext.request.contextPath}/imag/${car.photo}" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title">${car.name}</h5>
            <p class="card-text">${carDao.getNameById(car.category_id)}</p>
            <% if(request.getSession().getAttribute("username") != null) { %>
            <!-- Boutons pour utilisateur connecté -->
            <a href="detail?id=${car.id}" class="btn btn-primary">Details</a>
            <a href="secured/delete?id=${car.id} " class="btn btn-danger">Supprimer</a>
            <% } else { %>
            <!-- Bouton pour utilisateur non connecté -->
            <a href="detail?id=${car.id}" class="btn btn-primary">Details</a>
            <% } %>
        </div>
    </div>
    </c:forEach>
</body>
</html>
