<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
		<div class="container-fluid my-5">
	<div class="row mb-4  ">
		<h1 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">회원 수정 Page</h1>
	</div>
	<form action="./memberUpdate" method="post">
		<!--프론트는 보안에 취약하기 때문에 클라이언트가 수정을 할 수가 있다  -->
		<!-- <input type="hidden" name="id" value="${member.id}"> -->
		
		
		<div class="mb-3 col-5 mx-auto" >
			<label for="name" class="form-label">이름 수정</label>
			<input type="text" name="name" class="form-control" id="name" value="${dto.name}" ><br>
			<!-- Element : 태그명 타입 content로 구성 -->
		</div>
		<div class="mb-3 col-5 mx-auto">
			<label for="phone" class="form-label">전화번호 수정</label>
			<input type="text" name="phone" class="form-control" id="phone" value="${dto.phone}" ><br>
		</div>
			
		<div class="mb-3 col-5 mx-auto">
			<label for="email" class="form-label">이메일 수정</label>
			<input type="text" name="email" class="form-control" id="email" value="${dto.email}"><br>
		</div>
		
		<div class="row col-5 mx-auto mt-4 ">
			<button type="submit" class="btn btn-outline-success col-2 ">수정</button><br>
		</div>
	</form>	
		
</body>
</html>