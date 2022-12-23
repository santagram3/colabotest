<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>mainPage</title>
</head>
<body>

    <Header>
     <%@ include file="/WEB-INF/views/header/header.jsp" %> 
    </Header>
    <div class="container">
    			
<!-- 메인페이지 이미지영역 -->
  <div class="card text-bg-dark">
 	<img src="/resources/main/workers_hello.png" class="card-img" alt="...">
  	<div class="card-img-overlay">
  		<div class="container">
   			 <p class="card-title text-white fs-1 fw-bold">WORKERS MAINPAGE</p>
    			<p class="card-text text-white"><b>직장인·취준생들의 소셜미디어 워커스 입니다 :)</b></p>
    			<p class="card-text text-white">
    			나에게 딱 맞는 커리어만 매치! 워커스에서 새로운 기회를 제안 받고 기업정보, 공부 자랑하기 등 취업, 채용에 꼭 필요한 정보를 확인해보세요.
    			</p>
    	</div>
  	 </div>
  </div>
	 <hr>
    		
<!-- 메인페이지 구인공고영역-->
	<p style="color: #F15F5F;" class="fw-bold fs-4 mt-5">마감임박 구인공고 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chat-heart" viewBox="0 0 16 16">
  	<path fill-rule="evenodd" d="M2.965 12.695a1 1 0 0 0-.287-.801C1.618 10.83 1 9.468 1 8c0-3.192 3.004-6 7-6s7 2.808 7 6c0 3.193-3.004 6-7 6a8.06 8.06 0 0 1-2.088-.272 1 1 0 0 0-.711.074c-.387.196-1.24.57-2.634.893a10.97 10.97 0 0 0 .398-2Zm-.8 3.108.02-.004c1.83-.363 2.948-.842 3.468-1.105A9.06 9.06 0 0 0 8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6a10.437 10.437 0 0 1-.524 2.318l-.003.011a10.722 10.722 0 0 1-.244.637c-.079.186.074.394.273.362a21.673 21.673 0 0 0 .693-.125ZM8 5.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132Z"/>
	</svg></p></br>
		<ol class="list-group"> <div class="d-flex flex-row justify-content-between flex-wrap">
			<c:forEach var="jp" items="${duelist}" varStatus="status">
				<li class="list-unstyled list-group-item shadow p-3 mb-5 bg-body rounded" style="width:300px;">
					 <div class="ms-4 me-auto">
					      <a href = "../jobposting/view/${jp.cno}" class="fw-bold fs-5" style="color: black;">　${jp.cTitle}<br>　　　　  <p style="color:gray;" class="fs-6"> ${jp.cWriter} </p></a>
					      <P style="color:gray;"><span class="badge bg-primary rounded-pill">　지원기간  |　 <fmt:formatDate value="${jp.cDueDate}" pattern="yyyy-MM-dd"/> 까지   　 </span></P>
					    </div>
				</li>
		     </c:forEach>
		 </ol>
	<hr>			 
	
	<c:choose>
	     <c:when test="${fn:length(mainBoastList) > 0}">
          <c:forEach items="${mainBoastList}" var="list" varStatus="status">
            <tr>
                <td><img src="/img/boast/${list.getBImage()}" alt=""></td>
                <td>${list.getBTitle()}</td>
                <td>${list.getBWriter()}</td>
                <td>${list.getCount()}</td>
            </tr>
          </c:forEach>
        </c:when>
        <c:otherwise>
          <tr>
            <td colspan="4">조회된 결과가 없습니다.</td>
          </tr>
        </c:otherwise>
      </c:choose>
      
	</div>
</body>
</html>