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
</head>
<body>
<div class="b-example-divider"></div>

<nav class="py-2 bg-light border-bottom">
  <div class="container d-flex flex-wrap">
    <ul class="nav me-auto">
      <li class="nav-item"><a href="#" class="nav-link link-dark px-2 active" aria-current="page">Home</a></li>
      <li class="nav-item"><a href="#" class="nav-link link-dark px-2">Features</a></li>
      <li class="nav-item"><a href="#" class="nav-link link-dark px-2">Pricing</a></li>
      <li class="nav-item"><a href="#" class="nav-link link-dark px-2">FAQs</a></li>
      <li class="nav-item"><a href="#" class="nav-link link-dark px-2">About</a></li>
    </ul>
    <ul class="nav">
      <li class="nav-item"><a href="#" class="nav-link link-dark px-2">Login</a></li>
      <li class="nav-item"><a href="#" class="nav-link link-dark px-2">Sign up</a></li>
    </ul>
  </div>
</nav>
<header class="py-3 mb-4 border-bottom">
  <div class="container d-flex flex-wrap justify-content-center">
    <a href="/" class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto text-dark text-decoration-none">
      <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
      <span class="fs-4">Double header</span>
    </a>
    <form class="col-12 col-lg-auto mb-3 mb-lg-0" role="search">
      <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
    </form>
  </div>
</header>
</body>
</html>
