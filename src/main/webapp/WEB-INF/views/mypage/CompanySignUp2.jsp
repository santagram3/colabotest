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
    <style>
        .ConfirmButton {
            margin-top: 5px;
        }
    </style>
</head>

<body>
    <div class="signUpcontainer">
   	 	<img src="/resources/header/img/skyblue.png" class="rounded mx-auto d-block">
        <div class="slogun fs-2"> 기업회원 가입하기 <span class="text-muted fs-3">Sign up</span></div>
        <hr>
        <div class="signupbox">
            <form action="/company/CompanySignUp1" method="post" class="companySignupForm">
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">회사 이메일</label>
                    <input required type="email" class="form-control companyEmail" 
                        placeholder="ex: mini@naver.com " name="companyEmail">
                    <button class="aaa ConfirmButton btn btn-primary btn-sm mt-1">이메일 중복 확인</button>
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">비밀번호</label>
                    <input required type="password" class="form-control" 
                        placeholder="password write" name="companyPwd">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">사업자번호</label>
                    <input required type="number" class="form-control BusinessNumber" id="BusinessNumber"
                        placeholder="- 없는 10자리 숫자를 넣으시오" name="BusinessNumber">
                    <button  class="bbb ConfirmButton btn btn-primary btn-sm mt-1">사업자번호 등록 확인</button>
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">회사 이름</label>
                    <input required type="text" class="form-control"
                        placeholder="companyName" name="companyName">
                </div>
                <input required type="hidden" class="form-control" value="COMPANY"
                    placeholder="companyName" name="userGrade">
                <div class="buttongroup">
                    <button type="button" class="btn btn-link m-1" onclick="backhome()">뒤로 가기</button>
                    <button class="btn btn-secondary m-1 submitButton">회원가입하기</button>
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

            const checkArr = [false, false];

            const $companyEmail = document.querySelector(".companyEmail");

            $('.aaa').click(function () {
                console.log("aaaclick");
                console.log(" $companyEmail.value = " + $companyEmail.value);
                // 이메일 중복확인이 여기서 들어가야 한다. 비동기 요청!!
                fetch('/company/findCompanyEmail?companyEmail=' + $companyEmail.value)
                    .then(Response => Response.text())
                    .then(msg => {
                        console.log("companyEmail");
                        if (msg === 'yesCompanyEmail') {
                            console.log("yesCompanyEmail");
                            // 중복 이메일인 경우
                            alert('중복된 이메일입니다.');
                            checkArr[0] = false;
                            console.log("checkArr[0] = "+checkArr[0]);
                            alert("checkArr[0] = "+checkArr[0]);
                        } else if (msg === 'noCompanyEmail') {
                            console.log("noCompanyEmail");
                            $companyEmail.readOnly = true;
                            alert('중복 없는 이메일입니다');
                            checkArr[0] = true;
                            console.log("checkArr[0] = "+checkArr[0]);
                            alert("checkArr[0] = "+checkArr[0]);
                        }
                    });
            });
            // 있는 이메일인지 까지 성공 !!

            // -----------------------------------------사업자번호 API--------------------------------------------------
            $('.bbb').click(function (e) {
                e.preventDefault();
                e.stopPropagation();

                const servicekey =
                    'VkkxTU5irp%2BM4wNeKK8WotKzVDETTw6EJCXoHXW9IFXSMuilgFSDZsgBdku1uyeZicBgxpHSUYroV192JP0aeA%3D%3D'; // 인증받을 서비스키
                   
                    const $BusinessNumberInput = document.querySelector('.BusinessNumber');// 인풋값 가져오기
                    const $BusinessNumber = document.getElementById('BusinessNumber').value; // 인풋값 가져오기 
                var data = {
                    "b_no": [$BusinessNumber] // 사업자번호 "xxxxxxx" 로 조회 시,
                };
                $.ajax({
                    url: "https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=" + servicekey, // serviceKey 값을 xxxxxx에 입력
                    type: "POST",
                    data: JSON.stringify(data), // json 을 string으로 변환하여 전송
                    dataType: "JSON",
                    contentType: "application/json",
                    accept: "application/json",
                    success: function (result) {
                        console.log("$BusinessNumber = " +$BusinessNumber);
                        if (result.data[0].tax_type === '국세청에 등록되지 않은 사업자등록번호입니다.') {
                            checkArr[1] = false;
                            console.log("checkArr[1] = " + checkArr[1]);
                            alert('국세청에 등록되지 않은 사업자등록번호입니다. checkArr[1] = ' + checkArr[1] );
                        } else {
                            checkArr[1] = true;
                            alert(" checkArr[1] = " + checkArr[1]);
                            console.log("checkArr[1] = " + checkArr[1]);
                            $BusinessNumberInput.readOnly = true;
                        }
                    },
                    error: function (result) {
                        console.log(result.responseText); //responseText의 에러메세지 확인
                    }
                });

            });
           

            const submitButton = document.querySelector('.submitButton');

            // sign-up 버튼 클릭 이벤트
            submitButton.addEventListener('click', e => {
                e.preventDefault();

                console.log("submit click ~~~~~~~~~~~~~~~~~~~");
                console.log("submitButtonClick =  checkArr[0] = " , checkArr[0] + "  checkArr[1] = " , checkArr[1]);
             

                for (let c of checkArr) {
                    console.log(c);
                    if (c === false) {
                        return;
                    }
                }
                $('.companySignupForm').submit();
            }); // end sign-up 클릭 이벤트



        });
    </script>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>