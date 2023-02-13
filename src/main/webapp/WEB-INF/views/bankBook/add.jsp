<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid my-5">
	<div class="row mb-4  ">
		<h1 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">상품 등록 Page</h1>
	</div>
	<form action="./add" method="post">
		<div class="mb-3 col-5 mx-auto" >
			<label for="name" class="form-label">상품명</label>
			<input type="text" name="bookName" class="form-control" id="name"  placeholder="제품명 입력"><br>
			<!-- Element : 태그명 타입 content로 구성 -->
		</div>
		<div class="mb-3 col-5 mx-auto">
			<label for="rate" class="form-label">이자율</label>
			<input type="text" name="bookRate" class="form-control" id="rate" value="1.5"><br>
		</div>
			
		<div class="mb-3 col-5 mx-auto">
  			<label for="Textarea1" class="form-label">상세정보</label>
 	 		<textarea class="form-control" id="Textarea1" rows="3" name="bookDetail" placeholder="상세 정보 입력"></textarea>
		</div>
		
		<div class="mb-3 col-5 mx-auto">
			<label class="form-label">판매여부</label>
			<div class="form-check">
			  <input class="form-check-input" type="radio" value="1" id="flexCheckDefault" name="bookSale" checked>
			  <label class="form-check-label" for="flexCheckDefault">
			    판매중
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="radio" value="0" id="flexCheckChecked" name="bookSale">
			  <label class="form-check-label" for="flexCheckChecked" >
			    판매중단
			  </label>
			</div>
			<div class="form-check form-switch">
				<label class="form-check-label" for="bookSale">판매여부</label>
				<input name="bookSale" class="form-check-input" type="checkbox" value="1" role="switch" id="bookSale">
			</div>
		</div>
		
		<div class="row col-5 mx-auto mt-4 ">
			<button type="submit" class="btn btn-outline-success col-2 ">등록</a><br>
		</div>
	</form>
</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>