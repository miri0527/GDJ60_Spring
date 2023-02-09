<%@page import="com.iu.s1.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/product.css">
</head>
<body>
	<h1 class="title">ProductList Page</h1>
	<% List<ProductDTO> ar = (List<ProductDTO>) request.getAttribute("list"); %>
	<%
		for(ProductDTO productDTO : ar) {
	%>
		<h3><%= productDTO.getProductName() %></h3>
		<h3><%= productDTO.getProductJumsu() %></h3>
	<%} %>
	
	<hr>
	<!-- var: 담을 변수명(위에 productDTO와 동일 -->
	<table class="table1" border="1">
		<thead>
			<tr>
				<th>상품명</th> <th>평점</th>
			</tr>
		</thead>
		
		<tbody>
			<!-- dto -> productDTO처럼 하나씩 꺼내기 위해서 변수 선언 -->
			<c:forEach items="${list}" var = "dto"> <!-- dto는 page영역에 담김 -->
				<tr>
				<td><a href = "./detail?productNum=${dto.productNum}">${pageScope.dto.productName}</a></td>
				<td>${dto.productJumsu}</td>
				</tr>
				
			</c:forEach>
	
		</tbody>
	</table>
	
		<a class="btn btn-danger" href = "./productAdd">상품등록</a>
</body>
</html>