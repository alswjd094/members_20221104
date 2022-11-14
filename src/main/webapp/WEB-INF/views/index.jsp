<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오전 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>
<div class="col text-center">
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>

<c:choose>
    <c:when test="${sessionScope.loginEmail != null}">
        <button type="button" onclick="logoutFn2()" class="btn btn-danger">로그아웃</button>
    </c:when>
    <c:otherwise>
        <button onclick="saveFn()" class="btn btn-primary" >회원가입</button>
        <button onclick="loginFn()" class="btn btn-primary" >로그인</button>
    </c:otherwise>
</c:choose>
<%--<button onclick="boardListFn()" class="btn btn-primary">글목록</button>--%>
<button onclick="listPagingFn()" class="btn btn-primary" >글목록</button>
</div>
</body>
<script>
    const saveFn = () => {
        location.href="/save";
    }
    const logoutFn2 = () => {
        location.href="/logout";
        }
    const loginFn = () => {
     location.href="/login";
    }
    const boardListFn = () => {
     location.href="/board";
    }
    const listPagingFn = () => {
        location.href="/paging";
    }

</script>
</html>
