<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Remove Test</h1>
	
	<!-- begin end가 아닌 items로 컬렉션을 받아오면 var는 숫자가 아니기 때문에 변수 i로 쓸 수 없다 -->
	<!-- 그렇기 떄문에 varStatus 사용 -->
	<c:forEach begin="0" end="4"  varStatus="j">
		<div id="p${j.index}">
			<h3>${j.index}</h3>
			<button class="btn">DELETE</button>
		</div>
		
	</c:forEach>

	<script>
		const btn = document.getElementsByClassName("btn")
	

		for(let i=0; i<btn.length; i++) {
			btn[i].addEventListener("click",function() {
				document.getElementById("p"+i).remove();
			})
		}
	</script>
</body>
</html>