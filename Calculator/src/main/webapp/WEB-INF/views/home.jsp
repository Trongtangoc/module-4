<%--
  Created by IntelliJ IDEA.
  User: lebui
  Date: 5/28/2025
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/home/save" method="post">
  <input type="text" id="num1" name="num1" value="12"/><br>
  <input type="text" id="num2" name="num2" value="12"/><br>
  <input type="submit" name="action" value="add"/>
  <input type="submit" name="action" value="sub"/>
  <input type="submit" name="action" value="mul"/>
  <input type="submit" name="action" value="dev"/>

</form>
<h2>Result: ${result}</h2>
</body>
</html>
