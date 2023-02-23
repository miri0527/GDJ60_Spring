<%@page import="com.iu.s1.board.BbsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid">
		<div class="row">
			<%--<% List<BbsDTO> ar = (List<BbsDTO>)request.getAttribute("list"); %>  --%>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>NUM</th> <th>TITLE</th> <th>WRITER</th> <th>DATE</th> <th>HIT</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var = "dto">
					<!-- BbsDTO에 title, regDate, hit는 없지만 자동으로 호출됨 -->
					<!--이유:   -->
						<tr>
							<td>${dto.num}</td>	
							<td><a href="./detail">${dto.title}</a></td>
							<td>${dto.writer }</td>
							<td>${dto.regDate }</td>
							<td>${dto.hit }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
		
			<!-- Paging -->
	      <div class="rowmx-auto">
	         <nav aria-label="Page navigation example">
	            <ul class="pagination justify-content-center">
	            
	               <li class="page-item ${pager.page eq 1?'disabled':''}">
	                  <a class="page-link" href="#" aria-label="Previous" data-board-page="1">
	                     <span aria-hidden="true">&laquo;</span>
	                  </a>
	               </li>
	               
	               <li class="page-item ${pager.before?'disabled':''}">
	                  <a class="page-link" href="#" aria-label="Previous" data-board-page="${pager.startNum-1}">
	                     <span aria-hidden="true">&lsaquo;</span>
	                  </a>
	               </li>
	               
	               <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
	                  <li class="page-item"><a class="page-link" href="#" data-board-page="${i}">${i}</a></li>
	               </c:forEach>
	               
	               <li class="page-item  ${pager.after eq false ? 'disabled' : ''}">
	                  <a class="page-link" href="#"  aria-label="Next" data-board-page="${pager.lastNum+1}">
	                     <span aria-hidden="true">&rsaquo;</span>
	                  </a>
	                </li>
	                
	                <li class="page-item ${pager.page eq pager.totalPage?'disabled' : ''}">
	                  <a class="page-link" href="#"  aria-label="Next" data-board-page="${pager.totalPage}">
	                     <span aria-hidden="true">&raquo;</span>
	                  </a>
	                </li>
	                
	            </ul>
	         </nav>
	      </div>
	      
	      <!-- 검색창 -->
	      <form action="./list" method="get" class="row g-3" id="searchForm">
	      	<input type="hidden" name="page" value="1" id="page">
	         <div class="row justify-content-center mx-auto">
	            <div class="col-auto">
	               <label for="kind" class="visually-hidden">Email</label>
	               <select class="form-select" name="kind" id="kind" aria-label="Default select example">
	                  <option value="title" ${pager.kind eq 'title' ? 'selected' : ''}>Title</option>
	                  <option value="contents " ${pager.kind eq 'contents' ? 'selected : ''>Contents</option>
	                  <option value="writer" ${pager.kind eq 'writer' ? 'selected' : ''>Writer</option>
	               </select>
	            </div>
	            <div class="col-auto">
	               <label for="search" class="visually-hidden">Search</label>
	               <input type="text" class="form-control" value="${pager.search}" name="search" id="search" placeholder="검색어를 입력하세요.">
	            </div>
	            <div class="col-auto">
	               <button type="submit" class="btn btn-outline-primary mb-3">검색</button>
	            </div>
	         </div>
	      </form>
	      
		</div>
		
	</div>
	
<c:import url="../template/common_js.jsp"></c:import>	
<script src="../resources/js/pageing.js"></script>
<script>
	setDA=ata{'${pager.searcg}'}
</script>
</body>
</html>