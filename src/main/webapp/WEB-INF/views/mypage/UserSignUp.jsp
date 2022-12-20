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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
	
	<div class="signUpcontainerHead text-dark p-3 m-2">
	<img src="/resources/header/img/skyblue.png">
	<p class="fw-bold fs-4"><br>워커스에 오신 것을 환영합니다.</p>
	</div>
    <div class="signUpcontainer bg-light text-dark p-3 m-2">
      <!--  <div class="slogun"> 이번주 금요일에 뭐해? 취준 안해? 가입해서 자소서나 써 .. ;; </div> -->
        <div class="signupbox">
            <form action="/mypage/UserSignUp" method="post" class="signUpForm">
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label fw-bold fs-5">이메일</label>
                    <input type="email" class="form-control userEmail" id="formGroupExampleInput"
                        placeholder="ex: mini@naver.com " name="userEmail" required="required">
                    <button class="aaa btn btn-secondary mt-2">중복확인</button>
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label fw-bold fs-5">비밀번호</label>
                    <input type="password" class="form-control" id="formGroupExampleInput" placeholder="password write"
                        required="required" name="userPw">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label fw-bold fs-5">닉네임</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="아무거나 막 적어"
                        required="required" name="nickName">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label fw-bold fs-5">생년월일</label>
                    <input type="date" class="form-control" id="formGroupExampleInput"
                        placeholder="Example input placeholder" name="birthday" required="required">
                </div>
                <label for="formGroupExampleInput" class="form-label fw-bold fs-5">SelfIntroduce</label>
                <textarea class="form-control col-sm-5" rows="5" name="selfIntroduce" required></textarea>
                <div class="buttongroup">
                    <button type="button" class="btn btn-light" onclick="backhome()">뒤로 가기</button>
                    <button class="btn btn-primary submitButton">회원가입하기</button>
                </div>
                <input type="hidden" name="oauth" value="">
              
            </form>
        </div>
    </div>
    <script>
        function backhome() {
            console.log("/test/header");
            location.href = "/test/header";
        }
    </script>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        $(document).ready(function () {


            const checkEmailArr = [false];

             const $inputuserEmail = document.querySelector(".userEmail");

            console.log('$inputuserEmail = ' + $inputuserEmail);
            console.log('checkEmailArr = ' + checkEmailArr[0]);


            $('.aaa').click(function () {

                // 이메일 중복확인이 여기서 들어가야 한다. 비동기 요청!!
                fetch('/mypage/eamilcheck?userEmail=' + $inputuserEmail.value)
                    .then(Response => Response.text())
                    .then(msg => {
                        console.log("cccccccccccccccccccccccccc");
                        if (msg === 'double') {
                            console.log("double");
                            // 중복 이메일인 경우
                            
                            alert('중복된 이메일입니다.');
                            checkEmailArr[0] = false;
                        } else if (msg === 'onlyone') {
                            console.log("onlyone");
                            $inputuserEmail.readOnly=true;
                            alert('중복 없는 이메일입니다');
                            
                            checkEmailArr[0] = true;
                        }
                    });

            });
        });

        

        $('.submitButton').click(function(){
            e.preventdefault();

            if(checkEmailArr[0]==false){
                alert("아이디 중복 확인을 해주세요")
                return;
            }else if(checkEmailArr[0]==true){

                $('.signUpForm').submit;
            }
        });
        
    </script>




</body>

</html>