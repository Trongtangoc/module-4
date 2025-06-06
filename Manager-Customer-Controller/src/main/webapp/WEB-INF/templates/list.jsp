<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/24/2023
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
    <style>
        table {
            width: 500px;
            border: 2px solid;
        }

        tr, td, th {
            border: 1px dotted;
        }
    </style>
</head>
<body>
<p>There are ${customers.size()} customers in list</p>
<h3>Customer List</h3>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    <c:forEach var="c" items="${customers}">
        <tr>
            <td>${c.id}</td>
            <td><a href="/customers/${c.id}">${c.name}</a></td>
            <td>${c.email}</td>
            <td>${c.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>