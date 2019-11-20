<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login-test</title>
</head>
<body>
<h1> !!! Добро пожаловать в библиотеку !!! </h1> <br>
<h1> Введите имя и пароль </h1> <br>

<form action="auth" method="post">

    <input type="text" required placeholder="login" name="login"><br>
    <input type="password" required placeholder="password" name="password"><br><br>
    <input class="button" type="submit" name="action" value="login">

</form>

<h1> Или войдите как гость </h1>

<form action="guest" method="post" >
    <input type="submit" name="action" value="GUEST">
</form>

<h1> Или зарегистрируйтесь </h1>
<p> <a href="login.jsp"> Registration </a> </p>
</body>
</html>
