<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Quản lý sản phẩm đấu giá</title>
    <style>
        .container {
            max-width: 1000px;
            margin: 20px auto;
            padding: 0 15px;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
        }
        .header h2 {
            margin: 0;
        }
        .header .btn-add {
            background-color: #1976d2;
            color: white;
            padding: 6px 12px;
            text-decoration: none;
            border-radius: 4px;
        }
        .header .btn-add:hover {
            background-color: #155a9c;
        }
        .search-form {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
            margin-bottom: 15px;
        }
        .search-form input,
        .search-form select {
            padding: 6px 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .search-form .btn-search {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 6px 12px;
            border-radius: 4px;
            cursor: pointer;
        }
        .search-form .btn-search:hover {
            background-color: #0056b3;
        }
        .search-form .btn-clear {
            padding: 6px 12px;
            text-decoration: none;
            color: #333;
        }
        .auction-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 10px;
        }
        .auction-table th,
        .auction-table td {
            padding: 10px 12px;
            border-bottom: 1px solid #e0e0e0;
            text-align: left;
            vertical-align: middle;
            font-size: 14px;
        }
        .auction-table th {
            background-color: #1976d2;
            color: white;
            font-weight: 600;
        }
        .auction-table tr:nth-child(even) {
            background-color: #f4f8fc;
        }
        .auction-table tr:hover {
            background-color: #e3f0fb;
        }
        .auction-table th:first-child,
        .auction-table td:first-child {
            width: 50px;
            text-align: center;
        }
        .btn-delete {
            background-color: transparent;
            color: #dc3545;
            border: none;
            cursor: pointer;
            font-size: 14px;
            margin-bottom: 15px;
        }
        .btn-delete:hover {
            text-decoration: underline;
        }
        .pagination {
            display: flex;
            gap: 5px;
        }
        .pagination a {
            display: block;
            padding: 6px 10px;
            text-decoration: none;
            color: #007bff;
            border: 1px solid #dee2e6;
            border-radius: 4px;
        }
        .pagination a:hover {
            background-color: #e9ecef;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h2>Quản lý sản phẩm đấu giá</h2>
        <a href="${pageContext.request.contextPath}/product/add" class="btn-add">
            Thêm sản phẩm
        </a>
    </div>

    <form class="search-form" action="" method="get">
        <input type="text" name="name" placeholder="Tên sản phẩm" value="${name}" />
        <input type="number" name="price" placeholder="Giá bắt đầu" value="${price}" />
        <select name="typeId">
            <option value="">--Chọn loại sản phẩm--</option>
            <c:forEach var="type" items="${productTypes}">
                <option value="${type.cid}" <c:if test="${type.cid == typeId}">selected</c:if>>
                        ${type.name}
                </option>
            </c:forEach>
        </select>
        <button type="submit" class="btn-search">Tìm</button>
        <a href="${pageContext.request.contextPath}/product" class="btn-clear">Xóa tìm kiếm</a>
    </form>

    <form id="deleteForm" action="${pageContext.request.contextPath}/product/delete" method="post">
        <table class="auction-table">
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
        <button type="button" class="btn-delete" onclick="confirmDelete()">Xóa</button>
    </form>

    <div class="pagination">
        <c:forEach var="i" begin="0" end="${(total/pageSize) - (total%pageSize==0?1:0)}">
            <a href="?page=${i}&name=${name}&price=${price}&typeId=${typeId}">${i+1}</a>
        </c:forEach>
    </div>
</div>

<script>
    function confirmDelete() {
        var checked = document.querySelectorAll('input[name="ids"]:checked');
        if (checked.length === 0) {
            alert("Chọn sản phẩm muốn xóa!");
            return false;
        }
        if (confirm("Bạn có chắc chắn muốn xóa các sản phẩm đã chọn?")) {
            document.getElementById('deleteForm').submit();
        }
    }
</script>
</body>
</html>
