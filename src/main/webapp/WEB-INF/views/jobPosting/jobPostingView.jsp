<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>구인공고 상세페이지</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/jobPosting/css/jobPostingView">
</head>

<body>
    
<!--                 구인공고    jobPostingView               -->
	<div id="contentsBox" class="p-3 mb-2 bg-light text-dark" >
		<div class="position">
			<div class="container-md">
			<div class="container w-80 mt-5 mx-auto">
			<!-- 게시글 번호 :  -->
			<H4>구인공고 작성자</H4>
   			<h3>${cp.cTitle}</h3>
  			<hr>
    		<div class="card w-80 mx-auto">
	    	<img class="card-img-top" src="" alt="공고 이미지 자리"> 
	    	<div class="card-body">
	    	<p class="card-text">${cp.cContent}</p>
			<div class="Dday">
			<p class="fw-bold">지원기간</p>
			<p>작성날짜:${cp.cDate} ~ 마감날짜:${cp.cDueDate}</p>
			<button type="button" class="btn btn-danger btn-lg"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-send" viewBox="0 0 16 16">
 			<path d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576 6.636 10.07Zm6.787-8.201L1.591 6.602l4.339 2.76 7.494-7.493Z"/>
			</svg> 지원하기</button> <!-- 찐 채용회사 링크를 걸 수 없으니까 디데이 만들기..-->
			<hr>
			<p>주소: ${cp.cAddress}</p>
			</div>
	    </div>
    </div>
    <hr>

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