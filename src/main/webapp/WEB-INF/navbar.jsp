<%--
  Created by IntelliJ IDEA.
  User: warie
  Date: 19/04/2023
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    a{
        text-decoration: none;
        color: black;

    }
</style>
<nav class="navbar navbar-light bg-light justify-content-between">
    <a class="navbar-brand"><img src="${pageContext.request.contextPath}/imag/logo_car_60.png"></a>
    <form class="form-inline">
       <a href="${pageContext.request.contextPath}/Accueil">Accueil</a>
        <a href="${pageContext.request.contextPath}/category">list catégorie</a>
        <a href="${pageContext.request.contextPath}/secured/logout">Déconnexion</a>
        <a href="${pageContext.request.contextPath}/login">connexion</a>
    </form>
</nav>
</body>
</html>
