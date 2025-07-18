<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Quản lý sản phẩm</title>
</head>
<style>
    table{
    border-collapse: collapse;}
    th, td {
        padding: 10px 12px;
        border-bottom: 1px solid #e0e0e0;
        font-size: 14px;
        text-align: left;
    }

    th {
        background: #1976d2;
        color: #fff;
        font-weight: 600;
    }
    tr:nth-child(even) {
        background: #f4f8fc;
    }

    tr:hover {
        background: #e3f0fb;
    }

</style>
<body>
<h2>Quản lý sản phẩm đấu giá</h2>
<a href="${pageContext.request.contextPath}/product/add">Thêm sản phẩm</a>
<form action="" method="get">
    <input type="text" name="name" placeholder="Tên sản phẩm" value="${name}"/>
    <input type="number" name="price" placeholder="Giá bắt đầu" value="${price}"/>
    <select name="typeId">
        <option value="">--Chọn loại sản phẩm--</option>
        <c:forEach var="type" items="${productTypes}">
            <option value="${type.cid}" <c:if test="${type.cid == typeId}">selected</c:if>>${type.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Tìm</button>
    <a href="${pageContext.request.contextPath}/product">Xóa tìm kiếm</a>
</form>
<form id="deleteForm" action="${pageContext.request.contextPath}/product/delete" method="post">
    <table border="1" b >
        <thead>
        <tr>
            <th>STT</th>
            <th>Chọn</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Loại</th>
            <th>Tình trạng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${products}" varStatus="i">
            <tr>
                <td>${i.index + 1 + (page * pageSize)}</td>
                <td><input type="checkbox" name="ids" value="${p.id}" /></td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>${p.productType.name}</td>
                <td>${p.status}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="button" onclick="confirmDelete()">Xóa</button>
</form>
<div>
    <c:forEach var="i" begin="0" end="${(total / pageSize) - (total % pageSize == 0 ? 1 : 0)}">
        <a href="?page=${i}&name=${name}&price=${price}&typeId=${typeId}">${i+1}</a>
    </c:forEach>
</div>
<script>
    function confirmDelete() {
        var checked = document.querySelectorAll('input[name="ids"]:checked');
        if(checked.length === 0) {
            alert("Chọn sản phẩm muốn xóa!");
            return false;
        }
        if(confirm("Bạn có chắc chắn muốn xóa các sản phẩm đã chọn?")) {
            document.getElementById('deleteForm').submit();
        }
    }
</script>
</body>
</html>
