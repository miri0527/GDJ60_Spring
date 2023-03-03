<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
			<%--<% List<BbsDTO> ar = (List<BbsDTO>)request.getAttribute("list"); %>  --%>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>NUM</th> <th>TITLE</th> <th>WRITER</th> <th>DATE</th> <th>HIT</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var = "dto" varStatus="i">
					<!-- BbsDTO에 title, regDate, hit는 없지만 자동으로 호출됨 -->
					<!--이유: -->
						<tr>
							<td>${dto.num}</td>	
							
							<td>
							<a href="./detail?num=${dto.num}">${dto.title}</a>
							
							<c:if test="${i.first}">
								${dto.contents}
							</c:if>
							</td>
							
							
						</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
