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
		<fieldset>
			상품명: <input type="text" name="bookName" placeholder="제품명 입력"><br>
			<!-- Element : 태그명 타입 content로 구성 -->
		</fieldset>
		
		<fieldset>
			<legend>이자율</legend>
			<input type="text" name="bookRate" value="1.5"><br>
		</fieldset>
		
		<fieldset>>
			<legend>상세정보</legend>
			<textarea name="bookDetail" rows="10" cols="30"></textarea><br>
		</fieldset>
			
		<fieldset>
			<legend>판매여부</legend>
			<label for="bs1">판매</label>
			<input id="bs1" type="radio" name="bookSale" value="1" checked>
			
			<label for="bs2">판매중단</label>	
			<input id="bs2" type="radio" name="bookSale" value="0">
		</fieldset>	
		
			<select name="bookSale">
				<option value="1">판매</option>
				<option value="0" selected>판매중단</option>
			</select>
		<button type="submit">전송</button> 
	</form>
</body>
</html>