<!-- 12/18 구인공고 리스트 플렉스넣음 -->

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
    
    
    
<!-- 구인공고 jobPostList -->
	<div class="container">
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
						
			<div class="JobHostBoard">		
			<h2 style="margin-top: 30px;">구인공고 게시판</h2>
			<div class="JobCategoryButton">
			</div>
			<hr>
			<p style="color: #F15F5F;" class="fw-bold fs-5">핫한 구인공고 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chat-heart" viewBox="0 0 16 16">
  			<path fill-rule="evenodd" d="M2.965 12.695a1 1 0 0 0-.287-.801C1.618 10.83 1 9.468 1 8c0-3.192 3.004-6 7-6s7 2.808 7 6c0 3.193-3.004 6-7 6a8.06 8.06 0 0 1-2.088-.272 1 1 0 0 0-.711.074c-.387.196-1.24.57-2.634.893a10.97 10.97 0 0 0 .398-2Zm-.8 3.108.02-.004c1.83-.363 2.948-.842 3.468-1.105A9.06 9.06 0 0 0 8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6a10.437 10.437 0 0 1-.524 2.318l-.003.011a10.722 10.722 0 0 1-.244.637c-.079.186.074.394.273.362a21.673 21.673 0 0 0 .693-.125ZM8 5.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132Z"/>
			</svg></p></br>
			<ol class="list-group"> <div class="d-flex flex-row justify-content-around flex-wrap">
					<c:forEach var="jp" items="${jobpostinglist}" varStatus="status">
					  <li class="list-unstyled list-group-item shadow p-3 mb-5 bg-body rounded" style="width:300px;">
					    <div class="ms-4 me-auto">
					      <a href = "view/${jp.cno}" class="fw-bold fs-5" style="color: black;"> ${status.count}　　　${jp.cTitle}<br>　　　　  <p style="color:gray;" class="fs-6"> ${jp.cWriter} </p></a>
					      <P style="color:gray;"><span class="badge bg-primary rounded-pill">　지원기간  |　 ${jp.cDueDate} 까지   　 </span></P>
						  <a href="delete/${jp.cno}"><span class="badge bg-secondary btn-sm">&times;</span></a>
					    </div>
					  </li>
					  </c:forEach>
					 </ol>
					</div>
			</div>	




		 
<hr>
<br><br>			

<div class="container">
<!-- 게시판 형태 -->		 
<table class="table caption-top border border-light">
  <p class="fw-bold fs-5">최근 올라온 구인공고</p>
  <thead>
    <tr class="fw-bold">
      <th scope="col"></th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">공고 작성일 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-vector-pen" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M10.646.646a.5.5 0 0 1 .708 0l4 4a.5.5 0 0 1 0 .708l-1.902 1.902-.829 3.313a1.5 1.5 0 0 1-1.024 1.073L1.254 14.746 4.358 4.4A1.5 1.5 0 0 1 5.43 3.377l3.313-.828L10.646.646zm-1.8 2.908-3.173.793a.5.5 0 0 0-.358.342l-2.57 8.565 8.567-2.57a.5.5 0 0 0 .34-.357l.794-3.174-3.6-3.6z"/>
  <path fill-rule="evenodd" d="M2.832 13.228 8 9a1 1 0 1 0-1-1l-4.228 5.168-.026.086.086-.026z"/>
</svg></th>
      <th scope="col">공고 마감일 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-stopwatch" viewBox="0 0 16 16">
  <path d="M8.5 5.6a.5.5 0 1 0-1 0v2.9h-3a.5.5 0 0 0 0 1H8a.5.5 0 0 0 .5-.5V5.6z"/>
  <path d="M6.5 1A.5.5 0 0 1 7 .5h2a.5.5 0 0 1 0 1v.57c1.36.196 2.594.78 3.584 1.64a.715.715 0 0 1 .012-.013l.354-.354-.354-.353a.5.5 0 0 1 .707-.708l1.414 1.415a.5.5 0 1 1-.707.707l-.353-.354-.354.354a.512.512 0 0 1-.013.012A7 7 0 1 1 7 2.071V1.5a.5.5 0 0 1-.5-.5zM8 3a6 6 0 1 0 .001 12A6 6 0 0 0 8 3z"/>
</svg></th>
    </tr>
  </thead>
  <c:forEach var="jp" items="${jobpostinglist}" varStatus="status">
  <tbody>
    <tr>
      <th scope="row">${status.count}</th>
      <td><a href = "view/${jp.cno}" style="color: black;">${jp.cTitle}</a></td>
      <td>${jp.cWriter}</td>
      <td>${jp.cDate}</td>
      <td>${jp.cDueDate}</td>
    </tr>
    </tbody>
    </c:forEach>
    
 
  </tbody>
</table>
			
	
	<a href="/jobposting/addForm" type="button" class="btn btn-primary sticky-bottom">작성하기</a>
	
</div>
   



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>