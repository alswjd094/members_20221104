<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-08
  Time: 오후 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>boardDetail.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>
<div class="container">
    <table class="table table-striped table-hover">
        <tr>
            <th>번호</th>
            <td>${findById.id}</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>${findById.boardWriter}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>${findById.boardTitle}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td>${findById.boardContents}</td>
        </tr>
        <tr>
            <th>조회수</th>
            <td>${findById.boardHits}</td>
        </tr>
    </table>
</div>
<c:if test="${sessionScope.loginEmail == findById.boardWriter}">
<button onclick="updateFn()" class="btn btn-warning" style="float:right">수정하기</button>
</c:if>




</body>
<script>
    const updateFn = () => {
        const id = '${findById.id}';
        location.href="/update?id="+id;
    }
</script>
</html>
