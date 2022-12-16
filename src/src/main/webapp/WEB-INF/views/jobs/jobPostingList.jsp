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
    <link rel="stylesheet" href="../jobPosting/jobPostingList.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    
<!-- 구인공고 jobPostList -->
	<div id="contentsBox">
		<div class="boardList">
			<!-- 슬라이드쇼 -->
						<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
						  <div class="carousel-indicators">
						    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
						    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
						    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
						  </div>
						  <div class="carousel-inner">
						    <div class="carousel-item active">
						      <img src="/resources/jobPosting/img/slide/img1.png" class="d-block w-100" alt="...">
						    </div>
						    <div class="carousel-item">
						      <img src="/resources/jobPosting/img/slide/img2.png" class="d-block w-100" alt="...">
						    </div>
						    <div class="carousel-item">
						      <img src="/resources/jobPosting/img/slide/img3.png" class="d-block w-100" alt="...">
						    </div>
						  </div>
						  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
						    <span class="visually-hidden">Previous</span>
						  </button>
						  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						    <span class="carousel-control-next-icon" aria-hidden="true"></span>
						    <span class="visually-hidden">Next</span>
						  </button>
						</div>
						
						
				<h3 style="margin-top: 30px;">구인공고 게시판</h3>

			<hr>
					
				<ul class="list-group">

				</ul>
			
			<a href="/jobs/add" type="button" class="btn btn-primary position-absolute bottom-0 end-0">작성하기</a>
	
		</div>
	</div>
	

   



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>