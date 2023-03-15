<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>저축상품</title>
<c:import url="../template/common_css.jsp"></c:import>


</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container-fluid my-5">	
	<div class="row mb-4  ">
		<h1 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">BankBook List Page</h1>
	</div>
	
	<div class="row col-md-7 mx-auto">
		<table class="table table-hover">
		<thead>
			<tr>
				<th>상품명</th> 
				<th>이자율</th>
				<th>판매여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><a href="./detail?bookNum=${dto.bookNum}">${dto.bookName}</a></td>
					<td class="tb1_td">${dto.bookRate}</td>
					<td class="tb1_td">
						<%-- <c:choose>
							<c:when test="${dto.bookSale eq 1}">판매중</c:when>
							<c:otherwise>판매중단</c:otherwise>
						</c:choose> --%>
						<c:if test="${dto.bookSale eq 1}">판매중</c:if>
						<c:if test="${dto.bookSale eq 0}">판매중단</c:if>
					</td>
				</tr>
			
			</c:forEach>
			
		</tbody>
		</table>
		
		<!-- Paging -->
      <div class="rowmx-auto">
         <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
            
               <li class="page-item ${pager.page eq 1?'disabled':''}">
                  <a class="page-link" href="./list?page=1&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
                     <span aria-hidden="true">&laquo;</span>
                  </a>
               </li>
               
               <li class="page-item ${pager.before?'disabled':''}">
                  <a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
                     <span aria-hidden="true">&lsaquo;</span>
                  </a>
               </li>
               
               <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
                  <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
               </c:forEach>
               
               <li class="page-item  ${pager.after eq false ? 'disabled' : ''}">
                  <a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}"  aria-label="Next">
                     <span aria-hidden="true">&rsaquo;</span>
                  </a>
                </li>
                
                <li class="page-item ${pager.page eq pager.totalPage?'disabled' : ''}">
                  <a class="page-link" href="./list?page=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}"  aria-label="Next">
                     <span aria-hidden="true">&raquo;</span>
                  </a>
                </li>
                
            </ul>
         </nav>
      </div>
	</div>
	
	   <!-- 검색창 -->
      <form action="./list" method="get" class="row g-3">
         <div class="row justify-content-center mx-auto">
            <div class="col-auto">
               <label for="kind" class="visually-hidden">Email</label>
               <select class="form-select" name="kind" id="kind" aria-label="Default select example">
                  <option value="title">상품명</option>
                  <option value="contents">상품 내용</option>
               </select>
            </div>
            <div class="col-auto">
               <label for="search" class="visually-hidden">Search</label>
               <input type="text" class="form-control" name="search" id="search" placeholder="검색어를 입력하세요.">
            </div>
            <div class="col-auto">
               <button type="submit" class="btn btn-outline-primary mb-3">검색</button>
            </div>
         </div>
      </form>
	
	
	<div class="row col-md-7 mx-auto">
	<!-- 7칸 내에 12칸을 다시 차지 -> 거기서 7칸 -->
		<a href="./add" class="btn btn-primary col-2">상품등록</a><br>
	</div>
</div>	
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>