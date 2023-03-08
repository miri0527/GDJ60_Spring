<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<!--게시판 만들기  -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
    
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid my-5">
   <div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
     <p class="fs-2" style="font-family: 'Impact'">${boardName} Update Page</p>
   </div>
   
   <form action="./update" method = "post" enctype="multipart/form-data">
      <div class="row col-md-4 mx-auto my-5">
      
      	<input type="hidden" name="num" value="${dto.num}"> 
      	
         <div class="fw-bold fs-5 col-12">
            <p>제목</p>
            <input type="text" name="title" class="form-control" id="exampleFormControlInput1" value="${dto.title }"><br>
         </div>
         <div class="fw-bold fs-5 col-12">
            <p>내용</lp>
            <textarea name="contents" class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="내용 입력" >"${dto.contents }"</textarea><br>
         </div>
         
	         <div class="fw-bold fs-5 col-12">
	            <p>작성자</p>
	            <input type="text" name="writer" class="form-control" value = "${dto.writer}" readonly="readonly" id="exampleFormControlInput1"><br>
	         </div>   
   

         <div id = "fileList">
            <button type="button" class = "btn btn-primary" id="addBtn">ADD</button>

            <c:forEach items="${dto.boardFileDTOs}" var="fileDTO">
               <div class="fw-bold fs-5 col-12 mt-3">
                	<div class="input-group mb-3 my-3">
					  <div class="input-group-text">
					    <input class="form-check-input mt-0 deleteCheck" type="checkbox" value="${fileDTO.fileNum}" name="fileNum" aria-label="Checkbox for following text input">
					  </div>
					  <input type="text" disabled value="${fileDTO.oriName}" class="form-control" aria-label="Text input with checkbox">
					</div>
               </div> 
            </c:forEach>   
         </div>           
        
         <div class="row justify-content-center my-5">
            <button type="submit" class="btn btn-outline-warning col-2">전송</button>
         </div>
      </div>
   </form>

 
</div>
<script src="../resources/js/fileManager.js"></script>
<script>
   
   setMax(5)
   setCount(${dto.boardFileDTOs.size()})

   setParam('addFiles');
   $("#exampleFormControlTextarea1").summernote()
</script>
<c:import url="../template/common_js.jsp"></c:import>

</body>
  
</html>