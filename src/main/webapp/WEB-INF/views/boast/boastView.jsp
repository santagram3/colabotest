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
    <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-quote" viewBox="0 0 16 16">
  	<path d="M12 12a1 1 0 0 0 1-1V8.558a1 1 0 0 0-1-1h-1.388c0-.351.021-.703.062-1.054.062-.372.166-.703.31-.992.145-.29.331-.517.559-.683.227-.186.516-.279.868-.279V3c-.579 0-1.085.124-1.52.372a3.322 3.322 0 0 0-1.085.992 4.92 4.92 0 0 0-.62 1.458A7.712 7.712 0 0 0 9 7.558V11a1 1 0 0 0 1 1h2Zm-6 0a1 1 0 0 0 1-1V8.558a1 1 0 0 0-1-1H4.612c0-.351.021-.703.062-1.054.062-.372.166-.703.31-.992.145-.29.331-.517.559-.683.227-.186.516-.279.868-.279V3c-.579 0-1.085.124-1.52.372a3.322 3.322 0 0 0-1.085.992 4.92 4.92 0 0 0-.62 1.458A7.712 7.712 0 0 0 3 7.558V11a1 1 0 0 0 1 1h2Z"/>
	</svg>
   	<p class="fs-2 text-dark fw-normal mb-1">${boast.bTitle}</p>
   	<p>${boast.bDate}</p>
    <hr>
    <div class="card w-75 mx-auto">
	    <div class="card-body">
	    	<img class="card-img-top" src="/img/boast/${bi.bImage}" alt="공부자랑 이미지 자리">
	    	<p class="card-text mt-5">${boast.bContent}</p>
	    	<div class="d-flex justify-content-center">
	    	<button type="button" class="btn btn-outline-primary" onclick="location='/boast/like/${boast.bNoSP}';">
   			<img src="/resources/boast/like.png" width="30px"><br>
   			좋아요 : ${likeCount}</button></div>  			
	    </div>
    </div>
    <hr>
        <ul class="list-group mb-3 p-1">
		<c:forEach var="comments" items="${commentlist}" varStatus="status">
		  <li><p class="fs-8 text-muted"><span class="fw-bold fs-6 text-dark">${comments.nickname}</span> 　 ${comments.commentDate}
		   	<button class="btn btn-light btn-sm m-3" type="button" 
	        data-bs-toggle="collapse" 
	        data-bs-target="#addForm${comments.commentAid}" 
	        aria-expanded="false" 
	        aria-controls="addForm${comments.commentAid}">수정</button>
	        <a href="deleteComment/${comments.commentAid}"><span class="text-muted"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3-fill" viewBox="0 0 16 16">
  			<path d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z"/>
			</svg></span></a>
	        <br>
	        <span class="text-dark fs-7">${comments.commentContent}</span>
		  </p>		   
	<!-- 댓글 수정하기 collapse -->
	<div class="collapse" id="addForm${comments.commentAid}">
	  <div class="card card-body">
		<form method="post" 
		      action="modcomment/${comments.commentAid}" >
			<input type="text" name="nickname" class="form-control" value='${comments.nickname}' readonly="readonly">	
			<textarea cols="50" rows="5" name="commentContent" class="form-control">${comments.commentContent}</textarea>
			<div class="d-flex flex-row-reverse">
			<button type="submit" class="btn btn-secondary mt-3">수정하기</button>
			</div>
		</form>
	  </div>
	</div>
		  </li>
		</c:forEach> 
	</ul>
 <!-- 댓글 작성 -->   
	  <div class="card card-body">
		<form method="post" 
		      action="/boast/addcomment/${boast.bNoSP}" >
			<input type="text" name="nickname" class="form-control" placeholder="닉네임">	
			<textarea cols="50" rows="5" name="commentContent" class="form-control" placeholder="댓글을 입력해주세요"></textarea>
			<div class="d-flex flex-row-reverse">
			<button type="submit" class="btn btn-secondary mt-3 ">등록하기</button>
			</div>
		</form>
	  </div>
    <hr>
    <a href="/boast/list" class="btn btn-primary"> Back</a>
    <a href="/boast/modifyForm/${boast.bNoSP}" class="btn btn-primary">수정하기</a>
    </div>  
    </body>
</html>