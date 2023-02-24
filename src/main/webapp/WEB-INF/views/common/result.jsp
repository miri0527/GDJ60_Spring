<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	let message = '${result}'
	if(message !='') {
		alert(message);
	}

	
	//문자열이나 숫자를 넘겨줘야하기 때문에 "",''
	location.href="${url}"
</script>
</body>
</html>