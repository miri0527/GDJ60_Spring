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
	<h1 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">Member Join</h1>
	<form action="./memberLogin" method="post">
		<div class="mb-3 col-5 mx-auto" >
			<label for="id" class="form-label">ID</label>
			<input type="text" name="id" class="form-control" id="id"  placeholder="ID 입력"><br>
		</div>
		
		<div class="mb-3 col-5 mx-auto" >
			<label for="pw" class="form-label">PW</label>
			<input type="password" name="pw" class="form-control" id="pw"><br>
		</div>
		
		<div class="row col-5 mx-auto mt-4 ">
			<button type="submit" class="btn btn-outline-success col-2 ">등록</a><br>
		</div>
	
	</form>



<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>