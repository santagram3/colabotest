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
    <link rel="stylesheet" href="/resources/jobPosting/jobPostingModify.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    
<!-- 구인공고 게시글 작성폼  -->


	<div class="card border-danger" mb-3" style="max-width: 60rem;">
		<form action="/jobs/add/${jobs.cno}" method="post" enctype="multipart/form-data">

		
		<div class="p-3 bg-danger bg-opacity-10 rounded-end">
		구인공고 작성 페이지
		</div>
		<div class="card-body">
		 
	 	<div id = "boardForm">
				<div class="mb-4">
  				<label class="form-label">제목</label>
  				<input type="text" class="form-control" id="" placeholder="[워커스물산] 2022 하반기 각 부문 신입 및 경력 채용">
				</div>
				
				<div class="mb-4">
  				<label class="form-label">작성자</label>
  				<input type="text" class="form-control" id="" placeholder="김대리">
				</div>
				
				<div class="mb-4">
  				<label class="form-label">주소</label>
  				<input type="text" class="form-control" id="" placeholder="서울특별시 관악구 00동 00건물 00호">
				</div>
				
				<div class="mb-4">
  				<label class="form-label">마감일</label>
  				<input type="date" class="form-control" id="">
				</div>
				
				<div class="mb-4">
  				<label class="form-label">공고 이미지</label>
  				<input type="file" class="form-control" id="">
				</div>

				<div class="mb-4">
  				<label class="form-label">내용</label>
  				<textarea class="form-control" id=""></textarea>
				</div>
						
				<button type="submit" class="btn btn-danger mt-3 col-md-6 offset-md-3">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clipboard2-check" viewBox="0 0 16 16">
 				 <path d="M9.5 0a.5.5 0 0 1 .5.5.5.5 0 0 0 .5.5.5.5 0 0 1 .5.5V2a.5.5 0 0 1-.5.5h-5A.5.5 0 0 1 5 2v-.5a.5.5 0 0 1 .5-.5.5.5 0 0 0 .5-.5.5.5 0 0 1 .5-.5h3Z"/>
 				 <path d="M3 2.5a.5.5 0 0 1 .5-.5H4a.5.5 0 0 0 0-1h-.5A1.5 1.5 0 0 0 2 2.5v12A1.5 1.5 0 0 0 3.5 16h9a1.5 1.5 0 0 0 1.5-1.5v-12A1.5 1.5 0 0 0 12.5 1H12a.5.5 0 0 0 0 1h.5a.5.5 0 0 1 .5.5v12a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5v-12Z"/>
 				 <path d="M10.854 7.854a.5.5 0 0 0-.708-.708L7.5 9.793 6.354 8.646a.5.5 0 1 0-.708.708l1.5 1.5a.5.5 0 0 0 .708 0l3-3Z"/>
				</svg>
				작성완료</button>

				</div>
				
				</div>
				</form>
				</div>


   



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>