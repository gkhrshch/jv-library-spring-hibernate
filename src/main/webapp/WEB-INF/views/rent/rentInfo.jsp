<%--
  Created by IntelliJ IDEA.
  User: username
  Date: 25.10.2019
  Time: 06:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Rent info</title>
</head>
<body>
<h2>Rent info page</h2>
<table border="2">
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Year</th>
        <th>Price</th>
        <th>Info</th>
        <th>Authors</th>
        <th>Rent active</th>
        <th>Close Rent</th>
    </tr>
    <%--@elvariable id="rentBooks" type="java.util.List"--%>
    <c:forEach var="book" items="${rentBooks}">
    <tr>
        <td>${book.id}</td>
        <td>${book.title}</td>
        <td>${book.year}</td>
        <td>${book.price}</td>
        <td>
            <a href="${pageContext.request.contextPath}/book/${book.id}">Info</a>
        </td>
        <td>${book.authors}</td>
        <td>${book.authors}</td>
        <td>
            <a href="${pageContext.request.contextPath}/rent/returnbook?book_id=${book.id}">Return</a>
        </td>
    </tr>
    </c:forEach>
</body>
</html>
