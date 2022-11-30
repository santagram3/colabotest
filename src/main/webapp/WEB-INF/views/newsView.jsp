<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<style>
btn-update {
    position: absolute;
    top: 0.65rem;
    right: 0.65rem;
    z-index: 10;
    display: block;
    padding: 0.25rem 0.5rem;
    font-size: .65em;
    color: #0d6efd;
    background-color: #fff;
    border: 1px solid;
    border-radius: 0.25rem;
}
</style>
<title>뉴스 관리 앱</title>
</head>

   <body>
   
   
   <div class="container w-75 mt-5 mx-auto">
    <h2>${news.title}</h2>
    <hr>
    <div class="card w-75 mx-auto">
	    <img class="card-img-top" src="${news.img}"> 
	    <div class="card-body">
	    	<h4 class="card-title">Date: ${news.regDate}</h4>
	    	<p class="card-text">Content: ${news.content}</p>
	    </div>
    </div>
    
    <h3>댓글</h3>
    
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
		      action="/news/updateComment/${comments.commentAid}" >
		     <label class="form-label">닉네임</label>
			<input type="text" name="nickname" class="form-control" value='${comments.nickname}' readonly="readonly">	
			<textarea cols="50" rows="5" name="commentContent" class="form-control"></textarea>
			<button type="submit" class="btn btn-success mt-3">등록</button>
		</form>
	  </div>
	</div>
		  <a href="deleteComment/${comments.commentAid}"><span class="badge bg-secondary">&times;</span></a>
		  </li>
		</c:forEach> 
	</ul>
	<hr>
    <!-- 댓글 쓰기 collapse -->
    <button class="btn btn-outline-info mb-3" type="button" 
	        data-bs-toggle="collapse" 
	        data-bs-target="#addForm" 
	        aria-expanded="false" 
	        aria-controls="addForm">댓글 쓰기</button>
	<div class="collapse" id="addForm">
	  <div class="card card-body">
		<form method="post" 
		      action="/news/addcomment/${news.aid}" >
		     <label class="form-label">닉네임</label>
			<input type="text" name="nickname" class="form-control">	
			<textarea cols="50" rows="5" name="commentContent" class="form-control"></textarea>
			<button type="submit" class="btn btn-success mt-3">등록</button>
		</form>
	  </div>
	</div>
	
    <hr>
    
    <!-- <a href="javascript:history.back()" class="btn btn-primary"><< Back</a> -->
    <a href="/news/list" class="btn btn-primary"><< Back</a>
    <a href="/news/update/${news.aid}" class="btn btn-primary">수정하기</a>
    </div>
    </body>
</html>