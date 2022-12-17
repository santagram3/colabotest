
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
        <div class="slogun"> 회사 회원 가입 하는 곳! </div>
        <div class="signupbox">
            <form action="주소" method="post">
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">companyEmail</label>
                    <input type="email" class="form-control" id="formGroupExampleInput"
                        placeholder="ex: mini@naver.com " name="companyEmail">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">companyPwd</label>
                    <input type="password" class="form-control" id="formGroupExampleInput" placeholder="password write"
                        name="companyPwd">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">BusinessNumber</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="사업자 번호 적어"
                        name="nickName">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">companyName</label>
                    <input type="text" class="form-control" id="formGroupExampleInput"
                        placeholder="companyName" name="companyName">
                </div>
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