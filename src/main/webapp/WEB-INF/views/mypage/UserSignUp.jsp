
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="/resources/mypage/signUp.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="signUpcontainer">
        <div class="slogun"> 이번주 금요일에 뭐해? 취준 안해? 가입해서 자소서나 써 .. ;; </div>
        <div class="signupbox">
            <form action="/mypage/UserSignUp" method="post">
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">이메일</label>
                    <input type="email" class="form-control" id="formGroupExampleInput"
                        placeholder="ex: mini@naver.com " name="userEmail">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">password</label>
                    <input type="password" class="form-control" id="formGroupExampleInput" placeholder="password write"
                        name="userPw">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">nickName</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="아무거나 막 적어"
                        name="nickName">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">생년월일</label>
                    <input type="date" class="form-control" id="formGroupExampleInput"
                        placeholder="Example input placeholder" name="birthday">
                </div>
                <label for="formGroupExampleInput" class="form-label">selfIntroduce</label>
                <textarea class="form-control col-sm-5" rows="5" name="selfIntroduce"></textarea>
                <div class="buttongroup">
                    <button type="button" class="btn btn-success" onclick="backhome()">뒤로 가기</button>
                    <button type="submit" class="btn btn-info">회원가입하기</button>
                </div>
            </form>
        </div>
    </div>
    <script>
        function backhome() {
            console.log("/test/header");
            location.href="/test/header";
        }
    </script>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>