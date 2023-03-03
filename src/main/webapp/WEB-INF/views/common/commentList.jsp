<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--부품으로 쓰는 것은 html 태그 필요 없다  -->    

<table class="table table-striped">
<c:forEach items = "${list}" var="dto">
	<tr>
		<td>${dto.contents}</td>
		<td>${dto.writer}</td>
		<td>${dto.regDate}</td>
	</tr>
</c:forEach>
</table>