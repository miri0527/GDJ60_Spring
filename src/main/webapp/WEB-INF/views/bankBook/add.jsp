<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 등록 Page</h1>
	
	<form action="./add" method="post">
		상품명: <input type="text" name="bookName" placeholder="제품명 입력"><br>
		<!-- Element : 태그명 타입 content로 구성 -->
		이자율 : <input type="text" name="bookRate" value="1.5"><br>
		상세정보:<br> 
		<textarea name="bookDetail" rows="10" cols="30"></textarea><br>
		판매여부: <input type="number" name="bookSale"><br>
		<input type="submit" value="등록">
		<button type="submit">전송</button> 
	</form>
</body>
</html>