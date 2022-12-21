<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <!-- css -->
    <link rel="stylesheet" href="/resources/mypage/signUp.css">
    <!--  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>

    <div class="signUpcontainer">
    	<img src="/resources/header/img/skyblue.png" class="rounded mx-auto d-block">
        <div class="slogun fs-2"> 일반유저 가입하기 <span class="text-muted fs-3">Sign up</span></div>
        <hr>
        <div class="signupbox">
            <form action="/mypage/UserSignUp" method="post" class="signUpForm">
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">이메일</label>
                    <input type="email" class="form-control userEmail" id="formGroupExampleInput"
                        placeholder="ex: mini@naver.com " name="userEmail" required="required">
                    <button class="aaa btn btn-primary mt-1">중복확인</button>
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">비밀번호</label>
                    <input type="password" class="form-control" id="formGroupExampleInput" placeholder="password write"
                        required="required" name="userPw">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">닉네임</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="낙네임을 입력해주세요"
                        required="required" name="nickName">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">생년월일</label>
                    <input type="date" class="form-control" id="formGroupExampleInput"
                        placeholder="Example input placeholder" name="birthday" required="required">
                </div>
                <label for="formGroupExampleInput" class="form-label">자기소개</label>
                <textarea class="form-control col-sm-5" rows="5" name="selfIntroduce" required></textarea>
                <div class="buttongroup">
                    <button type="button" class="btn btn-link m-1" onclick="backhome()">뒤로 가기</button>
                    <button class="btn btn-secondary m-1 submitButton">회원가입하기 
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
  					<path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
					</svg>
                    </button>
                </div>
                <input type="hidden" name="oauth" value="">
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