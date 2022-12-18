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
	    	<img class="card-img-top" src="${cpi.companyImg}" alt="공고 이미지 자리"> 
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