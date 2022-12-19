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
	    	<img class="card-img-top" src="/boast/img/${bi.bImage}" alt="공부자랑 이미지 자리">
	    	<p class="card-text">Content: ${boast.bContent}</p>
	    </div>
    </div>
    <hr>
    <a href="/boast/list" class="btn btn-primary"> Back</a>
    <a href="/boast/modifyForm/${boast.bNoSP}" class="btn btn-primary">수정하기</a>
    
    </div>
    </body>
</html>