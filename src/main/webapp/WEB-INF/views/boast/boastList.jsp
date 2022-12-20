<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<title>공부 자랑하기</title>
</head>
<header>
<%@ include file ="../header/header.jsp" %>
</header>
<body>
<!-- 게시판 형태 -->	
<div class="container">	 
<table class="table caption-top border border-light">
  <caption>공부 자랑하기</caption>
  <thead>
    <tr class="fw-bold">
      <th scope="col"></th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">작성일 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-vector-pen" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M10.646.646a.5.5 0 0 1 .708 0l4 4a.5.5 0 0 1 0 .708l-1.902 1.902-.829 3.313a1.5 1.5 0 0 1-1.024 1.073L1.254 14.746 4.358 4.4A1.5 1.5 0 0 1 5.43 3.377l3.313-.828L10.646.646zm-1.8 2.908-3.173.793a.5.5 0 0 0-.358.342l-2.57 8.565 8.567-2.57a.5.5 0 0 0 .34-.357l.794-3.174-3.6-3.6z"/>
  <path fill-rule="evenodd" d="M2.832 13.228 8 9a1 1 0 1 0-1-1l-4.228 5.168-.026.086.086-.026z"/>
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
                                <td><a href = "view/${list.BNOSP}" style="color: black;">${list.BTITLE}</a></td>
                                <td>${list.BWRITER}</td>
                                <td><fmt:formatDate value="${list.BDATE}" pattern="yyyy-MM-dd"/></td>
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
    <div class="paginate">
        <div class="paging">
            <a class="direction prev" href="javascript:void(0);"
                onclick="movePage(1,${pagination.cntPerPage},${pagination.pageSize});">
                &lt;&lt; </a> 
            <a class="direction prev" href="javascript:void(0);"
                onclick="movePage(${pagination.currentPage}<c:if test="${pagination.hasPreviousPage == true}">-1</c:if>,${pagination.cntPerPage},${pagination.pageSize});">
                &lt; </a>
 
            <c:forEach begin="${pagination.firstPage}"
                end="${pagination.lastPage}" var="idx">
                <a
                    style="color:<c:out value="${pagination.currentPage == idx ? '#cc0000; font-weight:700; margin-bottom: 2px;' : ''}"/> "
                    href="javascript:void(0);"
                    onclick="movePage(${idx},${pagination.cntPerPage},${pagination.pageSize});">
                    <c:out value="${idx}" />
                </a>
            </c:forEach>
            <a class="direction next" href="javascript:void(0);"
                onclick="movePage(${pagination.currentPage}<c:if test="${pagination.hasNextPage == true}">+1</c:if>,${pagination.cntPerPage},${pagination.pageSize});">
                &gt; </a> <a class="direction next" href="javascript:void(0);"
                onclick="movePage(${pagination.totalRecordCount},${pagination.cntPerPage},${pagination.pageSize});">
                &gt;&gt; </a>
        </div>
    </div>
    <!-- /paginate -->
 
    <div class="bottom">
        <div class="bottom-left">
            <select id="cntSelectBox" name="cntSelectBox"
                onchange="changeSelectBox(${pagination.currentPage},${pagination.cntPerPage},${pagination.pageSize});"
                class="form-control" style="width: 100px;">
                <option value="10"
                    <c:if test="${pagination.cntPerPage == '10'}">selected</c:if>>10개씩</option>
                <option value="20"
                    <c:if test="${pagination.cntPerPage == '20'}">selected</c:if>>20개씩</option>
                <option value="30"
                    <c:if test="${pagination.cntPerPage == '30'}">selected</c:if>>30개씩</option>
            </select>
        </div>
    </div>
				
	<a href="/boast/addForm" type="button" class="btn btn-primary sticky-bottom">작성하기</a>
		
		</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

<script>
//10,20,30개씩 selectBox 클릭 이벤트
function changeSelectBox(currentPage, cntPerPage, pageSize){
    var selectValue = $("#cntSelectBox").children("option:selected").val();
    movePage(currentPage, selectValue, pageSize);
    
}
 
//페이지 이동
function movePage(currentPage, cntPerPage, pageSize){
    
    var url = "${pageContext.request.contextPath}/boast/list";
    url = url + "?currentPage="+currentPage;
    url = url + "&cntPerPage="+cntPerPage;
    url = url + "&pageSize="+pageSize;
    
    location.href=url;
}
 
</script>

</html>


