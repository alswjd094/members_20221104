<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-08
  Time: 오전 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boardWriting.jsp</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
<div class="container">
  <form action="/writing" method="post" name="saveForm2" enctype="multipart/form-data">
    <input type="text" name="boardTitle" placeholder="제목" class="form-control">
    <span id="title-input-check"></span>
    <textarea name="boardContents" cols="30" rows="10" placeholder="내용을 입력하세요" class="form-control"></textarea>
    <span id="contents-input-check"></span>
    <input type="file" name="boardFile" placeholder="첨부파일" class="form-control">
    <input type="text" name="boardWriter" value="${sessionScope.loginEmail}" class="form-control" readonly>
    <input type="button" value="작성" onclick="writingCheck()" class="btn btn-primary">
  </form>
</div>
</body>
<script>
  const writingCheck = () => {
    if(document.saveForm2.boardTitle.value===""){
      const titleCheck = document.getElementById("title-input-check");
      titleCheck.innerHTML="제목을 입력해주세요";
      titleCheck.style.color="red";
      return false;
    }else if(document.saveForm2.boardContents.value===""){
      const contentsCheck = document.getElementById("contents-input-check");
      contentsCheck.innerHTML="내용을 입력해주세요";
      contentsCheck.style.color="red";
      return false;
    }
    document.saveForm2.submit();
  }
</script>
</html>
