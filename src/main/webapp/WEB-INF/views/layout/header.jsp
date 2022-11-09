<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-09
  Time: 오전 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header.jsp</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
</head>
<body>
<div class="b-example-divider"></div>

<nav class="py-2 bg-light border-bottom">
  <div class="container d-flex flex-wrap">
    <ul class="nav me-auto">
      <li class="nav-item"><a href="/paging" class="nav-link link-dark px-2 active" aria-current="page">Home</a></li>
    </ul>
    <ul class="nav">
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      <div class="text-end">
        <c:choose>
        <c:when test="${sessionScope.loginEmail != null}">
        <span>${sessionScope.loginEmail}님</span>
        <button type="button" onclick="logoutFn()" class="btn btn-secondary me-2">Logout</button>
        </c:when>
        <c:otherwise>
        <button type="button" onclick="login()" class="btn btn-secondary me-2">Login</button>
        <button type="button" onclick="saveHeader()" class="btn btn-warning">Sign-up</button>
        </c:otherwise>
        </c:choose>

    </ul>
  </div>
</nav>
<header class="py-3 mb-4 border-bottom">
  <div class="container d-flex flex-wrap justify-content-center">
    <a href="/" class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto text-dark text-decoration-none">
      <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
      <span class="fs-4">BOARD</span>
    </a>
    <form action="/search" class="col-12 col-lg-auto mb-3 mb-lg-0" role="search">
      <div class="input-group">
        <select name="type" class="form-select">
          <option value="boardTitle" selected>제목</option>
          <option value="boardWriter">작성자</option>
        </select>
      <input type="search" name="q" class="form-control" placeholder="Search..." aria-label="Search">
      </div>
    </form>
  </div>
</header>
</body>
<script>
  const login = () => {
    location.href="/login";
  }
  const logoutFn = () => {
    location.href="/logout";
  }
  const saveHeader = () => {
    location.href="/save";
  }
</script>
</html>
