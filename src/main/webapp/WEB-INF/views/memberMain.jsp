<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오전 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>memberMain.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
<button onclick="logout()" class="btn btn-danger">로그아웃</button>
<button onclick="writeFn()" class="btn btn-primary">글작성</button>
<button onclick="listFn()" class="btn btn-primary">글조회</button>
<c:if test="${sessionScope.loginEmail == 'admin'}">
<button onclick="pagingListFn()" class="btn btn-warning">관리자페이지</button>
</c:if>
</body>
<script>
    const logout = () => {
        location.href="/logout";
    }
    const writeFn = () => {
        location.href="/writing";
    }
    const listFn = () => {
        location.href="/paging";
    }
    const pagingListFn = () => {
        location.href="/admin";
    }
</script>
</html>
