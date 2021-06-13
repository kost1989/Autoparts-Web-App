<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Bookstore | Home</title>
</head>
<head>
<body>
<div th:each="order : ${orders}" th:id="${order.getId()}">
    <p th:text="${order.getName()}"/>
</div>
</body>
</html>