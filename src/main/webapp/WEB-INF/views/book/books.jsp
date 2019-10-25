
<%--
  Created by IntelliJ IDEA.
  User: username
  Date: 22.10.2019
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All books</title>
</head>
<body>
<header>
    <a href="${pageContext.request.contextPath}/injector/inject">Inject data</a>
    <a href="${pageContext.request.contextPath}/book/add">Add new book</a>
    <a href="${pageContext.request.contextPath}/rent/rents">Rents by User id=1</a>
</header>
<div align="center">
    <h2> Select what you want to buy</h2>
    <table border="2">
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Year</th>
            <th>Price</th>
            <th>Info</th>
            <th>Authors</th>
            <th>Rent a book</th>
        </tr>
        <%--@elvariable id="allBooks" type="java.util.List"--%>
        <c:forEach var="book" items="${allBooks}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.year}</td>
                <td>${book.price}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/book/${book.id}">Info</a>
                </td>
                <td>${book.authors}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/rent/rentbook?book_id=${book.id}">Rent</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
