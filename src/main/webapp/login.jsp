<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login meny</title>
</head>
<body>

    <h1>Регистрация нового пользователя</h1> <br>
    <h1> Введите данные </h1> <br>

    <form action="logout" method="post" >
        <input type="submit" name="action" value="logout">
    </form>

    <p> ${requestScope.error}</p>

    <form action="login" method="post">

        <input type="text" required placeholder="login" name="login"><br><br>
        <input type="password" required placeholder="password" name="password"><br><br>
        <input type="text" required placeholder="NAME" name="name"><br><br>
        <input type="text" required placeholder="surname" name="surname"><br><br>
        <input type="text" required placeholder="age" name="age"><br><br>
        <input type="text" required placeholder="email" name="email"><br><br>
        <input type="hidden" name="role" value="user"><br><br>
        <input class="button" type="submit" name="action" value="login">
    </form><br>

    <h1> Или войдите как гость </h1><br>

    <form action="guest" method="post" >
        <input type="submit" name="action" value="GUEST">
    </form>
</body>
</html>
