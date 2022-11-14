<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-08
  Time: 오후 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>boardDetail.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <script src="/resources/js/jquery.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
    <style>
        #detail {
            width: 800px;
            margin-top: 50px;
        }
        #comment-write {
            width: 600px;
        }
    </style>
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
<div class="container" id="detail">
    <table class="table table-hover">
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
            <th>작성시간</th>
            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${findById.boardCreatedDate}" ></fmt:formatDate></td>
        </tr>
        <tr>
            <th>조회수</th>
            <td>${findById.boardHits}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td>${findById.boardContents}</td>
        </tr>
        <c:if test="${findById.storedFileName_boards != null}">
            <tr>
                <th>파일</th>
                <td>
                    <img src="${pageContext.request.contextPath}/upload/${findById.storedFileName_boards}"
                         alt="" width="100" height="100">
                </td>
            </tr>
        </c:if>
    </table>
</div>
<div class="col text-center">
    <button onclick="listResult()" class="btn btn-primary ">목록</button>
<c:if test="${sessionScope.loginEmail == findById.boardWriter}">
    <button onclick="updateFn()" class="btn btn-warning" >수정하기</button>
</c:if>
    <c:if test="${sessionScope.loginEmail == findById.boardWriter or sessionScope.loginEmail == 'admin'}">
        <button onclick="boardDeleteFn()" class="btn btn-danger">삭제하기</button>
    </c:if>
</div>
<div class="container mt-5" id="comment-write">
    <div class="input-group" mb-3>
        <div class="form-floating">
            <input type="text" name="commentWriter" id="commentWriter" value="${sessionScope.loginEmail}" class="form-control" readonly>
        </div>
        <div class="form-floating">
            <input type="text" id="commentContents" class="form-control" placeholder="내용">
            <label for="commentContents">내용</label>
        </div>
        <button id="comment-write-btn" class="btn btn-secondary" onclick="commentWrite()">댓글작성</button>
    </div>
</div>
<div class="container mt-5" id="comment-list">
    <table class="table">
        <tr>
            <th>댓글번호</th>
            <th>작성자</th>
            <th>내용</th>
            <th>작성시간</th>
        </tr>
        <c:forEach items="${commentList}" var="comment">
            <tr>
                <td>${comment.id}</td>
                <td>${comment.commentWriter}</td>
                <td>${comment.commentContents}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${comment.commentCreatedDate}"></fmt:formatDate></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script>
    const commentWrite = () => {
        const writer = document.getElementById("commentWriter").value;
        const contents = document.getElementById("commentContents").value;
        const id = '${findById.id}';
        $.ajax({
            type:"post",
            url:"/commentSave",
            data: {
                commentWriter: writer,
                commentContents: contents,
                CommentId: id
            },
            dateType:"json",
            success: function (commentList){
                console.log(commentList);
                let output = "<table class='table'>";
                output += "<tr><th>댓글번호</th>";
                output += "<th>작성자</th>";
                output += "<th>내용</th>";
                output += "<th>작성시간</th></tr>";
                for(let i in commentList){
                    output += "<tr>";
                    output += "<td>"+commentList[i].id+"</td>";
                    output += "<td>"+commentList[i].commentWriter+"</td>";
                    output += "<td>"+commentList[i].commentContents+"</td>";
                    output += "<td>"+moment(commentList[i].commentCreatedDate).format("YYYY-MM-DD HH:mm:ss")+"</td>";
                    output += "</tr>";
                }
                output += "</table>";
                document.getElementById('comment-list').innerHTML = output;
                document.getElementById('commentWriter').value='';
                document.getElementById('commentContents').value='';
            },
            error: function (){
                console.log("실패");
            }
        });
    }
    const listResult = () => {
        const page = '${page}';
        location.href="/paging?page="+page;
    }
    const updateFn = () => {
        const id = '${findById.id}';
        location.href="/update?id="+id;
    }
    const boardDeleteFn = () => {
        const id= '${findById.id}';
        location.href="/boardDelete?id="+id;
    }
</script>
</html>
