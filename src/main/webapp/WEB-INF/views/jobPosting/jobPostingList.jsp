<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="/resources/jobPosting/jobPostingList.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

  <header>
    <%@ include file ="../header/header.jsp" %>
  </header>

  <!-- 구인공고 jobPostList -->
  <div class="container">
    <div class="boardList">
      <!-- 슬라이드쇼 -->
      <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
            aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
            aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
            aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="/resources/jobPosting/img/slide/img1.png" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="/resources/jobPosting/img/slide/img2.png" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="/resources/jobPosting/img/slide/img3.png" class="d-block w-100" alt="...">
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
          data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
          data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>


      <div class="JobHostBoard">
        <h2 style="margin-top: 30px;">구인공고 게시판</h2>
        <div class="JobCategoryButton">
        </div>
        <hr>
        <p style="color: #F15F5F;" class="fw-bold fs-5">핫한 구인공고 <svg xmlns="http://www.w3.org/2000/svg" width="16"
            height="16" fill="currentColor" class="bi bi-chat-heart" viewBox="0 0 16 16">
            <path fill-rule="evenodd"
              d="M2.965 12.695a1 1 0 0 0-.287-.801C1.618 10.83 1 9.468 1 8c0-3.192 3.004-6 7-6s7 2.808 7 6c0 3.193-3.004 6-7 6a8.06 8.06 0 0 1-2.088-.272 1 1 0 0 0-.711.074c-.387.196-1.24.57-2.634.893a10.97 10.97 0 0 0 .398-2Zm-.8 3.108.02-.004c1.83-.363 2.948-.842 3.468-1.105A9.06 9.06 0 0 0 8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6a10.437 10.437 0 0 1-.524 2.318l-.003.011a10.722 10.722 0 0 1-.244.637c-.079.186.074.394.273.362a21.673 21.673 0 0 0 .693-.125ZM8 5.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132Z" />
          </svg></p></br>
        <ol class="list-group">
          <div class="d-flex flex-row justify-content-around flex-wrap">
            <c:forEach var="jp" items="${AllList}" varStatus="status">
              <li class="list-unstyled list-group-item shadow p-3 mb-5 bg-body rounded" style="width:300px;">
                <div class="ms-4 me-auto">
                  <a href="view/${jp.CNO}" class="fw-bold fs-5" style="color: black;">　${jp.CTITLE}<br>　　　　 <p
                      style="color:gray;" class="fs-6"> ${jp.CWRITER} </p></a>
                  <P style="color:gray;"><span class="badge bg-primary rounded-pill">　지원기간 |　
                      <fmt:formatDate value="${jp.CDUEDATE}" pattern="yyyy-MM-dd" /> 까지 　 </span></P>
                  <a href="delete/${jp.CNO}"><span class="text-muted"><svg xmlns="http://www.w3.org/2000/svg" width="16"
                        height="16" fill="currentColor" class="bi bi-trash3-fill" viewBox="0 0 16 16">
                        <path
                          d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z" />
                      </svg></span></a>
                </div>
              </li>
            </c:forEach>
        </ol>
      </div>
    </div>


    <hr>
    <br><br>


    <!-- 게시판 형태 -->
    <div class="container">

      <!-- /paginate -->
      <div class="d-flex flex-row-reverse flex-wrap">
        <div class="bottom mt-3">
          <p class="fs-6 p-1">목록 보여주기 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
              class="bi bi-chevron-down" viewBox="0 0 16 16">
              <path fill-rule="evenodd"
                d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z" />
            </svg></p>
          <div class="bottom-left">
            <select id="cntSelectBox" name="cntSelectBox"
              onchange="changeSelectBox(${pagination.currentPage},${pagination.cntPerPage},${pagination.pageSize}); "
              class="form-control" style="width: 100px;">
              <option value="10" <c:if test="${pagination.cntPerPage == '10'}">selected</c:if>>10개씩</option>
              <option value="20" <c:if test="${pagination.cntPerPage == '20'}">selected</c:if>>20개씩</option>
              <option value="30" <c:if test="${pagination.cntPerPage == '30'}">selected</c:if>>30개씩</option>
            </select>
          </div>
        </div>
      </div>




      <table class="table caption-top border border-light">
        <p class="fw-bold fs-5">최근 올라온 구인공고</p>
        <thead>
          <tr class="fw-bold">
            <th scope="col"></th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">공고 작성일 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                class="bi bi-vector-pen" viewBox="0 0 16 16">
                <path fill-rule="evenodd"
                  d="M10.646.646a.5.5 0 0 1 .708 0l4 4a.5.5 0 0 1 0 .708l-1.902 1.902-.829 3.313a1.5 1.5 0 0 1-1.024 1.073L1.254 14.746 4.358 4.4A1.5 1.5 0 0 1 5.43 3.377l3.313-.828L10.646.646zm-1.8 2.908-3.173.793a.5.5 0 0 0-.358.342l-2.57 8.565 8.567-2.57a.5.5 0 0 0 .34-.357l.794-3.174-3.6-3.6z" />
                <path fill-rule="evenodd" d="M2.832 13.228 8 9a1 1 0 1 0-1-1l-4.228 5.168-.026.086.086-.026z" />
              </svg></th>
            <th scope="col">공고 마감일 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                class="bi bi-stopwatch" viewBox="0 0 16 16">
                <path d="M8.5 5.6a.5.5 0 1 0-1 0v2.9h-3a.5.5 0 0 0 0 1H8a.5.5 0 0 0 .5-.5V5.6z" />
                <path
                  d="M6.5 1A.5.5 0 0 1 7 .5h2a.5.5 0 0 1 0 1v.57c1.36.196 2.594.78 3.584 1.64a.715.715 0 0 1 .012-.013l.354-.354-.354-.353a.5.5 0 0 1 .707-.708l1.414 1.415a.5.5 0 1 1-.707.707l-.353-.354-.354.354a.512.512 0 0 1-.013.012A7 7 0 1 1 7 2.071V1.5a.5.5 0 0 1-.5-.5zM8 3a6 6 0 1 0 .001 12A6 6 0 0 0 8 3z" />
              </svg></th>
          </tr>
        </thead>
        <tbody>

          <!-- <.%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
   		<.%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 		이거 맨위에 써야함 -->
          <c:choose>
            <c:when test="${fn:length(AllList) > 0}">
              <c:forEach items="${AllList}" var="list" varStatus="status">
                <tr>
                  <th scope="row">${list.ROW_NUM}</th>
                  <td><a href="view/${list.CNO}" style="color: black;">${list.CTITLE}</a></td>
                  <td>${list.CWRITER}</td>
                  <td>
                    <fmt:formatDate value="${list.CDATE}" pattern="yyyy-MM-dd" />
                  </td>
                  <td>
                    <fmt:formatDate value="${list.CDUEDATE}" pattern="yyyy-MM-dd" />
                  </td>
                </tr>
              </c:forEach>
            </c:when>
            <c:otherwise>
              <tr>
                <td colspan="4">조회된 결과가 없습니다.</td>
              </tr>
            </c:otherwise>
          </c:choose>

        </tbody>

        </tbody>
      </table>

      <!--paginate -->
      <div class="paginate text-center">
        <div class="paging p-2">
          <a class="direction prev text-muted" href="javascript:void(0);"
            onclick="movePage(1,${pagination.cntPerPage},${pagination.pageSize});">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
              class="bi bi-chevron-double-left" viewBox="0 0 16 16">
              <path fill-rule="evenodd"
                d="M8.354 1.646a.5.5 0 0 1 0 .708L2.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z" />
              <path fill-rule="evenodd"
                d="M12.354 1.646a.5.5 0 0 1 0 .708L6.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z" />
            </svg> </a>
          <a class="direction prev text-muted" href="javascript:void(0);"
            onclick="movePage(${pagination.currentPage}<c:if test=" ${pagination.hasPreviousPage==true}">-1</c:if>
            ,${pagination.cntPerPage},${pagination.pageSize});">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
              class="bi bi-chevron-left" viewBox="0 0 16 16">
              <path fill-rule="evenodd"
                d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z" />
            </svg></a>

          <c:forEach begin="${pagination.firstPage}" end="${pagination.lastPage}" var="idx">
            <a class="text-muted p-4" style="color:<c:out value=" ${pagination.currentPage==idx
              ? '#cc0000; font-weight:700; margin-bottom: 2px;' : '' }" /> "
            href="javascript:void(0);"
            onclick="movePage(${idx},${pagination.cntPerPage},${pagination.pageSize});">
            <c:out value="${idx}" />
            </a>
          </c:forEach>
          <a class="direction next text-muted" href="javascript:void(0);"
            onclick="movePage(${pagination.currentPage}<c:if test=" ${pagination.hasNextPage==true}">+1</c:if>
            ,${pagination.cntPerPage},${pagination.pageSize});">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
              class="bi bi-chevron-right" viewBox="0 0 16 16">
              <path fill-rule="evenodd"
                d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z" />
            </svg> </a> <a class="direction next text-muted" href="javascript:void(0);"
            onclick="movePage(${pagination.totalRecordCount},${pagination.cntPerPage},${pagination.pageSize});">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
              class="bi bi-chevron-double-right" viewBox="0 0 16 16">
              <path fill-rule="evenodd"
                d="M3.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L9.293 8 3.646 2.354a.5.5 0 0 1 0-.708z" />
              <path fill-rule="evenodd"
                d="M7.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L13.293 8 7.646 2.354a.5.5 0 0 1 0-.708z" />
            </svg> </a>
        </div>
      </div>

      <c:if test="${loginCompanyUser != null}" >
        <a href="/jobposting/addForm" type="button" class="btn btn-primary sticky-bottom mt-1 mb-2">작성하기</a>
      </c:if>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

<script>
  //10,20,30개씩 selectBox 클릭 이벤트
  function changeSelectBox(currentPage, cntPerPage, pageSize) {
    var selectValue = $("#cntSelectBox").children("option:selected").val();
    movePage(currentPage, selectValue, pageSize);

  }

  //페이지 이동
  function movePage(currentPage, cntPerPage, pageSize) {

    var url = "${pageContext.request.contextPath}/jobposting/list";
    url = url + "?currentPage=" + currentPage;
    url = url + "&cntPerPage=" + cntPerPage;
    url = url + "&pageSize=" + pageSize;

    location.href = url;
  }
</script>

</html>