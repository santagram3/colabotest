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

<!-- 헤더영역 -->
    <div id="headerBox">
        <div class="logo"><a href="index.html"><img src="/resources/jobPosting/img/skyblue.png" alt=""></a></div>
        <div class="headerMenu">
            <div class="menuLeft">
                <a href="/jobposting/list">구인공고</a>
                <a href="">공부 자랑하기</a>
                <a href="">스터디 구하기</a>
            </div>
            <div class="menuRight">
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                    로그인
                </button>
                   <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop2">
                    회원가입
                </button>
            </div>
        </div>
    </div>

   
    <!-- 로그인 Modal -->
    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static1" data-bs-keyboard="false" tabindex="-1"
        aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <!-- 로그인 폼 태그 -->
        <form action="" method="post">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">로그인 헤더</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <label for="email">email</label>
                        <input type="text" name="email"><br>
                        <label for="password">password</label>
                        <input type="password" name="password">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn bn-secondary" data-bs-dismiss="modal">뒤로 가기</button>
                        <button type="submit" class="btn btn-primary">로그인 하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
        <!-- 회원기입 Modal -->
        <div class="modal fade" id="staticBackdrop2" data-bs-backdrop="static1" data-bs-keyboard="false" tabindex="-1"
        aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <!-- 회원 가입 폼 태그 -->
        <form action="" method="post">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">회원기입 헤더</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <label for="email">
                            email<input type="email" name="email">
                        </label><br>
                        <label for="password">password</label>
                        <input type="password" name="password"><br>
                        <label for="nickName">닉네임</label>
                        <input type="text" name="nickName"><br>
                        <label for="">자기소개</label><br>
                        <textarea name="" id="" cols="30" rows="10"></textarea>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn bn-secondary" data-bs-dismiss="modal">뒤로 가기</button>
                        <button type="submit" class="btn btn-primary">로그인 하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    
    
    
<!-- 구인공고 게시글 작성폼  -->

<img src="/resources/jobPosting/bak/addBackground.png" class="img-fluid">
	<div class="shadow p-3 mb-5 bg-body rounded card border-primary position-absolute top-100 start-50 translate-middle " style="width:800px;">
		<form  method="post" action="/jobposting/add" enctype="multipart/form-data">

		
		<div class="p-3 bg-primary bg-opacity-10 rounded-end fw-bold">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
  		<path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
		</svg> 구인공고 작성 페이지
		</div>
		<div class="card-body">
		 
	 	<div id = "boardForm">
				<div class="mb-4">
  				<label class="form-label">제목</label>
  				<input type="text" class="form-control" name="cTitle">
				</div>
				
				<div class="mb-4">
  				<label class="form-label">작성자</label>
  				<input type="text" class="form-control" name="cWriter">
				</div>
				
				<div class="mb-4">
  				<label class="form-label">주소</label>
  				<input type="text" class="form-control" name="cAddress">
				</div>
				
				<div class="mb-4">
  				<label class="form-label">마감일</label>
  				<input type="date" class="form-control" name="cDueDate">
				</div>
				
				
				<div class="mb-4">
  				<label class="form-label">공고 이미지</label>
  				<input type="file" class="form-control" name="file">
				</div>

				<div class="mb-4">
  				<label class="form-label">내용</label>
  				<textarea class="form-control" name="cContent"></textarea>
				</div>
						
				<button type="submit" class="btn btn-danger mt-3 col-md-6 offset-md-3">
				작성완료</button>

				</div>
				
				</div>
				</form>
				
				<br>
				
				</div>
				

   



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>