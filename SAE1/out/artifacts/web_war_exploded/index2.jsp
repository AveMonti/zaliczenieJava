<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body bgcolor="white">
Hello world

<%--<form action="Servlet" method="post">--%>
<%--<input type="text", name="imie">--%>
<%--<input type="text", name="login">--%>
<%--<br>--%>
<%--<input type="checkbox", name="checkbox", value="bool_val1">--%>
<%--<input type="checkbox", name="checkbox", value="bool_val2">--%>
<%--<input type="checkbox", name="checkbox", value="bool_val3">--%>
<%--<br>--%>
<%--<textarea name="textarea"></textarea>--%>
<%--<br>--%>
<%--<select name="select">--%>
<%--<option>opcja1</option>--%>
<%--<option>opcja2</option>--%>
<%--</select>--%>
<%--<input type="submit", value="submit">--%>
<%--<a href="Servlet">Servlet</a>--%>
<%--</form>--%>



<form action="LoginServlet" method="post">


    <input type="submit" , value="zaloguj">
</form>

<form action="ProfileServlet" method="post">


    <input type="submit" , value="profil">
</form>


<form action="LogoutServlet" method="post">
    <input type="submit" , value="wyloguj">
</form>


</body>
</html>