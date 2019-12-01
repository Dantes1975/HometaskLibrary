<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> update </title>
</head>
<body>
<h1> Введите новые данные </h1><br>

<form action="update" method="post">
    Input new login <input type="text" name="login"/><br>
    Input new password <input type="password" name="password"/><br>
    Input new name <input type="text" name="name"/><br>
    Input new surname <input type="text" name="surname"/><br>
    Input new email <input type="text" name="email"/><br>
    Input new age <input type="password" name="age"/>
    <input type="hidden" name="id" value="${sessionScope.user.id}"/>

    <br>
    <input type="submit" name="action" value="update">
</form>
<br>
</body>
</html>
