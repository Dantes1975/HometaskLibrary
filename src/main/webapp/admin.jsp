<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>
        Admin page
    </title>
    <style>
        table {
            width: 90%; /* Ширина таблицы */
            background: white; /* Цвет фона таблицы */
            color: white; /* Цвет текста */
            border-spacing: 1px; /* Расстояние между ячейками */
        }

        td, th {
            background: green; /* Цвет фона ячеек */
            padding: 5px; /* Поля вокруг текста */
        }
    </style>
</head>
<body>

<form action="logout" method="post">
    <input type="submit" name="action" value="logout">
</form>
<h1> !!! Welcom to library, ${sessionScope.authenticate.login} !!! </h1> <br>
<h1> YOUR STATUS is ${sessionScope.authenticate.profile_enable} </h1>

<c:if test="${sessionScope.role.role == 'user'}">
    <h2> If you wont to choose your settings </h2>
    <p>Your id ${sessionScope.user.id}</p>
    <p>Your name is ${sessionScope.user.name}</p>
    <p>Your surname = ${sessionScope.user.surname}</p>
    <p>Your email = ${sessionScope.user.email}</p>
    <p>Your age = ${sessionScope.user.age}</p>
    <p>Your login = ${sessionScope.authenticate.login}</p>
    <p>Your password = ${sessionScope.authenticate.password}</p>
    <p>Your aut_id = ${sessionScope.authenticate.id}</p>
    <p>Your role = ${sessionScope.role.role}</p>

    <form action="update" method="post">
        login <input type="text" name="login"/><br>
        password <input type="password" name="password"/><br>
        name <input type="text" name="name"/>
        surname <input type="text" name="surname"/>
        email <input type="text" name="email"/>
        age <input type="password" name="age"/>
        age <input type="hidden" name="role" value="user"/>

        <br>
        <input type="submit" name="action" value="update">
    </form>
    <br>

    <c:if test="${sessionScope.authenticate.profile_enable == 'ON'}">
        <h2> To take book input book_id from list</h2>
        <form action="takebook" method="post">
            login <input type="text" name="bookid"/>
            <br>
            <input type="submit" name="action" value="take"><br>
        </form>
    </c:if>

    <br>
    <h2> To return book input book_id from list</h2>
    <form action="returnbook" method="post">
        login <input type="text" name="bookid"/>
        <br>
        <input type="submit" name="action" value="return">
    </form>
    <br>
</c:if>

<c:if test="${sessionScope.role.role == 'admin'}">

    <form action="set" method="post">
        login <input type="text" name="login"/>
        password <input type="password" name="password"/>
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
    <br>
    <br>
    <table>
        <tr>
            <th> ID</th>
            <th> LOGIN</th>
            <th> PASSWORD</th>
            <th> PROFILE ENABLE</th>
        </tr>
        <c:forEach items="${sessionScope.authent}" var="authnticate">
            <%--            <p> ID ${authnticate.id} LOGIN ${authnticate.login} PASSWORD ${authnticate.password}--%>
            <%--                PROFILE ${authnticate.profile_enable} </p>--%>
            <tr>
                <td> ${authnticate.id} </td>
                <td> ${authnticate.login}
                <td> ${authnticate.password} </td>
                <td> ${authnticate.profile_enable}
            </tr>
        </c:forEach>
    </table>
    <br>
    <br>
    <form action="delete" method="post">
        USER ID <input type="text" name="id"/>
        <input type="submit" name="action" value="delete"/>
    </form>
    <form action="off" method="post">
        USER ID <input type="text" name="id"/>
        <select name="type">
            <option>block</option>
            <option>off</option>
        </select>
        <input type="submit" name="action" value="off">
    </form>
    <form action="on" method="post">
        USER ID <input type="text" name="id"/>
        <input type="submit" name="action" value="on"/>
    </form>
</c:if>

</body>
</html>