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
    
<!--                 구인공고    jobPostingView               -->
		
	<div id="contentsBox">
		<div class="position">
			<!-- <img src="/resources/jobPosting/img/cowork.png" class="img-fluid" alt="...">  -->
			<div class="container-md d-flex ">
			<div class="container w-100 mt-5 mx-auto border border-5">
   			<span class="d-flex badge fl text-body">
   			<p class="fs-1 d-flex mb-2"><br>${cp.cTitle}</p> 
   			<p class="fs-4 ms-auto p-2"><br><br>${cp.cWriter}</p></span>
			<p>　<span class="badge bg-primary rounded-pill fl"> 지원기간</span> ${cp.cDate} ~ ${cp.cDueDate}</p>
   			
  			<hr>
  			<div class="d-flex flex-row justify-content-around flex-wrap">
    		<div class="card w-100 mx-auto shadow-sm p-3  bg-body rounded">

	        <img class="card-img-top" src="/resources/jobPosting/img/${cpi.companyImg}" alt="공고 이미지 자리"> 
	    	<div class="card-body">
	    	<p class="card-text fs-5">${cp.cContent}</p>
			<hr>
			<p><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M14.763.075A.5.5 0 0 1 15 .5v15a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5V14h-1v1.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V10a.5.5 0 0 1 .342-.474L6 7.64V4.5a.5.5 0 0 1 .276-.447l8-4a.5.5 0 0 1 .487.022zM6 8.694 1 10.36V15h5V8.694zM7 15h2v-1.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5V15h2V1.309l-7 3.5V15z"/>
  <path d="M2 11h1v1H2v-1zm2 0h1v1H4v-1zm-2 2h1v1H2v-1zm2 0h1v1H4v-1zm4-4h1v1H8V9zm2 0h1v1h-1V9zm-2 2h1v1H8v-1zm2 0h1v1h-1v-1zm2-2h1v1h-1V9zm0 2h1v1h-1v-1zM8 7h1v1H8V7zm2 0h1v1h-1V7zm2 0h1v1h-1V7zM8 5h1v1H8V5zm2 0h1v1h-1V5zm2 0h1v1h-1V5zm0-2h1v1h-1V3z"/>
</svg> 근무지: ${cp.cAddress}</p>
			</div>
	    </div>
    </div>
    
 <div class="d-flex mb-3">
  <div class="p-2"> <a href="/jobposting/modifyForm/${cp.cno}" class="btn btn-primary btn-sm">수정하기</a></div>
  <div class="p-2"> <a href="/jobposting/delete/${cp.cno}" class="btn btn-primary btn-sm">삭제하기</a> </div>
  <div class="ms-auto p-2"><a href="/jobposting/list" class="btn btn-outline-primary btn-sm">돌아가기 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-reply-fill" viewBox="0 0 16 16">
  <path d="M5.921 11.9 1.353 8.62a.719.719 0 0 1 0-1.238L5.921 4.1A.716.716 0 0 1 7 4.719V6c1.5 0 6 0 7 8-2.5-4.5-7-4-7-4v1.281c0 .56-.606.898-1.079.62z"/>
</svg> </a></div>
</div>
 
   
    </div>
    
</div>
			</div>
			
			<div class="container-md2">
			</div>
			<hr>
			
		</div>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>