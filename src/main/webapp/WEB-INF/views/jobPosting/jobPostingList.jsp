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
						      <img src="./img/slide/img1.png" class="d-block w-100" alt="...">
						    </div>
						    <div class="carousel-item">
						      <img src="./img/slide/img2.png" class="d-block w-100" alt="...">
						    </div>
						    <div class="carousel-item">
						      <img src="./img/slide/img3.png" class="d-block w-100" alt="...">
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
			<div class="JobCategoryButton">
			<!-- 옵션 버튼 1 (기능을 추가한다면...)-->
						<div class="btn-group">
						  <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
						    옵션 1
						  </button>
						  <ul class="dropdown-menu">
						    <li><a class="dropdown-item" href="#">채용중</a></li>
						    <li><a class="dropdown-item" href="#">채용예정</a></li>
						    <li><a class="dropdown-item" href="#">마감</a></li>
						    <!--<li><hr class="dropdown-divider"></li>
						    <li><a class="dropdown-item" href="#">Separated link</a></li>-->
						  </ul>
						</div>
						
			<!-- 옵션 버튼 2 (기능을 추가한다면...)-->
						<div class="btn-group">
						  <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
						    옵션 2
						  </button>
						  <ul class="dropdown-menu">
						    <li><a class="dropdown-item" href="#">신입공채</a></li>
						    <li><a class="dropdown-item" href="#">경력</a></li>
						    <li><a class="dropdown-item" href="#">인턴</a></li>
						    <!--<li><hr class="dropdown-divider"></li>
						    <li><a class="dropdown-item" href="#">Separated link</a></li>-->
						  </ul>
						</div>
			</div>
			<hr>
			
			<!-- 구인공고 리스트 제목/내용에 '작성일 12월12일 ~ 마감일 12월13일' 띄울 것 같아요. 뭘 올리지..?  -->
					<ol class="list-group list-group-numbered">
					<c:forEach var="jp" items="${jobpostinglist}" varStatus="status">
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <a href = "">${status.count}, ${jp.cTitle}, ${jp.cWriter},</a>
					      ${jp.cDate}, ${jp.cDueDate}
					    </div>
					    <span class="badge bg-primary rounded-pill">채용중</span>
					  </li>
					  </c:forEach>
					 </ol>
			
	<!--
		<ul class="list-group">
		<c:forEach var="news" items="${newslist}" varStatus="status">
		<li class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
		<a href="/news/getNews?aid=${news.aid}" class="text-decoration-none">
		 [${status.count}] ${news.title}, ${news.regDate}</a>
		<a href="/news/delete/${news.aid}"><span class="badge bg-secondary">&times;</span></a>
		</li>
		</c:forEach> 
		</ul>
 -->
	
			<!-- 페이지네이션 만들어보기 -->
						<div class="float-end">
						<ul class="pagination flex-wrap">
						<c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
						<li class="page-item"><a class="page-link" href="#">${num}</a></li>
						</c:forEach>
						</ul>
						</div>
	
	
	
		</div>
	</div>
	

   



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>