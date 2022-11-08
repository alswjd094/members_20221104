<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-08
  Time: 오전 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>boardList.jsp</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>
<div class="container">
  <table class="table table-striped table-hover">
    <tr>
      <th>번호</th>
      <th>작성자</th>
      <th>제목</th>
      <th>내용</th>
      <th>작성시간</th>
    </tr>
    <c:forEach items="${findAll}" var="board">
      <tr>
        <td>${board.id}</td>
        <td>${board.boardWriter}</td>
        <td>${board.boardTitle}</td>
        <td>${board.boardContents}</td>
        <td><fmt:formatDate value="${board.boardCreatedDate}" pattern="yyyy-MM-dd HH:mm:ss" ></fmt:formatDate></td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
