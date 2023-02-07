<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ProductAdd Page</h1>
	<div class = "col-6">
		<form action = "./productAdd" method = "post">
			상품명: 
			<!-- name: parameter의 이름 -->
			<input type = "text" name = "productName" ><br>
			상품정보<br>
			<textarea name="product_detail" id="" cols="30" rows="10"></textarea><br>
			<button type = submit>등록</button>
			
		</form>
		
	</div>
	
</body>
</html>