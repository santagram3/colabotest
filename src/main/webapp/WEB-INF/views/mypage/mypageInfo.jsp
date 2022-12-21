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
            <%@ include file="/WEB-INF/views/header/myPageHeader.jsp" %>
        </Header>
        <div class="loginUserInfo">
           
            <div class="profileImg"><img src="" alt=""></div>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">이메일</label>
                <input type="email" class="form-control userEmail" id="formGroupExampleInput"
                    placeholder="ex: mini@naver.com " name="userEmail" readonly value="${loginUserInfo.userEmail}">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">password</label>
                <input type="password" class="form-control" id="formGroupExampleInput" placeholder="password write"
                    required="required" name="userPw">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">nickName</label>
                <input type="text" class="form-control" id="formGroupExampleInput" placeholder="아무거나 막 적어" value="${loginUserInfo.nickName}"
                    required="required" name="nickName">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">생년월일</label>
                <input type="date" class="form-control" id="formGroupExampleInput"
                    placeholder="Example input placeholder" name="birthday" required="required">
            </div>
            <label for="formGroupExampleInput" class="form-label">selfIntroduce</label>
            <textarea class="form-control col-sm-5" rows="5" name="selfIntroduce" required></textarea>
            <div class="buttongroup">
                <button type="button" class="btn btn-success" onclick="backhome()">뒤로 가기</button>
                <button class="btn btn-info submitButton">회원가입하기</button>
            </div>
            <input type="hidden" name="oauth" value="">

        </div>
    </div>
</body>

</html>