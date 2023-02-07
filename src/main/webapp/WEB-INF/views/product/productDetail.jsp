<%@page import="com.iu.s1.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ProductDetail Page</h1>
	
	<!-- model과 request와 속성이 같고, jsp는 model을 인식하지 못하기 때문에 request로 꺼낸다 -->
	<% ProductDTO productDTO= (ProductDTO)request.getAttribute("dto"); %>
	
	<h3><%=productDTO.getProductName() %></h3>
	<h3><%=productDTO.getProductDetail() %></h3>
	
	<hr>
	<!-- getter에 get을 제외하고 첫글자 소문자 == 변수명 -->
	<h3>${requestScope.dto.productName}</h3>
	<h3>${dto.getProductName() }</h3>
	<h3>${requestScope.dto.productDetail }</h3>
	<!-- scope명 생략가능 -> 서로 다른 Scope에 동일한 속성명이 있는 경우 생략 x-->
	<!-- ex)requestScope : dto = iu  sessionScope:dto=winter -->
	<!--getter메서드를 가져와도됨 -->
	<h3>${dto.getProductDetail() }</h3>
	<hr>
	<h3>${requestScope.dto.productJumsu* dto.productNum }</h3>
	
</body>
</html>