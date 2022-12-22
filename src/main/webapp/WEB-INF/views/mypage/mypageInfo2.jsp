<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <a href="/test/header"><img src="/resources/header/img/logo.png" class="rounded me-2 mb-2" width="300px"></a>
    <strong class="me-auto fs-2 mt-4">마이페이지 <p class="fs-4">${loginUserInfo.nickName} 님 계정의 모든 사항을 한눈에 관리하세요.</p></strong>
    <small>워커스 회원정보 수정하기</small>
  </div>
  <div class="toast-body bg-white">
              <h3>내가 쓴 글</h3>
              
              <c:forEach var="list" items="${MyPageDTOs}" varStatus="i">
              <li><%-- <img class="card-img-top" src="/img/boast/${dto.bImage}"> --%>
			<%-- <c:forEach var="list2" items="${list}">
              제목: ${list.bTitle},좋아요 갯수: ${list.bStar}, 댓글 수: ${list.replyCount}
			</c:forEach> --%>
			 ${list.getbTitle()}
			 <img class="card-img-top" src="/img/boast/${list.getbImage()}">
			 좋아요 수 :${list.getbStar()}
			 댓글 수: ${list.getReplyCount()}
              </c:forEach>
              
              
              
 		 </div>
		</div>
        </div>
    </div>
</body>

</html>