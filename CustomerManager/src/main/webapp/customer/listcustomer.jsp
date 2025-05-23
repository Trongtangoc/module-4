<%--
  Created by IntelliJ IDEA.
  User: lebui
  Date: 5/23/2025
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
    <style>
        table {
            border-collapse: collapse;
        }
    </style>
</head>
<body><h2>Customer List</h2>
<table border="1" cellpadding="5">
    <tr><th>Id</th><th>Name</th><th>Email</th><th>Address</th><th>Action</th></tr>
    <c:forEach var="customer" items="${listCustomer}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td>
                <a href="customer?action=edit&id=${customer.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
