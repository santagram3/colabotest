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
   <p>공부 자랑하기</p>
   	<div class="card mb-3 border border-primary">
  		<div class="row g-0">
    	<div class="col-md-4">
     	 <img src="..." class="img-fluid rounded-start" alt="...">
    	</div>
    <div class="col-md-8">
      <div class="card-body">
        <h2 class="card-title fs-5">${boast.bNoSP}    ${boast.bTitle}</h2>
        <p class="card-text fs-5">Content: ${boast.bContent}</p>
        <p class="card-text fs-"><small class="text-muted">Date: ${boast.bDate}</small></p>
      </div>
    </div>
  </div>
</div>

    <hr>
    <a href="javascript:history.back()" class="btn btn-primary btn-sm"> Back</a>
    <a href="/boast/modify/${boast.bNoSP}" class="btn btn-primary btn-sm">수정하기</a>
    
    </div>
    </body>
</html>