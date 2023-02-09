<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 수정 Page</h1>
	
	<form action="./update" method='post'>
	<!-- value -> 실제로 들어가는 값 name=parameter -->
	<!-- Element : 태그명 타입 content로 구성 -->
		<input type="hidden" name="bookNum" value="${dto.bookNum}">
		<fieldset>
			<legend>상품명</legend>
			<input type="text" name="bookName" value="${dto.bookName}"><br>
		</fieldset>
		
		<fieldset>
			<legend>이자율</legend>
			<input type="text" name="bookRate" value="${dto.bookRate}"><br>
		</fieldset>
		
		<fieldset>
			<legend>상세정보</legend>
			<textarea name="bookDetail" rows="10" cols="30">${dto.bookDetail }</textarea>
		</fieldset>
		
		<fieldset>
			<legend>판매여부</legend>
			<label for="bts1">판매</label>
			<input id="bts1" type="radio" name="bookSale" value="1" ${dto.bookSale eq '1' ? 'checked':''}>
			
			<label for="bts2">판매중단</label>
			<input id="bts2" type="radio" name="bookSale" value="0" ${dto.bookSale eq '0' ? 'checked':''}>
		</fieldset>
		
		<fieldset>
			<label>판매여부</label>
			<select>
				<option>판매</option>
				<option>판매중단</option>
			</select>
		
		</fieldset>
		<input type="submit" value="수정">
		<button type="submit">수정</button> 
	</form>
</body>
</html>