<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-09
  Time: 오전 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boardUpdate.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
<div class="container">
    <form action="/update" method="post" name="updateForm" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${findById.id}" class="form-control">
        <input type="text" name="boardWriter" value="${findById.boardWriter}" class="form-control" readonly>
        <input type="text" name="boardTitle" value="${findById.boardTitle}" class="form-control">
        <textarea name="boardContents" cols="30" rows="10" class="form-control">${findById.boardContents}</textarea>
        <input type="file" name="boardFile" value="${findById.storedFileName_boards}" class="form-control">
        <input type="button" value="수정" onclick="updateCheck()" class="btn btn-warning">
    </form>
</div>
</body>
<script>
    const updateCheck = () => {
        document.updateForm.submit();
    }
</script>
</html>
