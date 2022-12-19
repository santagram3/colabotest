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
			<div class="container-md">
			<div class="container w-80 mt-5 mx-auto">
			<p><span class=" badge bg-primary rounded-pill fl">지원기간</span> ${cp.cDate} ~ ${cp.cDueDate}</p>
   			<span class="d-flex badge fl text-body">
   			<p class="fs-1 d-flex mb-2">${cp.cTitle}</p> 
   			<p class="fs-4 ms-auto p-2">${cp.cWriter}</p></span>
  			<hr>
    		<div class="card w-80 mx-auto shadow-sm p-3 mb-5 bg-body rounded">
	        <img class="card-img-top" src="/jobPosting/img/${cpi.companyImg}" alt="공고 이미지 자리"> 
	    	<div class="card-body">
	    	<p class="card-text">${cp.cContent}</p>
			<div class="Dday">


			<hr>
			<p>근무지: ${cp.cAddress}</p>
			</div>
	    </div>
    </div>


    <a href="/jobposting/list" class="btn btn-primary">돌아가기</a> 
    <a href="/jobposting/modifyForm/${cp.cno}" class="btn btn-primary">수정하기</a>
    <a href="/jobposting/delete/${cp.cno}" class="btn btn-primary">삭제하기</a>

    </div>
			

			</div>
			
			<div class="container-md2">
			</div>
			<hr>
			
		</div>
	</div>



	



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>