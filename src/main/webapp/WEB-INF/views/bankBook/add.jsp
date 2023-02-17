<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid my-5">
   <div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
     <p class="fs-2" style="font-family: 'Impact'">Bankbook Add Page</p>
   </div>
   <form action="./add" method = "post" enctype="multipart/form-data">
      <div class="row col-md-4 mx-auto my-5">
         <div class="fw-bold fs-5 col-12">
            <p>이름</p>
            <input type="text" name="bookName" class="form-control" id="exampleFormControlInput1" placeholder="상품명 입력"><br>
         </div>
         <div class="fw-bold fs-5 col-12">
            <p>상세 정보</lp>
            <textarea name="bookDetail" class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="상세 정보 입력"></textarea><br>
         </div>
         <div class="fw-bold fs-5 col-12">
            <p>이자율</p>
            <input type="text" name="bookRate" class="form-control" id="exampleFormControlInput1" placeholder="이자율 입력"><br>
         </div>         
         <div class="form-check form-switch justify-content-center">
            <input class="form-check-input" name="bookSale" type="checkbox" role="switch" id="flexSwitchCheckDefault">
            <label class="form-check-label" for="flexSwitchCheckDefault">판매 여부</label>
         </div>         
         <div class="fw-bold fs-5 col-12 mt-3">
            <label for="files" class="form-label">Image</label>
            <input type="file" class="form-control" id="files" name="pic">
         </div>         
         
<!--          <fieldset class="mb-4">
            <legend class="fw-bold fs-5">판매 여부</legend>
            <div class="form-check form-check-inline">
               <label for="bs1" class="form-check-label" id="inlineRadio1">판매</label>
               <input id="bs1" type="radio" name="bookSale" value="1" checked class="form-check-input" for="inlineRadio1">
            </div>
            <div class="form-check form-check-inline">
               <label for="bs2" class="form-check-label" id="inlineRadio2">판매 중지</label>
               <input id="bs2" type="radio" name="bookSale" value="0" class="form-check-input" for="inlineRadio2">
            </div>
         </fieldset> -->
<!--       <fieldset>
            <legend class="fw-bold fs-5">판매 여부</legend>
               <select name="bookSale" class="form-select" aria-label="Default select example">
                 <option selected>판매 여부</option>
                 <option value="1">판매</option>
                 <option value="2">판매 중지</option>
               </select>
         </fieldset> -->
         <div class="row justify-content-center my-5">
            <button type="submit" class="btn btn-outline-warning col-2">전송</button>
         </div>
      </div>
   </form>
</div>
</body>
   <c:import url="../template/common_js.jsp"></c:import>
</html>