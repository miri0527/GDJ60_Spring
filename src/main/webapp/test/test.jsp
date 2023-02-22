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
	
	<!--<div id="result">
		<c:forEach begin="0" end="4" var="i" varStatus="j">
			<div id="p${j.index}" class="items">
				<h3>${i}</h3>
				//data -> 어떤 데이터를 담고 싶을 때
				<button class="btn" data-div-id="p${j.index}" >DELETE</button>
			</div>
		</c:forEach>
	</div>-->

	<div id = result>
		<c:forEach begin="0" end="5" var="i">
			<div>
				<h3>${i}</h3>
				<button class="btn">DELETE</button>
			</div>
		</c:forEach>
	</div>


	
	<button id="deleteAll">DELETEALL</button>
	<script>
		const btn = document.getElementsByClassName("btn")
		const deleteAll = document.getElementById("deleteAll")
		const result = document.getElementById("result")

		deleteAll.addEventListener("click", function() {
			let items = document.getElementsByClassName('items')

			//배열의 길이가 바뀌기 때문에 i=0일때 0번 지워지고, 
			//i=1일 때 배열 길이가 4이고, 그 0번이 지워진다
			// for(let i=0; i<items.length; i++) {
			// 	items[i].remove();
			// }

			for(let i=0; i !=items.length;) {
				items[0].remove();
			}
		})

		for(let i=0; i<btn.length; i++) {
			btn[i].addEventListener("click", function() {
				//document.getElementById("p" + i).remove()
				let id= this.getAttribute*'data-div-id'
				document.getElementById("p" + i).remove()
			})
		}
	</script>
</body>
</html>