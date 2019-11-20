<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@page import="User" %>--%>
<%--<%@page import="Roles" %>--%>
<%--<%@page import="LogServlet" %>--%>
<%--<%@page import="LogoutServlet" %>--%>
<%--<%@page import="UserDAO" %>--%>
<html>
<head>
    <title>Login meny</title>
</head>
<body>

    <h1>Регистрация нового пользователя</h1> <br>
    <h1> Введите имя и пароль </h1> <br>

    <form action="login" method="post">

        <input type="text" required placeholder="login" name="login"><br>
        <input type="password" required placeholder="password" name="password"><br><br>
        <input class="button" type="submit" name="action" value="login">

    </form>

</body>
</html>
