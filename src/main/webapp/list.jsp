<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
    <style>
        table {
            width: 90%; /* Ширина таблицы */
            background: white; /* Цвет фона таблицы */
            color: white; /* Цвет текста */
            border-spacing: 1px; /* Расстояние между ячейками */
        }

        td, th {
            background: olivedrab; /* Цвет фона ячеек */
            padding: 5px; /* Поля вокруг текста */
        }
        /*thead, tbody { display: block; }*/

        /*tbody {*/
        /*    height: 100px;       !* Just for the demo          *!*/
        /*    overflow-y: auto;    !* Trigger vertical scroll    *!*/
        /*    overflow-x: hidden;  !* Hide the horizontal scroll *!*/
        /*}*/
    </style>
</head>
<body>
<form action="logout" method="post">
    <input type="submit" name="action" value="logout">
</form>

<h1> Вы находитесь на гостевой странице </h1> <br>


<h1> Список книг нашей библиотеки </h1> <br>

<table>
    <tr>
        <th> ID</th>
        <th> BOOK NAME</th>
        <th> AUTHOR</th>
        <th> GENRE</th>
        <th> STOCK</th>
    </tr>
    <c:forEach items="${sessionScope.listbooks}" var="book">
        <tr>
            <td>${book.id} </td>
            <td>${book.bookname} </td>
            <td>${book.author.name} ${book.author.surname}</td>
            <td>${book.genre.genrename}</td>
            <td>${book.stock}</td>
        </tr>
    </c:forEach>

</table>

<br>
<form action="listbooks" method="post">
    <input type="submit" name="action" value="list">
</form>
<br>
<h1> Или зарегистрируйтесь </h1>
<p><a href="login.jsp"> Registration </a></p>
</body>
</html>
