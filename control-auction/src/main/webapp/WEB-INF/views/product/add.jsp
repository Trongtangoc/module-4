<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm đấu giá</h2>
<c:if test="${not empty error}">
    <span style="color:red">${error}</span>
</c:if>
<form action="${pageContext.request.contextPath}/product/add" method="post">
    <div>
        <label>Tên sản phẩm</label>
        <input type="text" name="name" value="${product.name}"/>
    </div>
    <div>
        <label>Giá bắt đầu</label>
        <input type="number" name="price" value="${product.price}"/>
    </div>
    <div>
        <label>Loại sản phẩm</label>
        <select name="productType.cid">
            <option value="">--Chọn loại sản phẩm--</option>
            <c:forEach var="type" items="${productTypes}">
                <option value="${type.cid}" <c:if test="${product.productType != null && type.cid == product.productType.cid}">selected</c:if>>${type.name}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label>Tình trạng</label>
        <input type="text" name="status" value="${product.status}"/>
    </div>
    <button type="submit">Thêm</button>
    <a href="${pageContext.request.contextPath}/product">Quay lại</a>
</form>
</body>
</html>
