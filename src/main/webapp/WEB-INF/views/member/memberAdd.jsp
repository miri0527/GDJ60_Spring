<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<style>
	.redResult {
		color: red;
	}
	
	.blueResult {
		color: blue;
	}
	
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">Member Join</h1>
	<form action="./memberAdd" id="frm" method="post">
		<div class="mb-3 col-5 mx-auto" >
			<label for="id" class="form-label">아이디 입력</label>
			<input type="text" name="id" class="form-control" id="id"  placeholder="아이디 입력"><br>
			<div id="idResult"></div>
		</div>
		
		<div class="mb-3 col-5 mx-auto" >
			<label for="pw" class="form-label">비밀번호 입력</label>
			<input type="password" name="pw" class="form-control" id="pw"  placeholder="비밀번호 입력"><br>
			<div id="pwResult"></div>
		</div>
		
		<div class="mb-3 col-5 mx-auto" >
			<label for="pw2" class="form-label">비밀번호 확인</label>
			<input type="password" name="pwCheck" class="form-control" id="pw2"  placeholder="비밀번호 입력"><br>
			<div id="pw2Result"></div>
		</div>

		<div class="mb-3 col-5 mx-auto" >
			<label for="name" class="form-label">이름</label>
			<input type="text" name="name" class="form-control" id="name"><br>
			<div id="nameResult"></div>
		</div>
		
		<div class="mb-3 col-5 mx-auto" >
			<label for="phone" class="form-label">전화번호</label>
			<input type="text" name="phone" class="form-control" id="phone" ><br>
			<div id="phoneResult"></div>
		</div>
		
		<div class="mb-3 col-5 mx-auto" >
			<label for="email" class="form-label">Email</label>
			<input type="text" name="email" class="form-control" id="email" ><br>
			<div id="emailResult"></div>
		</div>
				
		<div class="row col-5 mx-auto mt-4 ">
			<button type="submit" class="btn btn-outline-success col-2 " id="btn">등록</a><br>
		</div>
		
	</form>



<c:import url="../template/common_js.jsp"></c:import>
<script src="../resources/js/memberJoin.js"></script>
</body>
</html>