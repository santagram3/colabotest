<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="/resources/mypage/signUp.css">
    <!--  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!--제이쿼리  -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
    <div class="signUpcontainer">
        <div class="slogun"> 회사 회원 가입 하는 곳! </div>
        <div class="signupbox">
            <form action="/company/CompanySignUp1" method="post" class="companySignupForm">
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">companyEmail</label>
                    <input required type="email" class="form-control companyEmail" id="formGroupExampleInput"
                        placeholder="ex: mini@naver.com " name="companyEmail">
                        <button class="aaa">이메일 중복 확인</button>
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">companyPwd</label>
                    <input required type="password" class="form-control" id="formGroupExampleInput" placeholder="password write"
                        name="companyPwd">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">BusinessNumber</label>
                    <input required type="text" class="form-control" id="formGroupExampleInput" placeholder="사업자 번호 적어"
                        name="BusinessNumber">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">companyName</label>
                    <input required type="text" class="form-control" id="formGroupExampleInput" placeholder="companyName"
                        name="companyName">
                </div>
                <input required type="hidden" class="form-control" id="formGroupExampleInput" value="COMPANY"
                    placeholder="companyName" name="userGrade">
                <div class="buttongroup">
                    <button type="button" class="btn btn-success" onclick="location='/main/page';">뒤로 가기</button>
                    <button class="btn btn-info submitButton">회원가입하기</button>
                </div>
            </form>
        </div>
    </div>

    <script>
        function backhome() {
            alert("mainPage 로 이동합니다.");
            location.href = "/main/page";
        }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        $(document).ready(function () {

            const $checkArr = [false];

            const $companyEmail = document.querySelector(".companyEmail");
           

            $('.aaa').click(function () {
                console.log("aaaclick");
                console.log(" $companyEmail.value = " + $companyEmail.value);
                // 이메일 중복확인이 여기서 들어가야 한다. 비동기 요청!!
                fetch('/company/findCompanyEmail?companyEamil=' + $companyEmail.value)
                    .then(Response => Response.text())
                    .then(msg => {
                        console.log("companyEmail");
                        if (msg === 'yesCompanyEmail') {
                            console.log("yesCompanyEmail");
                            // 중복 이메일인 경우
                            alert('중복된 이메일입니다.');
                            $checkArr[0] = false;
                        } else if (msg === 'noCompanyEmail') {
                            console.log("noCompanyEmail");
                            $companyEmail.readOnly = true;
                            alert('중복 없는 이메일입니다');
                            $checkArr[0] = true;
                        }
                    });
            });
        });
        // 위에까지 성공 !! 


        // 올바르게 입력 했는지 체크 
        $('.submitButton').click(function () {
            console.log("submit click ~~~~~~~~~~~~~~~~~~~");
            e.preventdefault();

            for (let c of $checkArr) {
                    if (c === false) {
                        return;
                    }
                }
                $('.companySignupForm').submit;
            
        });
    </script>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>