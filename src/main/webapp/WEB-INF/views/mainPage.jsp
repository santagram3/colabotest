<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    
    <h1>
       MAINPAGE
    </h1>
    
    			<hr>
			<p style="color: #F15F5F;" class="fw-bold fs-5">핫한 구인공고 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chat-heart" viewBox="0 0 16 16">
  			<path fill-rule="evenodd" d="M2.965 12.695a1 1 0 0 0-.287-.801C1.618 10.83 1 9.468 1 8c0-3.192 3.004-6 7-6s7 2.808 7 6c0 3.193-3.004 6-7 6a8.06 8.06 0 0 1-2.088-.272 1 1 0 0 0-.711.074c-.387.196-1.24.57-2.634.893a10.97 10.97 0 0 0 .398-2Zm-.8 3.108.02-.004c1.83-.363 2.948-.842 3.468-1.105A9.06 9.06 0 0 0 8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6a10.437 10.437 0 0 1-.524 2.318l-.003.011a10.722 10.722 0 0 1-.244.637c-.079.186.074.394.273.362a21.673 21.673 0 0 0 .693-.125ZM8 5.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132Z"/>
			</svg></p></br>
			<ol class="list-group"> <div class="d-flex flex-row justify-content-around flex-wrap">
					<c:forEach var="jp" items="${duelist}" varStatus="status">
					  <li class="list-unstyled list-group-item shadow p-3 mb-5 bg-body rounded" style="width:300px;">
					    <div class="ms-4 me-auto">
					      <a href = "../jobposting/view/${jp.cno}" class="fw-bold fs-5" style="color: black;">　${jp.cTitle}<br>　　　　  <p style="color:gray;" class="fs-6"> ${jp.cWriter} </p></a>
					      <P style="color:gray;"><span class="badge bg-primary rounded-pill">　지원기간  |　 <fmt:formatDate value="${jp.cDueDate}" pattern="yyyy-MM-dd"/> 까지   　 </span></P>
						 
					    </div>
					  </li>
					  </c:forEach>
					 </ol>
    
</body>
</html>