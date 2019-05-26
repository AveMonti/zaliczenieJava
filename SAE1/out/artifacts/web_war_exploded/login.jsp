<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 16/03/2019
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h2>Zaloguj sie</h2>
<form action="LoginServlet" method="post">
    <input type="text", name="login">
    <input type="password", name="password">

    <input type="submit" , value="zaloguj">
</form>
</body>
</html>

