<%--
  Created by IntelliJ IDEA.
  User: warie
  Date: 19/04/2023
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>creation</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/secured/newCategory" method="post">

    <label>nom:</label>
    <input type="text" name="name"  />
    <button type="submit">Crée</button>
</form>
</body>
</html>
