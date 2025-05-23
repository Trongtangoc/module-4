<%--
  Created by IntelliJ IDEA.
  User: lebui
  Date: 5/23/2025
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer Form</title>
</head>
<body>
<h2>Customer Information</h2>
<form action="customers" method="post">
    <input type="hidden" name="id" value="${customer.id}" />
    Name: <input type="text" name="name" value="${customer.name}" /><br/>
    Email: <input type="text" name="email" value="${customer.email}" /><br/>
    Address: <input type="text" name="address" value="${customer.address}" /><br/>
    <input type="submit" value="Update"/>
</form>
<a href="customers">Back to list</a>
</body>
</html>
