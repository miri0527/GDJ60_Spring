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
	
	<h3><%=productDTO.getProduct_name() %></h3>
	<h3><%=productDTO.getProduct_detail() %></h3>
	
	<hr>
	<!-- getter에 get을 제외하고 첫글자 소문자 == 변수명 -->
	<h3>${requestScope.dto.product_name}</h3>
	<h3>${dto.getProduct_name() }</h3>
	<h3>${requestScope.dto.product_detail }</h3>
	<!-- scope명 생략가능 -> 서로 다른 Scope에 동일한 속성명이 있는 경우 생략 x-->
	<!-- ex)requestScope : dto = iu  sessionScope:dto=winter -->
	<!--getter메서드를 가져와도됨 -->
	<h3>${dto.getProduct_detail() }</h3>
	<hr>
	<h3>${requestScope.dto.product_jumsu* dto.product_num }</h3>
	
</body>
</html>