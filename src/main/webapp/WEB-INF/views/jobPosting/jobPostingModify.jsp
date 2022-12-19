<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/resources/jobPosting/jobPostingList.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>


<body>

<header>
<%@ include file ="../header/header.jsp" %>
</header>    
    
<!-- 구인공고 게시글 작성폼  -->

<img src="/resources/jobPosting/img/modify2.png" class="img-fluid" alt="...">
	<div class="shadow p-3 mb-5 bg-body rounded card border-primary position-absolute top-100 start-50 translate-middle " style="width:800px;">
		<form action="modify/${cp.cno}" method="post" enctype="multipart/form-data">

		
		<div class="p-3 bg-primary bg-opacity-10 rounded-end fw-bold">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
  		<path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
		</svg> 구인공고 수정 페이지
		</div>
		<div class="card-body">
		 
	 	<div id = "boardForm">
				<div class="mb-4">
  				<label class="form-label">제목</label>
  				<input type="text" class="form-control" name="cTitle" value="${cp.cTitle}">
				</div>
				
				<div class="mb-4">
  				<label class="form-label">작성자</label>
  				<input type="text" class="form-control" name="cWriter" value="${cp.cWriter}">
				</div>
				
				<div class="mb-4">
  				<label class="form-label">주소</label>
  				<input type="text" class="form-control" name="cAddress" value="${cp.cAddress}">
				</div>
				
				<div class="mb-4">
  				<label class="form-label">마감일</label>
  				<input type="date" class="form-control" name="cDueDate" value="${cp.cDueDate}">
				</div>
				
				
				<div class="mb-4">
  				<label class="form-label">공고 이미지</label>
  				<input type="file" class="form-control" name="newfile">
				</div>

				<div class="mb-4">
  				<label class="form-label">내용</label>
  				<textarea class="form-control" name="cContent">${cp.cContent}</textarea>
				</div>
						
				<button type="submit" class="btn btn-success mt-3 col-md-6 offset-md-3">
				작성완료</button>

				</div>
				
				</div>
				</form>
				
				<br>
				
				</div>
				</div>


   



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>