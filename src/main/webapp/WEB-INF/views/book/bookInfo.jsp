
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book info</title>
</head>
<body>
<h2>Book info page</h2>
<table border="2">
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Year</th>
        <th>Price</th>
        <th>Authors</th>
    </tr>
    <tr>
        <td>${bookInfo.id}</td>
        <td>${bookInfo.title}</td>
        <td>${bookInfo.year}</td>
        <td>${bookInfo.price}</td>
        <td>${bookInfo.authors}</td>
        <td>
            <a href="${pageContext.request.contextPath}/rent/rentbook?book_id=${book.id}">Rent</a>
        </td>
    </tr>
</body>
</html>
