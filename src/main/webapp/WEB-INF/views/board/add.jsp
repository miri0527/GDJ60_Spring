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
     <p class="fs-2" style="font-family: 'Impact'">${boardName} Add Page</p>
   </div>
   
   <form action="./add" method = "post" enctype="multipart/form-data">
      <div class="row col-md-4 mx-auto my-5">
         <div class="fw-bold fs-5 col-12">
            <p>제목</p>
            <input type="text" name="title" class="form-control" id="exampleFormControlInput1"><br>
         </div>
         <div class="fw-bold fs-5 col-12">
            <p>내용</lp>
            <textarea name="contents" class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="내용 입력"></textarea><br>
         </div>
         
	         <div class="fw-bold fs-5 col-12">
	            <p>작성자</p>
	            <input type="text" name="writer" class="form-control" value = "${member.id}" readonly="readonly" id="exampleFormControlInput1"><br>
	         </div>   
   

         <div id = "fileList">
          	<!-- <div class="fw-bold fs-5 col-12 mt-3">
               <label for="files" class="form-label">Image</label>
               <input type="file" class="form-control" id="files" name="files">
               <button type="button" id="delBtn">X</button>
             	
            </div>   -->
            <button type="button" class = "btn btn-primary" id="addBtn">ADD</button>
         </div>           
        
         <div class="row justify-content-center my-5">
            <button type="submit" class="btn btn-outline-warning col-2">전송</button>
         </div>
      </div>
   </form>

 
</div>
<script src="../resources/js/fileManager.js"></script>
<c:import url="../template/common_js.jsp"></c:import>
<script>
   setMax(5)
   $("#exampleFormControlTextarea1").summernote()
   setParam('addFiles');
</script>
</body>
  
</html>