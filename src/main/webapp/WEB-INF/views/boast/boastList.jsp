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
   <div class="container w-75 mt-5 mx-auto">
    <h2>자랑글 목록</h2>
 <hr>
    <ul class="list-group">
		<c:forEach var="boast" items="${boastlist}" varStatus="status">
		  <li class="list-group-item list-group-item-action d-flex justify-content-between align-items-center"><a href="view/${boast.bNoSP}" class="text-decoration-none">[${status.count}] ${boast.bTitle}, ${boast.bDate}</a>
		  <a href="delete/${boast.bNoSP}"><span class="badge bg-secondary btn-sm">&times;</span></a>
		  </li>
		</c:forEach>
	</ul>
	<hr>

		<a href="/boast/addForm" type="button" class="btn btn-primary sticky-bottom">작성하기</a>
	</div>
</body>
</html>
