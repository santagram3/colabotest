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
        <div class="logo"><a href="/test/header"><img src="/resources/header/img/skyblue.png" width="250px" alt="워커스로고"></a></div>
        <div class="headerMenu">
            <div class="menuLeft fw-bold">
                <a href="" style="color: black;">Q & A</a>
                <a href="/jobposting/list" style="color: black;">구인공고</a>
                <a href="/boast/list" style="color: black;">공부 자랑하기</a>
                <a href="" style="color: black;">스터디 구하기</a>
            </div>
            <c:if test="${loginUser == null}">
                <div class="menuRight">
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-outline-dark loginbutton" data-bs-toggle="modal"
                        data-bs-target="#staticBackdrop">
                        로그인
                    </button>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        회원가입
                    </button>
                </div>
            </c:if>
            <c:if test="${loginUser != null}">
                <div>
                    <a href="">${loginUser.nickName}님 환영합니다.</a>
                    <a href="/login/logout">로그아웃 하기</a>
                </div>
            </c:if>
        </div>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">회원 가입하기 </h5>
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
            alert("/mypage/CompanySignUp1 눌렸다");
            console.log("=========/mypage/CompanySignUp1===========");
            location.href = "/mypage/CompanySignUp1";
        }

        function MainPage() {
            location.href = "/test/header";
        }
    </script>


    <!-- 로그인 Modal -->
    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static1" data-bs-keyboard="false" tabindex="-1"
        aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <!-- 로그인 폼 태그 -->
        <form action="/login/login" method="post">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">로그인 헤더</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3 row">
                            <label for="staticEmail" class="col-sm-2 col-form-label">userEmail</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control-plaintext" id="staticEmail"
                                    placeholder="workers@workers.com" name="userEmail">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label for="inputPassword" class="col-sm-2 col-form-label">userPassword</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="inputPassword" name="userPw">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <a href="https://kauth.kakao.com/oauth/authorize?client_id=6078a2a05d3e31937245be4308a040f4&redirect_uri=http://localhost:8898/kakao/login&response_type=code"
                                class="alink"><img src="/resources/kakao/kakao_login_medium_wide.png" alt=""></a>
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
    <div class="result">
    </div>


    <script>
        $('.loginbutton').click(function () {
            console.log("123123123");
        });
    </script>
  



   <!-- 부트스트랩 자바스크립트 !-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>

</html>