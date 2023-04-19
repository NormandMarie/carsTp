<%@ page import="com.example.carstp.Dao.CarDao" %><%--<jsp:useBean id="car" scope="request" type="javax.xml.stream.util.StreamReaderDelegate"/>--%>
<%--
  Created by IntelliJ IDEA.
  User: warie
  Date: 19/04/2023
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<html>
<head>
    <title>Détail car</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container mx-auto">
    <h1 class="text-center">${car.name}</h1>
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card mb-3">
            <img class="card-img-top" src="${pageContext.request.contextPath}/imag/${car.photo}" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">${car.name}</h5>
                <p class="card-text">${car.detail_text}</p>
                <p class="card-text">prix: ${car.price}  €</p>
                <p class="card-text">${categoryCar}</p>

            </div>
            </div>
        </div>
    </div>
</body>
</html>
