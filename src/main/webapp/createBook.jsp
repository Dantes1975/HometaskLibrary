<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create</title>
</head>
<body>
<form action="create" method="post">
    Bookname <input type="text" name="bookname"/>
    <br>
    Author name <input type="text" name="name"/>
    <br>
    Author surname <input type="text" name="surname"/>
    <br>
    Genre <input type="text" name="genrename"/>
    <br>
    Description <input type="file" name="file" />
    <br>
    <input type="submit" name="action" value="create">
</form>
</body>
</html>
