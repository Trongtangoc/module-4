<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Tra cứu từ Anh - Việt</title>
  <meta charset="UTF-8">
</head>
<body>
<h1>Tra cứu từ Anh - Việt</h1>

<form action="search" method="post">
  <input type="text" name="word" placeholder="Nhập từ tiếng Anh" required />
  <button type="submit">Tra cứu</button>
</form>

<c:if test="${not empty meaning}">
  <h3>Từ: ${word}</h3>
  <p>Nghĩa: ${meaning}</p>
</c:if>

<c:if test="${not empty notFound}">
  <p style="color: red;">${notFound}</p>
</c:if>

</body>
</html>
