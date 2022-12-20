<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<title>공부 자랑하기</title>
</head>
<header>
<%@ include file ="../header/header.jsp" %>
</header>
   <body>
   <div class="container w-75 mt-5 mx-auto">
    <h2>글 번호 : ${boast.bNoSP}</h2>
    <h2>글 제목 : ${boast.bTitle}</h2>

    <hr>
    <div class="card w-75 mx-auto">
	    <div class="card-body">
	    	<h4 class="card-title">Date: ${boast.bDate}</h4>
	    	<img class="card-img-top" src="/img/boast/${bi.bImage}" alt="공부자랑 이미지 자리">
	    	<p class="card-text">Content: ${boast.bContent}</p>
	    </div>
    </div>
    <hr>
        <ul class="list-group">
		<c:forEach var="comments" items="${commentlist}" varStatus="status">
		  <li><a>[${status.count}] 닉네임: ${comments.nickname}	작성·수정일자: ${comments.commentDate}
		   <br>내용: ${comments.commentContent} </a>
	<!-- 댓글 수정하기 collapse -->
		   <button class="btn-update" type="button" 
	        data-bs-toggle="collapse" 
	        data-bs-target="#addForm${comments.commentAid}" 
	        aria-expanded="false" 
	        aria-controls="addForm${comments.commentAid}">수정하기</button>
	<div class="collapse" id="addForm${comments.commentAid}">
	  <div class="card card-body">
		<form method="post" 
		      action="modcomment/${comments.commentAid}" >
		     <label class="form-label">닉네임</label>
			<input type="text" name="nickname" class="form-control" value='${comments.nickname}' readonly="readonly">	
			<textarea cols="50" rows="5" name="commentContent" class="form-control">${comments.commentContent}</textarea>
			<button type="submit" class="btn btn-success mt-3">등록</button>
		</form>
	  </div>
	</div>
		  <a href="deleteComment/${comments.commentAid}"><span class="badge bg-secondary">&times;</span></a>
		  </li>
		</c:forEach> 
	</ul>
    
        <button class="btn btn-outline-info mb-3" type="button" 
	        data-bs-toggle="collapse" 
	        data-bs-target="#addForm" 
	        aria-expanded="false" 
	        aria-controls="addForm">댓글 쓰기</button>
	<div class="collapse" id="addForm">
	  <div class="card card-body">
		<form method="post" 
		      action="/boast/addcomment/${boast.bNoSP}" >
		     <label class="form-label">닉네임</label>
			<input type="text" name="nickname" class="form-control">	
			<textarea cols="50" rows="5" name="commentContent" class="form-control"></textarea>
			<button type="submit" class="btn btn-success mt-3">등록</button>
		</form>
	  </div>
	</div>
    
    <hr>
    <a href="/boast/list" class="btn btn-primary"> Back</a>
    <a href="/boast/modifyForm/${boast.bNoSP}" class="btn btn-primary">수정하기</a>
    
    </div>
    </body>
</html>