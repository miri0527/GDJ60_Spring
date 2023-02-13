<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품리스트</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid my-5">
	<div class="row mb-4">
		<h1 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">ProductAdd Page</h1>
	</div>
	
		<form action = "./productAdd" method = "post">
		
			<div >
				
			</div>
			<div class="mb-3 col-5 mx-auto" >
			<label for="name" class="form-label">상품명</label>
			<input type="text" name="productName" class="form-control" id="name"  placeholder="제품명 입력"><br>
			</div>
			
			<div class="mb-3 col-5 mx-auto">
  			<label for="Textarea1" class="form-label">상세정보</label>
 	 		<textarea class="form-control" id="Textarea1" rows="3" name="productDetail" placeholder="상세 정보 입력"></textarea>
		</div>
		
		<div class="row col-5 mx-auto mt-4 ">
			<button type="submit" class="btn btn-outline-success col-2 ">등록</a><br>
		</div>
			
		</form>
</div>	
<script type="text/javascript" src="../template/common_js.jsp"></script>	
</body>
</html>