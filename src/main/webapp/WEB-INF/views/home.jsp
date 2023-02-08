<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<a href = "./product/list?num=1&num=2&num=3">Product List</a>
<a href = "/product/list">Product List</a>
<!-- 절대경로 -->
<a href=" /bankBook/list">BankBookList</a>
<!-- 상대경로 -->
<a href="./bankBook/list">BankBookList</a>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
