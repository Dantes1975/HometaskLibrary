<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>createUser</title>
</head>
<body>
<form action="set" method="post">
    login <input type="text" name="login"/>
    password <input type="text" name="password"/>
    name <input type="text" name="name"/>
    surname <input type="text" name="surname"/>
    email <input type="text" name="email"/>
    age <input type="password" name="age"/>
    role <select name="role">
    <option>ADMIN</option>
    <option>USER</option>
</select>
    <br>
    <input type="submit" name="action" value="add">
</form>
</body>
</html>
