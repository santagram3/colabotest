<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/resources/header/css/header.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">


</head>

<body>
    <div id="headerBox" class="shadow-sm bg-body">
        <div class="logo"><a href="/test/header"><img src="/resources/header/img/skyblue.png" width="250px" alt="workersLogo"></a></div>
        <div class="headerMenu">
            <div class="menuLeft fw-bold">
                <a href="" style="color: #5E5E5E;">Q & A</a>
                <a href="/jobposting/list" style="color: #5E5E5E;">구인공고</a>
                <a href="/boast/list" style="color: #5E5E5E;">공부 자랑하기</a>
                <a href="" style="color: #5E5E5E;">스터디 구하기</a>
            </div>
            <c:if test="${loginUser == null}">
                <div class="menuRight">
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-light text-primary text-opacity-75 loginbutton" data-bs-toggle="modal"
                        data-bs-target="#staticBackdrop">
                        구직자 로그인
                    </button>
                    <button type="button" class="btn btn-light text-success text-opacity-75 loginbutton" data-bs-toggle="modal"
                        data-bs-target="#staticBackdrop2">
                        기업 로그인
                    </button>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn " data-bs-toggle="modal" data-bs-target="#exampleModal">
                        회원가입
                    </button>
                </div>
            </c:if>
            <c:if test="${loginUser != null}">
                <div>
                	<div class="d-flex flex-column m-2 p-2">
                    	<a href="/mypage/info" style="color: black;"><small>💙 <b>${loginUser.nickName}님</b> 환영합니다.</small></a>
                   	 	<a href="/login/logout"><small>로그아웃</small></a>
                    </div>
                </div>
            </c:if>
        </div>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <p class="modal-title fs-3" id="exampleModalLabel">회원가입 </p>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body signUpbuttonGroup">
                    <button type="button" class="btn btn-outline-success" onclick="UserSignUp()">일반유저 가입하기</button>
                    <button type="button" class="btn btn-outline-info" onclick="CompanySignUp1()">기업회원 가입하기</button>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"
                        onclick="MainPage()">뒤로가기</button>
                </div>
            </div>
        </div>
    </div>

    <!-- 회원가입 폼 ! -->
    <script>
        function UserSignUp() {
            console.log("======/mypage/UserSignUp==============");
            location.href = "/mypage/UserSignUp";
        }

        function CompanySignUp1() {
            alert("/mypage/CompanySignUp2 눌렸다");
            console.log("=========/mypage/CompanySignUp1===========");
            location.href = "/company/CompanySignUp2";
        }

        function MainPage() {
            location.href = "/test/header";
        }
    </script>


    <!-- 구직자 로그인 Modal -->
    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static1" data-bs-keyboard="false" tabindex="-1"
        aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <!-- 로그인 폼 태그 -->
        <form action="/login/login" method="post">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">구직자 로그인</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3 row">
                            <label for="staticEmail" class="col-sm-2 col-form-label">이메일</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control-plaintext" id="staticEmail"
                                    placeholder="workers@workers.com" name="userEmail">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="inputPassword" name="userPw">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <a href="https://kauth.kakao.com/oauth/authorize?client_id=6078a2a05d3e31937245be4308a040f4&redirect_uri=http://localhost:8898/kakao/login&response_type=code"
                                class="alink"><img src="/resources/kakao/kakao_login.png" width="350px" class="rounded mx-auto d-block"></a> <!-- 카카오 로그인 이미지 변경 -->
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn bn-secondary" data-bs-dismiss="modal">뒤로 가기</button>
                        <button type="submit" class="btn btn-primary">로그인 하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>


     <!-- 기업 로그인 Modal -->
     <div class="modal fade" id="staticBackdrop2" data-bs-backdrop="static1" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
     <!-- 로그인 폼 태그 -->
     <form action="/login/company" method="post">
         <div class="modal-dialog">
             <div class="modal-content">
                 <div class="modal-header">
                     <h5 class="modal-title" id="staticBackdropLabel">기업 로그인</h5>
                     <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                 </div>
                 <div class="modal-body">
                     <div class="mb-3 row">
                         <label for="staticEmail" class="col-sm-2 col-form-label">comEmail</label>
                         <div class="col-sm-10">
                             <input type="text" class="form-control-plaintext" id="staticEmail"
                                 placeholder="workers@workers.com" name="companyEmail">
                         </div>
                     </div>
                     <div class="mb-3 row">
                         <label for="inputPassword" class="col-sm-2 col-form-label">comPwd</label>
                         <div class="col-sm-10">
                             <input type="password" class="form-control" id="inputPassword" name="companyPwd">
                         </div>
                     </div>
                 </div>
                 <div class="modal-footer">
                     <button type="button" class="btn bn-secondary" data-bs-dismiss="modal">뒤로 가기</button>
                     <button type="submit" class="btn btn-primary">로그인 하기</button>
                 </div>
             </div>
         </div>
     </form>
 </div>








    <!-- 부트스트랩 자바스크립트 !-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</body>

</html>