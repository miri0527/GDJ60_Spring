<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 여기에 css를 붙여놓으면 header.jsp로 붙여놓을 때 html이 2개가 되기 때문에 css링크는 html 자체를 지우고 걸어놔야된다 -->
</head>
<body>
`	<header>
		<div class="header_wrap">
			<div class="header_logo">
				<a href="/"><img src="/resources/images/logo.png" alt=""></a>
			</div>
			<nav class="header_nav">
				<ul>
					<li><a href="#">공지사항</a></li>
					<li><a href="/product/list">제품</a></li>
					<li><a href="/bankBook/list">저축상품</a></li>
					<li><a href="#">기타메뉴</a></li>
				</ul>
			</nav>
			<div class="header_sub">
				<ul>
					<li><a href="#">LOGIN</a></li>
					<li><a href="/member/memberAdd">JOIN</a></li>
					<li><a href="#">KO</a></li>
					<li><a href="#">EN</a></li>
					<li><a href="#">JP</a></li>
					<li><a href="#">CH</a></li>
				</ul>
			</div>
		</div>
	</header>
</body>
</html>