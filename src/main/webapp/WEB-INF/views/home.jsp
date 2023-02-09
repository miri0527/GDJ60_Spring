<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/main.css">
</head>
<body>
<h1>
	Hello world!  
</h1>
<div class="none">
	<a href = "./product/list?num=1&num=2&num=3">Product List</a>
	<a href = "/product/list">Product List</a>
	<!-- 절대경로 -->
	<a href=" /bankBook/list">BankBookList</a>
	<!-- 상대경로 -->
	<a href="./bankBook/list">BankBookList</a>
</div>
<!-- resources밑에는 img가 뜬다 -> servlet-context.xml에 resources하위 폴더에 있으면 servlet으로 보내지말고 location으로 가라 -->
<img alt="아이유이쁜이미지" src="/resources/images/iu.jpg" width="200" height="300">
<img alt="아이유귀여운이미지" src="./resources/images/iu2.jpg" width="200" height="300">

<p><iframe width="500" height="300" src="https://www.youtube.com/embed/bQwU88XlEqg" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
</p>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
