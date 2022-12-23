<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- w3school -->
      <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
      <!-- 제이 쿼리 -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <!-- css 링크 -->
      <link rel="stylesheet" href="/resources/mypage/mypageInfo.css">
      <!-- 부트 스트랩 -->
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
      <!-- 부트스트랩 자바스크립트 !-->
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
      </script>
    <title>info</title>
</head>

<body>     
 <div class="infoContainer">
    
        <Header>
            <%-- <%@ include file="/WEB-INF/views/header/myPageHeader.jsp" %> --%>
        </Header>
        
 <div class="container">	        
<div class="p-3 mb-2 bg-light text-dark" >
  <div class="toast-header">
    <a href="/main/page"><img src="/resources/header/img/logo.png" class="rounded me-2 mb-2" width="300px"></a>
    <strong class="me-auto fs-2 mt-4">기업회원 마이페이지 <p class="fs-4">계정의 모든 사항을 한눈에 관리하세요.</p></strong>
    <small>
    <a href="/mypage/info" style="color: #5E5E5E;">워커스 회원정보 수정하기</a><br> 
    <a href="#" style="color: #5E5E5E;">작성한 글 보기</a>
    </small>
  </div>
<div class="toast-body bg-white">
  <p class="fs-5 fw-bold mt-2">작성한 글 목록</p>
  <hr>
 	<!-- 내가 작성한 글 목록 불러오기 -->    
	<div class="d-flex justify-content-between flex-wrap">
		<c:forEach var="list" items="${CompanyMyPageDTOs}" varStatus="i">              
			<div class="card mb-3 shadow-sm" style="width: 20rem;">
 				<img src="/img/jobPosting/${list.getCompanyImg()}" height="300px" class="card-img-top p-4" alt="...">
  				<div class="card-body">
   		 		<h5 class="card-title">${list.getCTitle()}</h5>
    			<p class="card-text">
    			
    			
    			마감일 : <fmt:formatDate value="${list.getCDueDate()}" pattern="yyyy-MM-dd"/>
   	 			</p>
    			<div class="d-flex justify-content-end">
    			<a href="해당 게시물 링크 걸기" class="btn btn-light">게시글 보기</a>
    			</div>
  				</div>
			</div>
		</c:forEach>
	</div>
</body>

</html>