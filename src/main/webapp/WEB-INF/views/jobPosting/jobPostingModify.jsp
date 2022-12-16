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
    <link rel="stylesheet" href="/resources/jobPosting/css/jobPostingList.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<!-- 헤더영역 -->
    <div id="headerBox">
        <div class="logo"><a href="index.html"><img src="img/skyblue.png" alt=""></a></div>
        <div class="headerMenu">
            <div class="menuLeft">
                <a href="">Q & A</a>
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
		<div class="card-body">
		<form action="/jobposting/add" method="post">
		<h3>구인공고 작성</h3>
		<hr>
		<div id = "boardForm">
				
				<!-- <div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
				<label class="form-check-label" for="inlineRadio1">신입공채</label>
				</div>
				<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
				<label class="form-check-label" for="inlineRadio2">경력</label>
				</div>
				<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3">
				<label class="form-check-label" for="inlineRadio3">인턴</label>
				</div>-->
				
				<div class="input-group mb-3">
				<span class="input-group-text">제목</span><!-- cTitle  -->
				<input type="text" name="title" class="form-control" value="">
				</div>
				<div class="input-group mb-3">
				<span class="input-group-text">작성자</span> <!-- cWriter -->
				<input type="text" name="writer" class="form-control" value="">
				</div>
				<div class="input-group mb-3">
				<span class="input-group-text">마감일</span>  <!-- cDueDate -->
				<input type="date" name="dueDate" class="form-control" value="">
				</div>
				<div class="mb-3"> 
 				<label for="formFile" class="form-label">Default file input example</label> <!-- companyImg -->
				<input class="form-control" type="file" id="formFile">
				<br>
				<div class="mb-3">
 				<label for="exampleFormControlTextarea1" class="form-label">내용</label><!-- cContent -->
				<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
				</div>
				
				<div class="mb-3">
 				<label for="exampleFormControlTextarea1" class="form-label">주소?</label><!-- cAddress -->
				<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
				</div>
				</div>
				
				</div>
				<div class="my-4">
				<div class="float-end">
				<button type="button" class="btn btn-primary">작성 완료</button>
				</div>
				</div>
				</div>
				</form>
				</div>
	
	
		</div>
	</div>
	

   



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>