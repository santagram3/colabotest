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
<title>공부 자랑하기</title>
</head>
<header>
<%@ include file ="../header/header.jsp" %>
</header>
   <body>
   <div class="container w-75 mt-5 mx-auto  p-10">
   <img src="/resources/boast/boastL2.png">
   	<a href="/boast/addForm" type="button" class="btn btn-dark fw-bold fs-5">공부 자랑하기 <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a>
   </div>
   <div class="container w-75 mt-5 mx-auto">
   <hr>
   <h2 style="margin-top: 30px;"><b>자랑글 목록</b><br></h2>
   
   <ul class="list-group mt-4"> <div class="d-flex flex-row flex-wrap">
   <c:forEach var="boast" items="${boastlist}" varStatus="status">
	<div class="shadow p-1 mb-5 bg-body rounded card border-secondary border-1 mb-3  style="max-width: 18rem;">
  	<div class="card-header">별점 <img src="/resources/boast/star2.png" width="20px"></div>
  	<div class="card-body">
    <a href = "view/${boast.bNoSP}"  class="card-title fw-bold fs-5"> ${boast.bTitle}</a>
    <p class="card-text">${boast.bDate} <a href="delete/${boast.bNoSP}"><span class="badge bg-secondary btn-sm">&times;</span></a></p>
  	</div>
	</div>
	</c:forEach>
	</ul>
   
<hr>
<br><br>			
	
	
	<div class="container">	 
  	<p class="fw-bold fs-5">공부 자랑하기</p>  
    <ul class="list-group mt-4 mb-4">
		<c:forEach var="boast" items="${boastlist}" varStatus="status">
		  <li class="fw-bold fs-5 list-group-item list-group-item-action d-flex justify-content-between align-items-center"><a href="view/${boast.bNoSP}" class="text-decoration-none" style="color: black;">[${status.count}] ${boast.bTitle} |  ${boast.bDate}</a>
		  <a href="delete/${boast.bNoSP}"><span class="badge bg-secondary btn-sm">&times;</span></a>
		  </li>
		</c:forEach>
	</ul>
	</div>

	</div>
</body>
</html>


