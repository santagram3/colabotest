<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
	crossorigin="anonymous"></script>
<title>공부 자랑하기</title>
</head>
<header>
<%@ include file ="../header/header.jsp" %>
</header>
<body>
<img src="/resources/jobPosting/background/add.png" class="img-fluid" alt="...">
	<div class="shadow p-3 mb-5 bg-body rounded card border-primary position-absolute top-100 start-50 translate-middle " style="width:800px;">
		<div class="p-3 bg-primary bg-opacity-10 rounded-end fw-bold">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
  		<path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
		</svg> 구인공고 수정 페이지
		</div>
		<div class="card-body">
	 	<div id = "boardForm">
	<form method="post" action="/boast/modify/${boast.bNoSP}" enctype="multipart/form-data">
		<input type="hidden" name="bNoSP"class="form-control" value=${boast.bNoSP} > 
		<label class="form-label">제목</label>
		<input type="text" name="bTitle"class="form-control" value=${boast.bTitle} required="required"> 
		<label class="form-label">작성자</label>
		<input type="text" name="bWriter"class="form-control" value=${boast.bWriter} required="required"> 
		<label class="form-label">이미지</label>
		<input type="file" name="newfile" class="form-control">
		<label class="form-label">글내용</label>
		<textarea cols="50" rows="5" name="bContent" class="form-control" required="required">${boast.bContent}</textarea>
		<button type="submit" class="btn btn-success mt-3">수정하기</button>
	</form>
				</div>
				</div>
				<br>
				</div>
</body>
</html>