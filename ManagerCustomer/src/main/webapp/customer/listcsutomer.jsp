<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lebui
  Date: 5/23/2025
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
</head>
<body>
    <h2>Customer List</h2>
<table>
    <tr>
        <th>
            id
        </th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>

    </tr>
    <c:forEach var="c" items="${listCustomer}">
        <tr>
            <td>${c.id}</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
