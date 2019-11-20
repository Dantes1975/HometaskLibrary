<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>
        Admin page
    </title>
</head>
<body>

<form action="logout" method="post" >
    <input type="submit" name="action" value="logout">
</form>

<p>User login = ${sessionScope.user.login}</p>
<p>User password = ${sessionScope.user.password}</p>
<p>User role = ${sessionScope.user.role}</p>

<c:if test="${sessionScope.user.role == 'ADMIN'}">

    <form action="add" method="post">
        login <input type="text" name="login"/>
        <br>
        password <input type="password" name="password"/>
        <br>
        role <select name="role">
        <option>ADMIN</option>
        <option>USER</option>
    </select>
        <br>
        <input type="submit" name="action" value="add">
    </form>
    <br>
    <br>
    <c:forEach items="${sessionScope.users}" var="user">
        <p> User: ${user.login} Password ${user.password} Role ${user.role}</p>
    </c:forEach>
    <form action="delete" method="post">
        Login <input type="text" name="login"/>
        Password <input type="text" name="password"/>
        <input type="submit" name="action" value="delete"/>
    </form>
</c:if>
</body>
</html>