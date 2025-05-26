<%--
  Created by IntelliJ IDEA.
  User: lebui
  Date: 5/26/2025
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Convert USD to VND</title>
  </head>
  <body>
  <h2>Convert USD to VND</h2>
  <form action="convert" method="post">
    <label>Rate (VND/USD): </label>
    <input type="number" step="0.01" name="rate" required/><br>
    <label>Number USD</label>
    <input type="number" step="0.01" name="usd" required/><br>
    <button type="submit">Convert</button>
  </form>
  </body>
</html>
