<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>뉴스 관리 앱</title>
</head>
<body>
	<form method="post" action="/news/modify/${news.aid}" enctype="multipart/form-data">
		<input type="hidden" name="aid"class="form-control" value=${news.aid} > 
		<label class="form-label">제목</label>
		<input type="text" name="title"class="form-control" value=${news.title} required="required"> 
		<img alt="" src="${news.img}">
		<label class="form-label">이미지</label>
		<input type="file" name="file" class="form-control">
		<label class="form-label">기사내용</label>
		<textarea cols="50" rows="5" name="content" class="form-control" required="required">${news.content}</textarea>
		<button type="submit" class="btn btn-success mt-3">수정하기</button>
	</form>

</body>
</html>