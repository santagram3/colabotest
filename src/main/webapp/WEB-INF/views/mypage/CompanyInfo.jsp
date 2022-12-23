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
    <a href="/main/page"><img src="/resources/header/img/logo.png" class="rounded me-2 mb-2" width="300px"></a>
    <strong class="me-auto fs-2 mt-4">기업페이지 <p class="fs-4">${loginCompanyInfo.companyName} 님 계정의 모든 사항을 한눈에 관리하세요.</p></strong>
    <small>워커스 기업정보 수정하기</small>
    <a href="/companymypage/companyinfo2">내가 쓴 글 보기</a>
  </div>
  <div class="toast-body bg-white">
               <form  method="post" action="/companymypage/modifycompanyinfo/${loginCompanyInfo.companyEmail}" enctype="multipart/form-data">
            <div class="profileImg"><img src="" alt=""></div>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">이메일</label>
                <input type="email" class="form-control companyEmail" id="formGroupExampleInput"
                    placeholder="ex: company@naver.com " name="companyEmail" readonly value="${loginCompanyInfo.companyEmail}">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">비밀번호</label>
                <input type="password" class="form-control" id="formGroupExampleInput" placeholder="비밀번호를 입력해주세요."
                    required="required" name="companyPwd">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">기업이름</label>
                <input type="text" class="form-control" id="formGroupExampleInput" value="${loginCompanyInfo.companyName}"
                    required="required" name="companyName">
            </div>
            
                <button type="button" class="btn btn-link mt-3" onclick="backhome()">뒤로 가기</button>
                <button class="btn btn-outline-primary mt-3">수정하기</button>
                </form>
                <button type="button" class="btn btn-secondary loginbutton mt-3" data-bs-toggle="modal" data-bs-target="#staticBackdrop">탈퇴하기</button>
            </div>
                
                
<!-- 탈퇴하겠습니까, 모달 -->
        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static1" data-bs-keyboard="false" tabindex="-1"
        aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <form method="post" action="/companymypage/deletecompanyinfo/${loginCompanyInfo.companyEmail}">
            <div class="modal-dialog">
                <div class="modal-content p-3">
                    <div class="modal-header">
                        <p class="fs-4">탈퇴하시려면 비밀번호를 입력하세요</p>
                    </div>
                        <input type="password" class="form-control" id="formGroupExampleInput" placeholder="write password"
                    required="required" name="companyPwd">
                    <div><br>
                        <button type="submit" class="btn btn-secondary m-1">탈퇴하기</button>
                        <button type="button" class="btn btn-link m-1" data-bs-dismiss="modal">뒤로 가기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
                
                
 		 </div>
		</div>
        </div>
</body>

</html>