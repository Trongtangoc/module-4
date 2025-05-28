<%--
  Created by IntelliJ IDEA.
  User: lebui
  Date: 5/27/2025
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h3>Sandwich Condiments: </h3>
<form action="/home/save">
  <input type="checkbox" id="condi1" name="condi1" value="Lettuce">
  <label for="condi1">Lettuce</label>
  <input type="checkbox" id="condi2" name="condi1" value="Tomato">
  <label for="condi2">Tomato</label>
  <input type="checkbox" id="condi3" name="condi1" value="Mustard">
  <label for="condi3">Mustard</label>
  <input type="checkbox" id="condi4" name="condi1" value="Sprouts">
  <label for="condi4">Sprouts</label>
<input type="submit" value="Submit">
</form>
</body>
</html>
